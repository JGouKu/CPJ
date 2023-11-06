package com.Test;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.ArrayList;

/**
 * 这同样是一个反射的.java文件
 * 相较于前一个的只能靠输入具体的类来访问
 * 此方法可以通过一个实例化的对象传参访问
 * 访问该对象具体隶属于哪个类型,对应每个变量属于哪种类型
 * 每种类型的值属于什么类型,值为多少,变量的容量有多大
 */
public class ObjectAnalyzer{
    public static void main(String[] args) throws ReflectiveOperationException {
        ArrayList<Integer> squares = new ArrayList<>();//新建一个Integer类型的数组列表
        for (int i = 0; i < 5; i++) {
            squares.add(i*i);
        }
        System.out.println(new Analyzer().toString(squares));
    }
}

 class Analyzer {
    private ArrayList<Object> visited = new ArrayList<>();
    public String toString(Object obj) throws ReflectiveOperationException {//重写toString方法
        if(obj==null)//先判断传入的对象是否为空
            return "null";
        if(visited.contains(obj))//判断数组列表中是否有这个对象,避免重复输出
            return "...";//重复对象以省略号输出
        visited.add(obj);//添加对象
        Class cl = obj.getClass();//获取对象类型
        if(cl==String.class)//判断是不是字符串类型的对象
            return (String)obj+"\n";
        if(cl.isArray()){//判断是不是数组类型
            String r= cl.getComponentType()+"[]\n{\n";//获取数组类型
            for (int i = 0; i < Array.getLength(obj); i++) {
                if(i>0)//表示已经输出了第一个元素,打逗号隔开
                    r+=",\n";
                Object val = Array.get(obj,i);//获取数组指定位置的值
                if(cl.getComponentType().isPrimitive())//如果这个值是基本数据类型,直接加
                    r+=val;
                else
                    r+=toString(val);//否则递归
            }
            return r+"\n}";
        }
        String r = cl.getName();//表示排除了null对象,重复对象,字符串类型以及数组
        do{
            r+="[";
            Field[] fields = cl.getDeclaredFields();//获取所有字段放入字段数组中
            AccessibleObject.setAccessible(fields,true);//给数组提供访问权限
            for(Field f : fields){//遍历
                if(!Modifier.isStatic(f.getModifiers())){//如果不是静态字段
                    if(!r.endsWith("["))//末尾不是[,表示已经添加了字段
                        r+=", \n";
                    r+=f.getName()+"=";//字段名+等号 ,表示f.getName表示值结果会表示为value
                    Class t = f.getType();//获取字段类型
                    Object val = f.get(obj);//获取字段的值
                    if(t.isPrimitive())//判断是否为基本数据类型
                        r+=val;
                    else//否则递归
                        r+=toString(val);
                }
            }
            r+="]";
            cl=cl.getSuperclass();//在最末尾设置类型为超类,第一遍循环结束时顺便判断是否还有超类
        }while (cl!=null);//有超类直接进入下一次循环
        return r;
    }
}
