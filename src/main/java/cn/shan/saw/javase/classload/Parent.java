package cn.shan.saw.javase.classload;

/**
 * Created by shanlehong on 2017/3/29.
 */
public class Parent {
    // 静态变量
    public static String p_StaticField = "父类--静态变量";
    // 变量(其实这用对象更好能体同这一点，如专门写一个类的实例)

    //如果这个变量放在初始化块的后面，是会报错的，因为你根本没有被初始化
    public String p_Field = "父类--变量";
    // 静态初始化块
    static {
        System.out.println(p_StaticField);
        System.out.println("父类--静态初始化块");
    }
    // 初始化块
    {
        System.out.println(p_Field);
        System.out.println("父类--初始化块");
    }
    // 构造器
    public Parent() {
        System.out.println("父类--构造器");
    }
}
