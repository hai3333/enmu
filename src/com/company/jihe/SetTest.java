package com.company.jihe;


import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *  > set 存储无顺序 可重复的数据      高中学过的集合 无序 不重复 确定 互异
 *                     >hashset 主要实现类 线程不安全 可以存储null
 *                              LinkHashSet   是hashSet的子类   遍历其内部数据是 可以按照添加的顺序遍历
 *                     >TreeSet :底层是红黑树  所以只能放同一类new的对象  可以按照对象的属性排序
 *
 *        Map 接口   存储双列集合 用来存储一对数据 key - value     类似python 字典
 *                     >hashMap LinkHashMap TreeMap Hashtable Properties
 *
 *
 *
 *1 Set接口无额外的定义新的方法 使用的都是Collection中的方法
 *
 * 2 向Set中添加的数据 ，其所在类一定要重写hashCode()和equals() 方法
 * “相等的对象”要有相同的散列码
 * 重写两个方法的小技巧
 *
 *
 *
 */

public class SetTest {
    /**
     * set 无序性 不等于随机性  相较于list在存储数据时并没有按照顺序存值 存储的数据并没有按照索引的方法来添加数据 而是根据哈希值存储
     *

     * 不重复 : 保证添加的元素按照equals方法不能返回true   相同的元素不能重复添加
     *
     *二： 添加元素的过程 （hashSet为例）：
     *          向hashset添加元素 a 首先调用a所在类的hashcode方法，计算a的哈希值
     *             此哈希值接着通过某种算法 计算出在hashset底层数组的存放位置。判断此位置
     *             上是否有元素 ，若没有 直接添加a,若此外位置有其他元素b(或者以链表形式存储的大量元素)
     *             首先比较a和b的hash值 若不相同  添加元素a,如果相同进而需要调用元素a所在类的equals方法，
     *             equals方法返回true 表明a与b相同 不添加 若返回false 则不一样 添加成功
     *           对于后两种添加成功的元素  元素a与已经存在的数据以链表的方式连接
     *           jdk7 : 元素a放到数组 指向原来元素
     *           jdk8: 原来元素在数组 指向a
     *
     *           hashSet 底层 ： 数组+链表
     */
    public static void main(String[] args) {
        Set set=new HashSet();
        set.add(123);
        set.add("gg");
        set.add("mm");
        set.add(new User("海福生",39));
        set.add(new User("海福生",39));
        set.add(1);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    /*
        Linkedlist 的使用
        是hashSet的子类 ，在添加数据的同时，每个数据还维护了两个引用，记录数据的先后存储数据
        //优点： 对于频繁的遍历，效率高于hashSet

     */
    @Test
    public void test(){
        Set set=new LinkedHashSet();
        set.add(123);
        set.add("gg");
        set.add("mm");
        set.add(new User("海福生",39));
        set.add(new User("海福生",39));
        set.add(1);

        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

}
