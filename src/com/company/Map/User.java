package com.company.Map;

import java.util.Objects;

import static java.util.Objects.hash;

public class User implements Comparable {
    String name;
    int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return hash(name, age);
    }
//姓名从小到达  姓名相同 比较姓名
    @Override
    public int compareTo(Object o) {
        if (o instanceof User) {
            User user = (User) o;
            // return this.name.compareTo(user.name);
            int compare = this.name.compareTo(user.name);
            if (compare != 0) {
                return compare;
            } else {
                return Integer.compare(this.age, user.age);
            }
        }
            else{
                throw new RuntimeException("输入类型不匹配");
            }

        }
    }



