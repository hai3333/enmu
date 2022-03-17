package com.company.jihe;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.UUID;

public class TreeSetTest {

    /**
     * 1。treeset中的对象必须是同类
     * 比较的不用equals
     * 2 两种排序 自然排序(实现comparable接口)和定制排序(comparator）
     *
     * 3 自然排序中 两个对象是否相同的标准 为compareTO（） 不再是equals
    *4 定制排序中 比较两个对象也是用comareTo()
    *
    * */
    @Test
    public void test(){
       TreeSet set= new TreeSet();
//        set.add(1123);
//        set.add(456);
//        set.add("aa");
//        set.add(new User("ton",12));
        // 例子1
//        set.add(12);
//        set.add(34);
//        set.add(56);
//        set.add(6);
//        set.add(16);
//        set.add(5);


        //例子2
//        set.add("西安");
//        set.add("北京");
//        set.add("南京");
//        set.add("河北");
//        set.add("宁夏");
//        set.add("安徽");
//        set.add("guangxi");
        //3
        set.add(new User("tom",34));
        set.add(new User("jack",12));
        set.add(new User("mike",45));
        set.add(new User("hfs",55));
        set.add(new User("ys",90));
        set.add(new User("zzy",1000));
        set.add(new User("tom",1));



        Iterator iterator= set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    @Test
    public void test2(){
        Comparator com=new Comparator() {
            // 按照年龄从小到大 若相同 不要
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof  User && o2 instanceof User){
                    User u1=(User) o1;
                    User u2=(User) o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                }else{
                    throw new RuntimeException("输入类型不匹配");
                }

            }
        };


        TreeSet set=new TreeSet(com);

        set.add(new User("tom",34));
        set.add(new User("jack",12));
        set.add(new User("mike",45));
        set.add(new User("hfs",55));
        set.add(new User("ys",90));
        set.add(new User("zzy",1000));
        set.add(new User("tom",1));

    }

}
