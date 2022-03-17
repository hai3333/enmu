package com.company.Map;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 *
 *
 *    Properties  常用来处理配置文件 key和value都是String
* */
public class PropertiesTest {

    public static void main(String[] args) {
        FileInputStream fis = null;
        try {
            Properties pros = new Properties();
            fis = new FileInputStream("D:/Java/10-meijulei and zhujie/src/com/company/Map/jdbc.properties");
            pros.load(fis);// 加载对应文件

            String name = pros.getProperty("name");
            String password = pros.getProperty("password");

            System.out.println("name=" + name + ",password=" + password);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
