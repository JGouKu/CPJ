package com.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

/**
 * 该反射程序可以打印出一个类的公共构造器,方法以及字段
 */
public class Reflection {
    public static void main(String[] args) throws ClassNotFoundException {
        String name;
        if(args.length>0)//从命令行参数或用户输入中读取类名
            name = args[0];
        else {
            Scanner in = new Scanner(System.in);
            System.out.println("输入一个类名(e.g. java.util.Date):");
            name = in.next();
        }
        Class cl = Class.forName(name);//返回一个名为name的类
        Class supercl = cl.getSuperclass();//返回这个类的超类
        String modifier = Modifier.toString(cl.getModifiers());//获取类的修饰符
        if(modifier.length()>0)//如果有就输出修饰符
            System.out.print(modifier+" ");
        System.out.print("class "+name);//打印一个clss 加上类名
        if(supercl !=null && supercl != Object.class)//如果有超类,且不是Object类
            System.out.print("extends "+supercl.getName());
        System.out.print("{\n");
        printConstructors(cl);//输出构造函数
        System.out.println();
        printMethods(cl);//输出方法
        System.out.println();
        printFields(cl);//输出字段
        System.out.println("}");
    }
    public static void printConstructors(Class cl){
        Constructor[] constructor =cl.getConstructors();//获得所有构造器,放入一个构造器数组里
        //遍历每一个构造器
        for (Constructor con:constructor) {
            System.out.println("\t");//打印一个缩进
            String name = con.getName();//获得构造器名字
            /**
             * getModifiers()用不同位上的0/1来表示该类修饰符的情况,如public和static
             *  使用Modifier类中的isPublic,isPrivate或isFinal可以判断修饰符
             *  使用Modifier类中的toString()方法则可以将修饰符打印出来
             */
            String modifier = Modifier.toString(con.getModifiers());//将修饰符转为字符串赋给modifier
            if(modifier.length()>0)//如果有修饰符就打印出来
                System.out.print(modifier+" ");//取消换行
            System.out.print(name+"(");//打印构造器的名字,并把括号前半截打印出来
            //打印参数类型
            Class[] parameterTypes = con.getParameterTypes();//获取这个构造器的所有参数类型,并放入一个类型数组里
            for (int i = 0; i < parameterTypes.length; i++) {
                if(i>0) //如果i>0,说明前面已经打印了一个参数,需要添加逗号分开
                    System.out.print(", ");//取消换行
                System.out.print(parameterTypes[i].getName());//只需要打印参数类型,不用知道参数名叫什么
            }
            System.out.println(");");//所有参数已经遍历完了,补上后半截括号和最后的分号
        }
    }
    public static void printMethods(Class cl){
        Method[] methods = cl.getMethods();//获取类中所有的方法,放入一个方法数组里
        //遍历每一个方法
        for (Method m:methods) {
            System.out.println("\t");
            String name = m.getName();//获得方法m的名字
            String modifier = Modifier.toString(m.getModifiers());//获得方法的修饰符
            if(modifier.length()>0)
                System.out.print(modifier+" ");//打印出修饰符
            System.out.print(name+"(");//打印方法名
            Class[] parameterTypes = m.getParameterTypes();//将所有参数类型放入一个class数组里
            for (int i = 0; i < parameterTypes.length; i++) {
                if(i>0)
                    System.out.print(", ");
                System.out.print(parameterTypes[i].getName());//打印类型名
            }
            System.out.println(");");
        }
    }
    public static void printFields(Class cl){
        Field[] fields = cl.getFields();//获得类中所有的字段名,放入字段数组里
        for (Field f:fields) {
            System.out.println("\t");
            Class type = f.getType();//获取字段类型
            String name = f.getName();
            String modifier = Modifier.toString(f.getModifiers());
            if (modifier.length()>0)
                System.out.print(modifier+" ");//打印修饰符
            System.out.println(type.getName()+" "+name+";");//打印字段名
        }
    }
}

