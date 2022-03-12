package com.company.zhujie;

/*
注解的使用
1.理解Annotation:
jdk 5.0 新增的
示例一： 生成文档的相关解释
示例二： 在编译时进行 格式检查
@Override
@Deprecated
@SuppressWarnings 抑制编译器警告

示例三：跟踪代码依赖性 实现替代配置文件

3 如何自定义注解  参照@SuppressWarnings
  注解声明为@interface
   内部成员的定义通常用value表实
   可以指定成员的默认值 使用default定义
   如果 自定义的注解没有成员 表明一个标示作用
        如果注解有成员 在使用注解时 须指明成员的变量
        自定义注解必须搭配上注解的信息处理流程（使用反射）才有意义
        自定义注解通常都会指明两个元注解 Retention Target

4 jdk提供的四种元注解
对现有的注解解释说明的
jdk5.0提供了四种标准的元注解类型 分别是：
Retention  ：指定所修饰的Annotation的生命周期 ：SOURCE\CLASS(默认行为)\RUNTIME  只有神明为runtime 才能通过反射获取
Target ：用于指定被修饰的Annotation 能用于修饰哪些程序元素
Documented  表实所修饰的注解在被javadoc  解析的时候会留下来
Inherited 被他修饰的注解具有继承性


5 通过反射获取注解信息


6 jdk 8中注解的新特性:可重复注解 类型注解
6.1  可重复注解
jdk 8 之前 建立注解数组   之后 在myannotation上声名Repeatable ，成员值为MyAnnotation.class

6.2 类型注解


 */


import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

public class AnnotationTest {
    public static void main(String[] args) {
        Student student = new Student();
        student.show();
        @SuppressWarnings("unused")
        int m = 4;

    }

}


@MyAnnotation()
class Person{
    private String name;
    private  int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public  void  walk(){
        System.out.println("人走路");
    }
    public void eat(){

        System.out.println("人吃饭");
    }
}

interface  Info{
    void show();
    }



class Student extends  Person implements Info{
    @Override
    public void walk(){
    System.out.println("学生走路");

}

    @Override
    public void show() {
        System.out.println("这是重写的show");
    }
}
