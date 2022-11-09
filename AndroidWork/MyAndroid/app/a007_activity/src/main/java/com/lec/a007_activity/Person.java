package com.lec.a007_activity;

import java.io.Serializable;

// Intent 에 담아 보낼때는 Serializable 을 implement 해야 한다
public class Person implements Serializable {
    String name;
    int age;

    // AndroidStudio 에선 ALT + INSERT 로 생성자/getter, setter 등 자동 생성

    public Person(){}

    public Person(String name, int age) {
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
}
