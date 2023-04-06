package org.example.constructors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class Student {

    private int id;
    private String name;
    private List<Phone> ph = new ArrayList<>();;

    @Autowired
    private Address add;

    public Student() {
        id=12;
        name = "lucia";
        Phone ph1 = new Phone("111111");
        Phone ph2 = new Phone("777777");
        ph = List.of(ph1, ph2);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", ph=" + ph +
                ", add=" + add +
                '}';
    }
}