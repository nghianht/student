package com.example.studentdep.entity;

import jakarta.persistence.*;
import org.apache.coyote.http11.filters.SavedRequestInputFilter;

@Entity
public class Student {
    @Id
    @Column(name= "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private int status;
    @Column(name = "age")
    private  int age;
    @Column(name = "department_id")
    private long department_id;



    public Student(){}

    public Student(String username, String name, int age, int department_id, int status) {
        this.username = username;
        this.name = name;
        this.age = age;
        this.department_id = department_id;
        this.status = status;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(long department_id) {
        this.department_id = department_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", age=" + age +
                ", department_id=" + department_id +
                '}';
    }
}
