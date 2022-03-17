package com.company.Map;

//*
//
//  Map 接口   存储双列集合 用来存储一对数据 key - value     类似python 字典
//                    >hashMap          主要实现类  线程不安全 效率高  可以存储null 的key和value
//                          LinkHashMap(频繁遍历用这个)    保证在遍历hashmap元素是 可以按照添加的顺序实现遍历
//                                        原因 在原有的HashMap底层结构的基础上，添加了一对指针 指向前一个和后一个元素
 //                                        对于频繁的遍历操作 此类执行效率高于hashmap
//                     TreeMap    有序的键值对  按照key排序 实现排序遍历 考虑key的自然排序和定制排序
//                                       底层红黑树
  //                   Hashtable  古老实现类 线程安全 效率低    不能存储空的key value
    //                      Properties  常用来处理配置文件 key和value都是String

/**
*
 *hashMap底层 数组＋链表 jdk7以前
 *              数组+链表+红黑树
 *
 *key  ==set    value ==collection
 *
 *
 * 面试题：
 * hashMap的底层实现原理？
 * jdk 7:
 *      hash map=new HashMap();   在实例化之后  底层创建了长度是16的一维数组entry[]  table
 *      map.put(key1,value1):
 *      首先计算key1类的hashcode方法 计算哈希值  -->此哈希值经过某种算法--> 得到在数组中的存放位置
 *      如果该位置有空 那么直接添加成功
 *      如果不为空（此位置存在一个或多个用链表存储的数据） 先比较key1和已经存在的数据的哈希值
 *          如果哈希值不相同  此时key1-value1 添加成功
 *          如果kye1和某一个数据的哈希值相同 比较equals方法  调用key1所在类的equals方法进行比较
 *              如果equals返回false 保存成功
 *              如果返回true  使用value1替换相同key的value值
 *       补充 关于情况2 和情况3 ：已经有元素设计到链表存储 链表指向 7上8下
 *
 *       在添加的过程中  默认的扩容方法 扩容为原来的两倍 并将原有的方法复制过来
 * jdk 8:
 *      hash map=new HashMap();   在实例化之后  底层没有创建长度是16的一维数组Node[]  table
 *      调用put方法的时候才创建数组
 *      jdk8 数组+链表+红黑树
 *          当某个索引元素位置上的元素以链表形式存储的数据个数大于8 且当前数组的长度>64, 此索引位置上的所有数据改为
 *          红黑树存储 (遍历快 方便存储)
 *
 *
 *
 * HashMap与Hashtable 的异同
 *
 *
 *  CurrentHashMap 与Hashtable的区别
 *
 *
 *
 * 二： Map结构理解
 *
 * key无序 不可重复 set存储所有的key  ---> 重写所在类的equals和hashCode方法
 * value 无顺序的 可以重复的 使用Collection存储
 *
 * key-value 组成一个entry元素
 * Map中的entry  无顺序 不可以重复的 使用set存储
 *
 *
 *
 *
 *
 *  Map接口的常用方法
 *       -> 以hashmap为例子
 *       clear()	删除 hashMap 中的所有键/值对
 * clone()	复制一份 hashMap
 * isEmpty()	判断 hashMap 是否为空
 * size()	计算 hashMap 中键/值对的数量
 * put()	将键/值对添加到 hashMap 中
 * putAll()	将所有键/值对添加到 hashMap 中
 * putIfAbsent()	如果 hashMap 中不存在指定的键，则将指定的键/值对插入到 hashMap 中。
 * remove()	删除 hashMap 中指定键 key 的映射关系
 * containsKey()	检查 hashMap 中是否存在指定的 key 对应的映射关系。
 * containsValue()	检查 hashMap 中是否存在指定的 value 对应的映射关系。
 * replace()	替换 hashMap 中是指定的 key 对应的 value。
 * replaceAll()	将 hashMap 中的所有映射关系替换成给定的函数所执行的结果。
 * get()	获取指定 key 对应对 value
 * getOrDefault()	获取指定 key 对应对 value，如果找不到 key ，则返回设置的默认值
 * forEach()	对 hashMap 中的每个映射执行指定的操作。
 * entrySet()	返回 hashMap 中所有映射项的集合集合视图。
 * keySet()	返回 hashMap 中所有 key 组成的集合视图。
 * values()	返回 hashMap 中存在的所有 value 值。
 * merge()	添加键值对到 hashMap 中
 * compute()	对 hashMap 中指定 key 的值进行重新计算
 * computeIfAbsent()	对 hashMap 中指定 key 的值进行重新计算，如果不存在这个 key，则添加到 hasMap 中
 * computeIfPresent()	对 hashMap 中指定 key 的值进行重新计算，前提是该 key 存在于 hashMap 中。
 * */


import org.junit.Test;

import java.util.*;

public class MapTest {
  @Test
    public void test1(){
      Map map=new HashMap();
      map.put(3,"kk");
      System.out.println(map);
  }

  @Test
    public void test2(){
      Map map=new HashMap();
      map.put(3,"kk");
      map.put("KK",123);
      map.put("HH",124);
      map.put("PP",23);
      map.put("LL",1234543);

      System.out.println(map);

      Map map1=new HashMap();
      map1.put(23,"asdasd");
      map.putAll(map1);
      System.out.println(map);

      //remove(key)  没有的话返回null
      Object obj=map.remove("LL");
      System.out.println(obj);

      //clear  清空map

      map1.clear();
      System.out.println(map1.size());
          }
          @Test
    public void test3(){
            Map map=new HashMap();
              map.put(3,"kk");
              map.put("KK",123);
              map.put("HH",124);
              map.put("PP",23);
              map.put("LL",1234543);
            // get 查找当前key对应的value
              System.out.println(map.get("PP"));
              //containsKey 查看是否包含这个key
             boolean isExit=map.containsKey("PP");
              System.out.println(isExit);
              //containsValue 查看是否包含这个value
              System.out.println(map.containsValue(123));
              map.clear();
              System.out.println(map.isEmpty());
              System.out.println(map);



          }
          /**
           * 视图操作
          *
          * */
          @Test
    public void test4(){
              Map map=new HashMap();
              map.put(3,"kk");
              map.put("KK",123);
              map.put("HH",124);
              map.put("PP",23);
              map.put("LL",1234543);

              //keySet  遍历所有的key
              Set set = map.keySet();
              Iterator iterator= set.iterator();
              while(iterator.hasNext()){

                  System.out.println(iterator.next());
              }
              //setValue  遍历所有的value

              Collection values= map.values();;
              for (Object obj: values){
                  System.out.println(obj);
              }

              //遍历所有key-value
              Set entrySet = map.entrySet();
              Iterator iterator1 = entrySet.iterator();
              while (iterator1.hasNext()){
                  System.out.println(iterator1.next());
              }

          }


}
