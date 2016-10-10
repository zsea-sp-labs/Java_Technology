package com.zsea.javatech.lr4.test;

import com.zsea.javatech.lr1.Utils;
import com.zsea.javatech.lr4.Person;
import com.zsea.javatech.lr4.Student;
import com.zsea.javatech.lr4.Teacher;

import java.util.Collection;
import java.util.GregorianCalendar;
import java.util.Iterator;

/**
 * Created by truerall on 10/10/16.
 */
public class CollectionTester {
    Collection<Person> collection ;

    public CollectionTester(Collection<Person> collection) {
        this.collection = collection;
    }
    public long addTest(int count) {
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= count; i++) {
            String valueOfi = String.valueOf(i);
            if (i % 2 == 0) collection.add((
                    new Student("FN" + valueOfi,
                    "SN" + valueOfi,
                    new GregorianCalendar(2000 + i, 01, 01),
                    "GR" + valueOfi, i)));
            else collection.add(
                    new Teacher("FN" + valueOfi,
                                "SN" + valueOfi,
                                new GregorianCalendar(2000 + i, 01, 01),
                                "FAC"+valueOfi,
                                "POS"+valueOfi));
        }
        return System.currentTimeMillis() - startTime;
    }
    public long removeTest() {
        long startTime = System.currentTimeMillis();
        if (collection != null) {
            Iterator<Person> it = collection.iterator();
            while (it.hasNext()){
                it.next();
                it.remove();
            }
        }
        return System.currentTimeMillis() - startTime;
    }
    public long accessTest() {
        long startTime = System.nanoTime();
        for(Person p: collection){
            p.setName("accessTested");
        }
        return System.nanoTime() - startTime;
    }
}
