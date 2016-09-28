package com.zsea.javatech;

import java.util.Scanner;

/**
 * Created by truerall on 5/27/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Utils.DBG("Create new file with random numbers or you have one? (y/n)");
        if(scanner.nextLine().equals("y")){
            Utils.createNewRandomNumbersFile(getFileName(scanner), getNumbersCnt(scanner));
        }

        Utils.DBG("Enter file name to sort:");
        String fileName = scanner.nextLine();

        if(fileName != null && !fileName.isEmpty()){
            Utils.DBG("Filename is "+ fileName +" reading file content");
            int[] numbersFromFile = Utils.readNumbersFromFile(fileName);
            if (numbersFromFile!= null) {
                Utils.DBG(numbersFromFile);
                Sorter sorter = new Sorter();
                //sorter.sortUsingBubble(numbersFromFile);
                //sorter.sortUsingInsertion(numbersFromFile);
                sorter.sortUsingShaker(numbersFromFile);
                Utils.DBG(numbersFromFile);
            }
        } else {Utils.DBG("File name is empty... no name - no sorting.");}
    }

    private static int getNumbersCnt(Scanner scanner){
        Utils.DBG("Enter numbers count :");
        final int numbersCnt;
        try {
            numbersCnt = Integer.valueOf(scanner.nextLine());
        } catch (NumberFormatException e){
            Utils.DBG("You should use numbers, try again.");
            return getNumbersCnt(scanner);
        }
        return numbersCnt;
    }

    private static String getFileName(Scanner scanner){
        Utils.DBG("Enter file name:");
        final String fileName = scanner.nextLine();
        if(fileName == null || fileName.isEmpty()){
            Utils.DBG("File name should not be empty");
            return getFileName(scanner);
        }
        return fileName;
    }
}
