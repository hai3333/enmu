package com.company;
// 使用enmu 关键字来定义

/*
三 常用方法
        vlaues()  返回枚举类型对象的数组
        valueOf(String str) 可以把一个字符串转化为枚举类对象 要求字符必须是枚举类对象
        toString ()返回当前枚举类对象常量名称

 */
public class SeasonTest1 {

    public static void main(String[] args) {
        Season1 spring=Season1.Spring;
        System.out.println(spring.toString());
       // System.out.println(Season1.class.getSuperclass());
        // values
        final Season1[] values = Season1.values();
        for (int i=0;i<values.length;i++){
            System.out.println(values[i]);
        }

        Thread.State [] values1 =Thread.State.values();
        for(int i=0;i<values.length;i++){
            System.out.println(values1[i]);
        }
        //valueof （String obj）  返回枚举类中对象名是这个的对象
    Season1 winter =Season1.valueOf("WINTER");
        System.out.println(winter);
    }
}
// 自定义
enum Season1{
    // 3提供当前枚举类的多个对象 多个对象之间用逗号隔开
    Spring ("春天","春暖花开"),
   Summer ("夏天","夏日炎炎"),
    Autumn ("秋天","秋高气爽"),
    Winter ("冬","冰天雪地");

    //申明season对象的属性  final 参数
    private final String seasonName;
    private final String seasonDec;

    //私有化类的构造器 并给对象赋初值
    private  Season1(String seasonName,String seasonDec){
        this.seasonName=seasonName;
        this.seasonDec=seasonDec;

    }

    // 其他诉求1 获取对象的属性
    public  String getSeasonName(){
        return seasonName;
    }

    public String getSeasonDec(){
        return seasonDec;
    }

  /*  @Override
    public String toString() {
        return "Season1{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDec='" + seasonDec + '\'' +
                '}';
    }
    //4 提供tostring 方法
*/
}