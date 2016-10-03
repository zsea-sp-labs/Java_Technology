package com.zsea.javatech.lr2;

import com.zsea.javatech.lr1.Utils;

import java.util.Scanner;

/**
 *  Реалізувати програму на Java для пошуку слів у тексті за допомогою алгоритму Кнута-Морріса-Прата
    Порівняти час виконання з простим алгоритмом, де порівняння йде посимвольно зі зсувом зразка на 1
    Порівняти зі стандартним алгоритмом пошуку підрядка у рядку
    Передбачити зчитування тексту з файлу, або з консолі.
    Слова для пошуку вводяться з консолі й розділяються пробілами // no sense, in such case how will you find something like "alpha and beta" ?
 * Created by truerall on 10/1/16.
 */
public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String stringToSearchIn = null;
        String fileName;
        Finder finder = new Finder();

        Utils.DBG("Read text from file() or from console ? (f/c):");
        String answer = scanner.nextLine();
        if(!answer.equals("f")){
            Utils.DBG("Please enter text to search in:");
            stringToSearchIn = scanner.nextLine();
        } else {
            Utils.DBG("Enter file name:");
            fileName = scanner.nextLine();
            if (fileName != null && !fileName.isEmpty()) {
                stringToSearchIn = Utils.readFileAsString(fileName);
            } else {Utils.DBG("File name is empty... no name - no search.");}
        }
        Utils.DBG("working dir = "+ System.getProperty("user.dir"));
        if(stringToSearchIn == null || stringToSearchIn.isEmpty()){
            Utils.DBG("Something went wrong, and string to search in is null, please check the stacktrace.");
        }else {
            Utils.DBG("Please enter string to find:");
            String stringToSearch = scanner.nextLine();
            finder.findUsingDefaultSearch(stringToSearchIn, stringToSearch);
            finder.findUsingSimpleSearch(stringToSearchIn, stringToSearch);
            finder.findUsingKMPSerch(stringToSearchIn,stringToSearch);
        }

        scanner.close();
    }
}
