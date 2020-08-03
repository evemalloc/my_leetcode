package com.elles.vo;

public class Person2 {
    private int age;
    private String name;

    public Person2(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public int hashCode() {
        return age+name.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
       Person2 person2=(Person2) obj;
       if(person2.age==this.age&&person2.name.equals(this.name)){
           return true;
       }else {
           return false;
       }
    }
}
