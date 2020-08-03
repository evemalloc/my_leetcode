package com.elles.test;

import com.elles.vo.Person;
import com.elles.vo.Person2;
import org.testng.annotations.Test;

import java.util.HashSet;
import java.util.Set;

public class Test01 {


    @Test
    void case1(){
        Person person=new Person(11,"zhangsan");
        Person person2=new Person(11,"zhangsan");
        Person person3=new Person(11,"lisi");
        Set<Person> personSet=new HashSet<>();
        personSet.add(person);
        personSet.add(person3);

        personSet.add(person2);

        System.out.println(personSet.size());

    }

    @Test
    void case2(){
        Person2 person=new Person2(11,"zhangsan");
        Person2 person2=new Person2(11,"zhangsan");
        Person2 person3=new Person2(11,"lisi");
        Person2 person4=new Person2(12,"lisi");
        Set<Person2> personSet=new HashSet<>();
        personSet.add(person);
        personSet.add(person2);
        personSet.add(person3);
        personSet.add(person4);
    }
}
