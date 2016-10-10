package com.zsea.javatech.lr4;

import com.zsea.javatech.lr1.Utils;
import com.zsea.javatech.lr4.test.CollectionTester;

import java.util.*;

/**
 * Created by truerall on 10/10/16.
 */
public class Main {
    public static void main(String[] args) {
        int n = 10000; // test objects cnt
        ArrayList<Person> arrayList = new ArrayList<>();
        LinkedList<Person> linkedList = new LinkedList<>();
        HashSet<Person> hashSet = new HashSet<>();
        LinkedHashSet<Person> linkedHashSet = new LinkedHashSet<>();
        TreeSet<Person> treeSet = new TreeSet<>();

        CollectionTester collectionTester = new CollectionTester(arrayList);
        
        Utils.DBG(arrayList.getClass().getSimpleName());
        Utils.DBG(n + " elements were added for " + collectionTester.addTest(n) + " ms");
        Utils.DBG("All elements were accessed for " + collectionTester.accessTest() + " ns");
        Utils.DBG("All elements were removed for " + collectionTester.removeTest() + " ms");
        
    }
}
