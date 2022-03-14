package com.company.jihe;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/*
集合元素遍历

 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll=new ArrayList();
        coll.add("湖南");
        coll.add("河南");
        coll.add(new String("Tom"));
        coll.add("宁夏");
        coll.add("四川");
        coll.add("北京");
        coll.add(new Person("海福生",20));
        Iterator iterator=coll.iterator();

//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
        //开发中不推荐这样写
//    for(int i=0;i< coll.size();i++){
//        System.out.println(iterator.next());
//    }
    //推荐
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
