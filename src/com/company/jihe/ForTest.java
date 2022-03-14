package com.company.jihe;

/*
jdk 5.0新增的foreach循环 用于遍历数组集合

 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

public class ForTest {
    @Test
    public void  test1(){
        Collection coll =new ArrayList();


        coll.add("湖南");
        coll.add("河南");
        coll.add(new String("Tom"));
        coll.add("宁夏");
        coll.add("四川");
        coll.add("北京");
        coll.add(new Person("海福生",20));
        // for 第一个元素是对像 集合中什么元素 前面就要定义成索什么元素 （集合元素类型 局部变量 ： 集合对象）
       //内部  任然调用迭代器
        for(Object obj:coll){
            System.out.println(obj );

        }
    }
    @Test
    public void test2(){
        int [] arr=new int[]{1,2,3,4,6,7,8};
        for(int i:arr){
            System.out.println(i);
        }
    }

    @Test
    public void test3(){
        String[] arr=new String[]{"as","as","as"};
        // 普通for 循环
//        for (int i=0;i<arr.length;i++){
//            arr[i]="GG";
//        }
        // 增强for循环  修改他不会修改原有数组中的数据
        for(String s:arr){
            s="GG";
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }

    }

}
