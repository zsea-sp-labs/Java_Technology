package com.zsea.javatech.lr4;

import java.util.Calendar;

/**
 * Created by truerall on 10/10/16.
 */
public class Teacher extends Person {
    private String department;
    private String position;

    public Teacher(String name, String surname, Calendar dateOfBirth, String department, String position) {
        super(name, surname, dateOfBirth);
        this.department = department;
        this.position = position;
    }

    public Teacher() {
        super();
        this.department = "FIT";
        this.position = "professor";
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }
}
