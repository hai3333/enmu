package com.company.Map;

import org.junit.Test;

import java.util.*;

public class CollectionTest  {
    /**
     *Collections提供了多个synchronizedXXX()方法
     * 该方法可以让指定的集合包装成线程同步的集合 从而可以解决多线程
     * 并发访问集合的线程安全问题
     *
     *
    * */



    @Test
    public void test(){

        List list=new ArrayList();
        list.add(12);
        list.add(34);
        list.add(1244);
        list.add(1244);
        list.add(-1);
        list.add(0);

        //List dest=new ArrayList();
        List dest = Arrays.asList(new Object[list.size()]);


        System.out.println(list);

      // Collections.reverse(list);  排序
      //  Collections.shuffle(list);  随机
        //Collections.sort(list);   //inter 那个类排序
        int frequency = Collections.frequency(list,1244);// 返回出现几次

        System.out.println(frequency);
       // System.out.println(list);

       Collections.copy(dest,list);  // 报错 dest要撑开
        System.out.println(dest);

        List list1=Collections.synchronizedList(list);


    }
}
