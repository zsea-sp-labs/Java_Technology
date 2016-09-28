package com.zsea.javatech;

import java.io.*;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by truerall on 5/27/16.
 */
public class Utils {

    public static void DBG(String string){
        System.out.println(string);
    }

    public static void DBG(int[] array){
        for (int i :array) {
            System.out.print(" "+i+" ");
        }
        System.out.println('\n');
    }

    public static File createNewRandomNumbersFile(String fileName, int numbersCnt) {
        File file = new File(fileName);

        if (file.exists()){
            Utils.DBG("File already exists! Rewrite ? (y/n)");
            Scanner scanner = new Scanner(System.in);
            String usersAnswer = scanner.nextLine();
            if(!usersAnswer.equals("y") && !usersAnswer.equals("n")){
                Utils.DBG("You should use 'y' or 'n' key for answer! ");
                createNewRandomNumbersFile(fileName,numbersCnt);
            } else if (usersAnswer.equals("n")) {
                return file;
            }
        }
        return writeFileWithRandomNumbers(file,numbersCnt);
    }

    private static File writeFileWithRandomNumbers(File file, int numbersCnt){
        Random random = new Random();
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
                bw.write(String.valueOf(random.nextInt(10)));
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
            scanner.close();
            Utils.DBG("Header value is incorrect or not exists");
            return null;
        }

        int i = 0;
        while(scanner.hasNextInt()) {
            numbersToSort[i++] = scanner.nextInt();
        }
        scanner.close();
        if (i != numbersToSort.length) {
            Utils.DBG("File contains not complete sequence of numbers, be careful with results !");
            return numbersToSort;
        }
        return numbersToSort;
    }
}
