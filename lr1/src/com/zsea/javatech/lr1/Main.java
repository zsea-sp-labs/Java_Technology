package com.zsea.javatech.lr1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by truerall on 5/27/16.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Utils.DBG("Create new file with random numbers? (y/n)");
        if(!scanner.nextLine().equals("n")){
            Utils.createNewRandomNumbersFile(getFileName(scanner), getNumbersCnt(scanner));
        }

        Utils.DBG("Enter file name to sort:");
        String fileName = scanner.nextLine();

        if(fileName != null && !fileName.isEmpty()){
            Utils.DBG("Filename is "+ fileName +" reading file content");
            int[] numbersFromFile = Utils.readNumbersFromFile(fileName);
            if (numbersFromFile!= null) {
                int[] bubbleArray = new int[numbersFromFile.length];
                int[] insertionArray = new int[numbersFromFile.length];
                int[] shakerArray = new int[numbersFromFile.length];
                int[] quickSorterArray = new int[numbersFromFile.length];
                System.arraycopy(numbersFromFile, 0,bubbleArray, 0,numbersFromFile.length);
                System.arraycopy(numbersFromFile, 0,insertionArray, 0,numbersFromFile.length);
                System.arraycopy(numbersFromFile, 0,shakerArray, 0,numbersFromFile.length);
                System.arraycopy(numbersFromFile, 0,quickSorterArray, 0,numbersFromFile.length);
                Utils.DBG(numbersFromFile);
                Sorter sorter = new Sorter();
                sorter.sortUsingBubble(bubbleArray);
                sorter.sortUsingInsertion(insertionArray);
                sorter.sortUsingShaker(shakerArray);
                sorter.sortUsingQuickSorter(quickSorterArray);
                sorter.sortUsingShell(numbersFromFile);

                Utils.DBG("Enter file name to save results or empty string to avoid data save:");
                String fileNameForResults = scanner.nextLine();
                if(!fileNameForResults.isEmpty()){
                    Utils.writeStringToTextFile(fileNameForResults, Arrays.toString(numbersFromFile));
                }
            }
        } else {Utils.DBG("File name is empty... no name - no sorting.");}
        scanner.close();
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
