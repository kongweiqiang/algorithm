package com.kwq.algorithm.algorithmics.basic;

/**
 * @auther : kongweiqiang
 * @DATE : 2020/10/28
 * @DESC :
 */
public class Equal {

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");//两个对象
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;//字符串的+操作其本质是创建了StringBuilder对象进行append操作，然后将拼接后的StringBuilder对象用toString方法处理成String对象
        System.out.println(s1 == s2);//false
        System.out.println(s1 == s5);//true
        System.out.println(s1 == s6);//false:StringBulider实现
        System.out.println(s1 == s6.intern());//true
        System.out.println(s2 == s2.intern());//false

        System.out.println("----------intern----------");
        //String对象的intern方法会得到字符串对象在常量池中对应的版本的引用(如果常量池中有一个字符串与String对象的equals结果是true)，如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用
        String s7 = new StringBuilder("go").append("od").toString();
        System.out.println(s7.intern() == s7);//true
        String s8 = new StringBuilder("ja").append("va").toString();
        System.out.println(s8.intern() == s8);//false

        System.out.println("----------拆装箱----------");
        Integer a = new Integer(3); Integer b = 3; // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b); // false 两个引用没有引用同一对象
        System.out.println(a == c); // true a自动拆箱成int类型再和c比较
        System.out.println(b == c); // true b自动拆箱成int类型再和c比较

        System.out.println("----------方法区常量池缓存:IntegerCache:[-128,+127]----------");
        Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;
        System.out.println(f1 == f2);//true
        System.out.println(f3 == f4);//false
    }
}
