package com.zsea.javatech.lr4;

import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by truerall on 10/10/16.
 */
public abstract class Person {
    private String name;
    private String surname;
    private Calendar dateOfBirth;

    public Person(String name, String surname, Calendar dateOfBirth) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
    }

    public Person() {
        this.name = "DefaultName";
        this.surname = "DefaultSurname";
        this.dateOfBirth = new GregorianCalendar(1989,8,9);
    }

    @Override
    public String toString() {
        return name+" "+surname+" "+dateOfBirth.toString();
    }

    String toShortString(){
        return name + " " + surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Calendar getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Calendar dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
