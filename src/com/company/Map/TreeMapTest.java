package com.company.Map;

import org.junit.Test;

import java.util.*;

public class TreeMapTest {

/**
 *
 * 向treemap添加key value key必须是一个类创建的对象
 * //key 排序
* */

    @Test
        public void test(){
        TreeMap treeMap=new TreeMap();
        User u1=new User("tom",23);
        User u2=new User("jerry",12);
        User u3=new User("jack",2);
        User u4=new User("hfs",3);
        User u5=new User("ys",230);


        treeMap.put(u1,98);
        treeMap.put(u2,99);
        treeMap.put(u3,10);
        treeMap.put(u4,58);
        treeMap.put(u5,34);

        Set entrySet=treeMap.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }



    }


    @Test
    public void test2(){
        TreeMap treeMap=new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof  User){
                    User u1=(User) o1;
                    User u2=(User) o2;
                    return Integer.compare(u1.getAge(), u2.getAge());
                }
                throw new RuntimeException("输入错误");
            }
        });

        User u1=new User("tom",23);
        User u2=new User("jerry",12);
        User u3=new User("jack",2);
        User u4=new User("hfs",3);
        User u5=new User("ys",230);


        treeMap.put(u1,98);
        treeMap.put(u2,99);
        treeMap.put(u3,10);
        treeMap.put(u4,58);
        treeMap.put(u5,34);

        Set entrySet=treeMap.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while (iterator1.hasNext()){
            System.out.println(iterator1.next());
        }

    }
}
