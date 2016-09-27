package com.zsea.javatech;

/**
 * Created by truerall on 5/27/16.
 */
public class Sorter {

    public int[] sortUsingBubble(int[] arrayToSort){
        double startTimeMs = System.currentTimeMillis();
        int swaps = 0;
        int compareAttempts = 0;
        for (int i = 0; i < arrayToSort.length; i++){
            for (int j = arrayToSort.length - 1; j > i; j--){
                compareAttempts++;
                if(arrayToSort[j] < arrayToSort[j-1]){
                    int tmp = arrayToSort[j-1];
                    arrayToSort[j-1] = arrayToSort[j];
                    arrayToSort[j] = tmp;
                    swaps++;
                }
            }
        }
        double stopTimeMs = System.currentTimeMillis();
        Utils.DBG("Bubble Sorting was finished in "+ (stopTimeMs - startTimeMs) + " milliseconds");
        Utils.DBG("Compare attempts => "+compareAttempts);
        Utils.DBG("Swaps => "+swaps);
        return arrayToSort;
    }
    /*
    *   DO (i: = 2, 3, … n)
		    t: = ai, j: =i-1
		    DO (j > 0 и t < aj)
			    aj+1:= aj
			    j: = j-1
            OD
		    aj+1:= t
        OD

        * */
    public int[] sortUsingInsertion(int[] arrayToSort){
        double startTimeMs = System.currentTimeMillis();
        int swaps = 0;
        int compareAttempts = 0;
        int temp;
        int j;
        for(int i = 1; i < arrayToSort.length; i++){
            temp = arrayToSort[i];
            j = i - 1;

            while (j >= 0 && temp < arrayToSort[j]){
                compareAttempts++;
                arrayToSort[j+1] = arrayToSort[j];
                swaps++;
                j = j-1;
                if(j-1 >= 0 && !(temp < arrayToSort[j-1])){  // REMOVE TO GET CLEAR RESULTS OF TIME
                    compareAttempts++;
                }
            }
            arrayToSort[j+1] = temp;
            swaps++;
        }
        double stopTimeMs = System.currentTimeMillis();
        Utils.DBG("Insertion Sorting was finished in "+ (stopTimeMs - startTimeMs) + " milliseconds");
        Utils.DBG("Compare attempts => "+compareAttempts);
        Utils.DBG("Swaps => "+swaps);
        return arrayToSort;
    }
}
