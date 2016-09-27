package com.zsea.javatech;

import java.util.Scanner;

/**
 * Created by truerall on 5/27/16.
 */
public class Main {

    public static final String randomNumbersFileName = "FileWithRandomNumbers";

    public static void main(String[] args) {
        Utils.DBG("Enter file name to sort");

        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.nextLine();

        if(fileName != null && !fileName.isEmpty()){
            Utils.DBG("Filename is "+ fileName +" reading file content");
            int[] numbersFromFile = Utils.readNumbersFromFile(fileName);
            if (numbersFromFile!= null) {
                for (int i :numbersFromFile) {
                    Utils.DBG("Number from file "+i);
                }
            }
        }
    }
}
