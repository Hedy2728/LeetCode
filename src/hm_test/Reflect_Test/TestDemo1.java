package hm_test.Reflect_Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JOptionPane;

    /**
     * 通过用户输入类的全路径，来获取该类的成员方法和属性
     * Declared获取全部不管是私有和公有
     * 1.获取访问类的Class对象
     * 2.调用Class对象的方法返回访问类的方法和属性信息
     **/

    public class TestDemo1 {

        /*
         * 构造方法
         */
        public TestDemo1(){
            //用户输入类的全路径径
            //使用String组件
            String classpsth=JOptionPane.showInputDialog(null,"输入类的全路径");
            //使用Class.forName方法根据输入的类的全路径 返回该类的Class对象
            try {
                Class cla = Class.forName(classpsth);
                //利用Class对象的cla的自审,返回方法对象集合
                Method [] method=cla.getDeclaredMethods(); //返回所有的方法
                System.out.println("========获取方法信息============");
                for (Method meth : method) {
                    //遍历method数组，并输出方法信息
                    System.out.println(meth.toString());
                }
                System.out.println("========获取出方法信息结束============");
                //获取属性利用Class对象的cla的自审,返回成员属性对象集合
                Field [] field=cla.getDeclaredFields();
                System.out.println("========获取成员属性信息============");
                for (Field f : field) {
                    System.out.println(f.toString());
                }
                System.out.println("========获取成员属性信息结束============");
                //获取属性利用Class对象的cla的自审,返回构造方法集合
                Constructor [] constructor=cla.getDeclaredConstructors();
                System.out.println("========获取成员构造方法信息============");
                for (Constructor constru : constructor) {
                    System.out.println(constru.toString());
                }
                System.out.println("========获取成员构造方法信息结束============");
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                System.out.println("路径输入错误！");
            }
        }
    }
class TestReflection {
    public static void main(String[] args) {
        TestDemo1 rd=new TestDemo1();

    }
}