package com.Test;

/**
 * 这个.java文件示范的是在枚举类中定义一个对象的成员变量设置为枚举常量
 * 实例化的枚举类成功的引用了其位置上的实例化对象,并且实现了对其的输出修改
 */
public class ExamplesOfEnum {
    public static void main(String[] args) throws InterruptedException {
        eNum[] staff = eNum.values();
        eNum staff1 = staff[1];
        System.out.println("输出a+b:"+staff1.getOP());
        System.out.println("输出a:"+staff1.getOP().getA());
        System.out.println("输出b:"+staff1.getOP().getB());
        staff1.getOP().setA(3);
        System.out.println("输出新的a:"+staff1.getOP().getA());
        System.out.println("输出新的a+b:"+staff1.getOP());
        System.out.println("输出常量名:"+staff1);
        System.out.println("输出其位置:"+staff1.ordinal());

    }
}
enum eNum{
    Mon(new Employee(1),1),Tue(new Employee(1,2),2),Wen(new Employee(1,"hello"),3);
    private final Employee week;
    private final int a;
    eNum(Employee week,int a){
        this.week=week;
        this.a=a;
    }
    public Employee getOP(){
        return week;
    }
}
class Employee {
    private int a=0;
    private int b=0;
    private String string="1";
    public Employee(){

    }
    public Employee(int a){
        this.a=a;
    }
    public Employee(int a,int b){
        this.a=a;
        this.b=b;
    }
    public Employee(int a,String string){
        this.a = a;
        this.string=string;
    }
    public int getA(){
        return a;
    }
    public int getB(){
        return b;
    }
    public void setA(int a){
        this.a=a;
    }
    public String toString(){
        return a+"+"+b;
    }
}