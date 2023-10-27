package cpj.BookSystem;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        int n=scanner.nextInt();
//        int k=scanner.nextInt();
//        int[] a= new int[k];
//        int[] b= new int[n-k];
//        for (int i = 0; i < k; i++) {
//            Random random = new Random();
//            a[i]= random.nextInt(100);
//            System.out.printf(a[i]+"\t");
//        }
//        System.out.println(" ");
//        for (int i = 0; i < k-1; i++) {
//            for (int j = 0; j < k-1-i; j++) {
//                if(a[j]<a[j+1]){//逆序
//                    int temp=a[j+1];
//                    a[j+1]=a[j];
//                    a[j]=temp;
//                }
//            }
//        }
//        System.out.println("排序之后的数组a：");
//        for (int i = 0; i < k; i++) {
//            System.out.printf(a[i]+"\t");
//        }
//        System.out.println(" ");
//        System.out.println("随机的数组b：");
//        for (int i = 0; i < n-k; i++) {
//            Random random = new Random();
//            b[i]=random.nextInt(1000);
//            System.out.printf(b[i]+"\t");
//        }
//        System.out.println(" ");
//        for (int i = 0; i < n-k; i++) {
//            if(b[i]>a[k-1]){
//                a[k-1]=b[i];
//                for (int j = k-2; j >= 0; j--) {
//                    if(a[j]<a[j+1]){
//                        int temp=a[j+1];
//                        a[j+1]=a[j];
//                        a[j]=temp;
//                    }
//                }
//            }
//        }
//        System.out.println("最后的数组a：");
//        for (int i = 0; i < k; i++) {
//            System.out.printf(a[i]+"\t");
//        }
//        System.out.println(" ");
//        System.out.println(a[k-1]);
//        BigInteger a=Check.value(31,new Random(20));
//        System.out.println(a);
//        prime.weather(a);
        person p= new person.builder(2021110001,"李四").Sex("男").Age(19).Address("学院街65号").b();
    }
}
//class Check{
//    public static Boolean valueof(boolean b){
//        return b ? Boolean.TRUE:Boolean.FALSE;
//    }
//    public static BigInteger value(int a,Random c){
//        return BigInteger.probablePrime(a,c);
//        //3:7,4:11,5:19
//    }
//}
//class prime{
//    public static void weather(BigInteger a){
//        for (int i = 2; i <Math.sqrt(Double.valueOf(a.toString())) ; i++) {
//            if(Integer.valueOf(a.toString())%i==0){
//                System.out.println("i="+i+",a="+a);
//                break;
//            }
//        }
//    }
//}
class person{
    private int id;
    private String name;
    private int age;
    private String sex;
    private String address;
    private String occupation;
    public static class builder{
        private int id=2021110000;
        private String name="张三";
        private int age=18;
        private String sex="男";
        private String address="川商";
        private String occupation="学生";
        public builder(int id,String name){//构造函数的参数为必选参数，其他为可选参数
            this.id=id;
            this.name=name;
        }
        public builder Age(int age){
            this.age=age;
            return this;
        }
        public builder Sex(String sex){
            this.sex=sex;
            return this;
        }
        public builder Address(String address){
            this.address=address;
            return this;
        }
        public builder Occupation(String occupation){
            this.occupation=occupation;
            return this;
        }
        public person b(){
            return new person((this));
        }
    }
    private person(builder buil){
        id=buil.id;
        name=buil.name;
        age=buil.age;
        sex=buil.sex;
        address=buil.address;
        occupation=buil.occupation;
    }
}
