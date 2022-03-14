package com.company.jihe;







/*
一 集合框架的概述
1 集合数组都是对多个数据进行存储操作的结构 简称java容器
     说明 此时的存储主要指的是内存层面的存储 不涉及到持久化的存储
2 数组在存储多个数据上的特点
    >一旦初始化 长度就确定了
    >定义数组需要指明数组类型，一旦定义好 元素的类型也就确定了
    缺点：
            初始化之后 长度不可修改 不方便
            数组提供的方法有限
             获取数组中实际元素个数大的需求 没有现成的属性或者方法
             数组存储数据的特点：有序 可重复 对于无序的需求 数组是无法满足的

二 集合框架
       Collection接口 单列集合 用来存储一个一个大的对像
            >list  存储有顺序的  不重复的数据   动态数组
                    >Arraylist LinkList Vector
           > set 存储无顺序 可重复的数据       高中学过的集合 无序 不重复 确定 互异
                    >hashset LinkHashSet  TreeSet
       Map 接口   存储双列集合 用来存储一对数据 key - value     类似python 字典
                    >hashMap LinkHashMap TreeMap Hashtable Properties

三 Collection 接口中的方法使用

 */


import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;


public class CollectionTest {
    @Test
    public  void test1(){
        Collection coll=new ArrayList();
        // add()  把元素加到集合
        coll.add("湖南");
        coll.add("河南");
        coll.add("河北");
        coll.add("宁夏");
        coll.add("四川");
        coll.add("北京");
        // size  获取集合中元素的个数
        System.out.println(coll.size());

        // addALL（coll1）; 将coll1中的元素添加到当恰当的集合中
        Collection coll1=new ArrayList () ;
        coll1.addAll(Collections.singleton(456));
        coll1.addAll(Collections.singleton("青海"));
        coll.addAll(coll1);
        System.out.println(coll.size());
        System.out.println(coll);

        //clear();清空集合元素
        coll.clear();
        // isEmpty()  判断当前集合是否有元素
        System.out.println("判断集合是否为空"+coll.isEmpty());

    }
    @Test
    public void test2(){
        Collection coll =new ArrayList();


        coll.add("湖南");
        coll.add("河南");
        coll.add(new String("Tom"));
        coll.add("宁夏");
        coll.add("四川");
        coll.add("北京");
        coll.add(new Person("海福生",20));
        // contains(Object obj)  判断集合是否包含obj  调用obj所在类的equals方法 通常要重写equals方法
        boolean contains=coll.contains("湖南");
        System.out.println(contains);
        System.out.println(coll.contains(new String("tom")));
        System.out.println(coll.contains(new Person("海福生",20)));
        //containAll（coll1）  判断coll11中的元素是否都在coll中
        Collection coll1= Arrays.asList("河南","湖南" );
        System.out.println("coAll"+coll.containsAll(coll1));

    }
    @Test
    public void test3(){
        Collection coll =new ArrayList();


        coll.add("湖南");
        coll.add("河南");
        coll.add(new String("Tom"));
        coll.add("宁夏");
        coll.add("四川");
        coll.add("北京");
        coll.add(new Person("海福生",20));
        //remove 从当前集合移除元素 删除成功返回true
        coll.remove("湖南");
        System.out.println("移除之后"+coll);
        System.out.println();
        // removeAll(coll1) 从当前集合移除coll1中所有的元素
        // retainAll(coll1)  求交集 直接修改当前的集合
        //equals(Object obj)  对比两个集合是否完全相同 顺序值都要相同
        //hashCode() 返回当前对象的哈希值
        // 集合-- > 数组
       Object[] arr=coll.toArray();
       for(int i=0;i<arr.length;i++){
           System.out.println(arr[i]);
       }
       // 数组-->集合 调用arrays的静态方法asList()
      List<String> list=Arrays.asList(new String[]{"aa","bb","cc"});
        System.out.println(list);
        //iterator () 返回iterator接口的实例 用于遍历集合元素
    }





}
