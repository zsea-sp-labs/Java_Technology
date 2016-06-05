package com.zsea.javatech;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by truerall on 5/27/16.
 */
public class Utils {

    public final static void DBG(String string){
        System.out.println(string);
    }

    public static final  File createNewRandomNumbersFile(String fileName, int numbersCnt){
        return createNewRandomNumbersFile(fileName,numbersCnt,false);
    }

    public static final  File createNewRandomNumbersFile(String fileName, int numbersCnt, boolean overwrite) {
        Random random = new Random();
        File file = new File(fileName);

        if (file.exists() & !overwrite ){
            Utils.DBG("File already exists!");
            return file;
        } else if (file.exists() & overwrite) {
            Utils.DBG("Trying to write to existing file");
        }

        FileWriter fw = null;
        try {
            fw = new FileWriter(file.getAbsoluteFile());
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(fw == null){
            Utils.DBG("Problem occured during FileWriter creation, please see the stacktrace above.");
            return null;
        }
        BufferedWriter bw = new BufferedWriter(fw);
        try {
            bw.write(String.valueOf(numbersCnt));
            bw.newLine();
            for(int i = 0; i< numbersCnt;i++){
                bw.write(String.valueOf(random.nextInt(10)-5));
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return file;
    }

    public static int[] readNumbersFromFile(String fileName){
        Scanner scanner;
        int[] numbersToSort;
        try {
            scanner = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            Utils.DBG("Sorry but file not found");
            return null;
        }

        if(scanner.hasNextInt()) {
            numbersToSort = new int[scanner.nextInt()];
        } else {
            Utils.DBG("Header value is incorrect or not exists");
            return null;
        }

        int i = 0;
        while(scanner.hasNextInt()) {
            numbersToSort[i++] = scanner.nextInt();
        }
        if (i != numbersToSort.length) {
            Utils.DBG("File contains not complete sequence of numbers, be careful with results !");
            return numbersToSort;
        }
        return numbersToSort;
    }
}
