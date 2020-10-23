package com.example.demo.model;

import java.time.LocalDate;

/**
 * @author HB
 * @data 2020/10/23 9:19
 * @Description: 控制层
 */
public class Person {

    public Person(String name, LocalDate birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    String name;
    LocalDate birthday;

    public LocalDate getBirthday() {
        return birthday;
    }

    public static int compareByAge(Person a, Person b) {
        return a.birthday.compareTo(b.birthday);
    }

    @Override
    public String toString() {
        return this.name;
    }
}
