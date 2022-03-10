package com.company;



/*
一 枚举类的使用
1.枚举类对象个数有限
2.定义常量用枚举类
3.如果枚举类只有一个对象 则作为单例模式
二  定义枚举类
方式一： jdk 5.0 之前自定义
方式二 5.0 可以使用enum 关键字定义


 */
public class SeasonTest {

    public static void main(String[] args) {
        Season spring=Season.Spring;
        System.out.println(spring);
    }
}
// 自定义
class Season{
    //申明season对象的属性  final 参数
    private final String seasonName;
    private final String seasonDec;

    //私有化类的构造器 并给对象赋初值
    private  Season(String seasonName,String seasonDec){
        this.seasonName=seasonName;
        this.seasonDec=seasonDec;

    }
    // 3提供当前枚举类的多个对象
    public static  final Season Spring =new Season("春天","春暖花开");
    public static  final Season Summer =new Season("夏天","夏日炎炎");
    public static  final Season Autumn =new Season("秋天","秋高气爽");
    public static  final Season Winter =new Season("冬","冰天雪地");

    // 其他诉求1 获取对象的属性
    public  String getSeasonName(){
        return seasonName;
    }

    public String getSeasonDec(){
        return seasonDec;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonName='" + seasonName + '\'' +
                ", seasonDec='" + seasonDec + '\'' +
                '}';
    }
    //4 提供tostring 方法

}
