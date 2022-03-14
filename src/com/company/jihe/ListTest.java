package com.company.jihe;
/*
Collection接口 单列集合 用来存储一个一个大的对像

        >list  存储有顺序的  不重复的数据   动态数组
        Arraylist  主要实现类 线程不安全的 效率高 底层使用Object[]存储
        LinkList  对于频繁插入删除的操作，使用该类的效率高   底层使用双向链表
        Vector  古老实现类  线程安全 效率低 底层使用Object[] 存储



面试题： Arraylist LinkedList Vector三者异同
同：三个类都实现了list接口 存储数据的特点相同 重复 有顺序
不同 ： Arraylist  主要实现类 线程不安全的 效率高 底层使用Object[]存储
        LinkList  对于频繁插入删除的操作，使用该类的效率高   底层使用双向链表
        Vector  古老实现类  线程安全 效率低 底层使用Object[] 存储

        Arraylist的原码分析：jdk7：
        Arraylist list=new Arraylist()   // 创建了底层长度是10 的object[]数组
        结论： 建议开发中使用带参数的构造器
                            jdk8:
 */


import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {
    @Test
    public void test(){
        ArrayList list=new ArrayList();
        list.add(123);
        list.add(456);
        list.add("AA");
        list.add(new Person("tom",30));
        list.add(456);
        list.add(123);

        System.out.println(list.toString());
        // add  插入元素到第n个位置
        list.add(1,"sb");
        System.out.println(list);

        // boolean addAll (int idenx, Collection else): 从index开始将else中的元年苏全部添加
        List list1= Arrays.asList(1,2,3);
        list.addAll(list1);
        System.out.println(list.size());

        //indexOf(obj) 返回obj在当前集合中 首次出现的位置  不存在返回-1
        System.out.println("indexOf"+list.indexOf(456));
        //lastindexOf   返回最后出现的 位置
        System.out.println("last"+list.lastIndexOf(123));
        // remove  移除指定位置的元素
        list.remove(6);
        System.out.println(list);
        // set 指定元素
        list.set(0,"啊是巨大损失吧");
        System.out.println(list);

        //list sublist(a,b)   返回从a到b位置左闭右开 去区间的值
        System.out.println(list.subList(1,3));

    }


}
