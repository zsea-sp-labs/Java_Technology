package com.zsea.javatech.lr4;

import java.util.Calendar;

/**
 * Created by truerall on 10/10/16.
 */
public class Student extends Person implements Comparable<Student>{
    private String group;
    private int course;

    public Student(String name, String surname, Calendar dateOfBirth, String group, int course) {
        super(name, surname, dateOfBirth);
        this.group = group;
        this.course = course;
    }

    public Student() {
        this.group = "SP-12-1-z";
        this.course = 1;
    }

    @Override
    public int compareTo(Student student) {
        if (this.course == student.course) return 0;
        if (this.course > student.course) return -1; else return 1;
    }
}
