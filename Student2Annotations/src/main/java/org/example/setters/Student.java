package org.example.setters;

import org.example.setters.Address;
import org.example.setters.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Student {
    private int id = 12;
    private String name = "Lucia";

    @Autowired
    private List<Phone> ph;

    @Autowired
    private Address add;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Phone> getPh() {
        return ph;
    }

    @Autowired
    public void setPh(List<Phone> ph) {
        Phone ph1 = new Phone();
        ph1.setMob("12345");
        Phone ph2 = new Phone();
        ph2.setMob("65412");
        this.ph = List.of(ph1, ph2);
    }

    public Address getAdd() {
        return add;
    }

    public void setAdd(Address add) {
        this.add = add;
    }
/*public Student(int id, String name, List<Phone> ph, Address add) {
        this.id = id;
        this.name = name;
        this.ph = ph;
        this.add = add;
    }*/

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
