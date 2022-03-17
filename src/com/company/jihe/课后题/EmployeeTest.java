package com.company.jihe.课后题;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeTest {
    // 自然排序
    @Test
    public void test1(){
        TreeSet set =new TreeSet();

        Employee e1=new Employee("liudehua",50,new MyDate(1950,3,12));
        Employee e2=new Employee("haifusheng",19,new MyDate(2000,4,11));
        Employee e3=new Employee("zhangfi",45,new MyDate(1909,3,1));
        Employee e4=new Employee("lguanyu",67,new MyDate(1900,5,2));
        Employee e5=new Employee("yangshan",13,new MyDate(2000,2,11));


        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }

    //按生日排
    @Test
    public  void test2(){
        Comparator com=new Comparator(){
            @Override
            public  int compare(Object o1,Object o2){
                if(o1 instanceof Employee &&  o2 instanceof Employee){
                    Employee E1=(Employee) o1;
                    Employee E2=(Employee)  o2;
                    MyDate b1= E1.getBirthday();
                    MyDate b2=E2.getBirthday();
                    int minster=b1.getYear()-b2.getYear();
                    if(minster!=0) {
                        return minster;
                    }else{
                        int minusMoth= b1.getMonth()- b2.getMonth();
                        {
                            if  (minusMoth!=0){
                                return minusMoth;
                            }
                            else{
                                return b1.getDay()-b2.getDay();
                            }
                        }
                    }

                }else{
                    throw  new RuntimeException("输入数据异常");
                }

                }
        } ;
        TreeSet set =new TreeSet(com);


        Employee e1=new Employee("liudehua",50,new MyDate(1950,3,12));
        Employee e2=new Employee("haifusheng",19,new MyDate(2000,4,11));
        Employee e3=new Employee("zhangfi",45,new MyDate(1909,3,1));
        Employee e4=new Employee("lguanyu",67,new MyDate(1900,5,2));
        Employee e5=new Employee("yangshan",13,new MyDate(2000,2,11));


        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
