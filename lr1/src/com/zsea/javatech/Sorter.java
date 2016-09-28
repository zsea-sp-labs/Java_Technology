package com.zsea.javatech;

/**
 * Created by truerall on 5/27/16.
 */
public class Sorter {

    public int[] sortUsingBubble(int[] arrayToSort){
        double startTimeMs = System.currentTimeMillis();
        int swaps = 0;
        int compareAttempts = 0;
        int temp;
        for (int i = 0; i < arrayToSort.length; i++){
            for (int j = arrayToSort.length - 1; j > i; j--){
                compareAttempts++;
                if(arrayToSort[j] < arrayToSort[j-1]){
                    temp = arrayToSort[j-1];
                    arrayToSort[j-1] = arrayToSort[j];
                    arrayToSort[j] = temp;
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
                j--;
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
        Utils.DBG("Swaps => "+swaps / 2); // because each array change operation (like in cycle) is not swap but move, only a half of swap
        return arrayToSort;
    }
    /*
    L: = 1, R: = n, k: = n,
	DO
		DO (j =R, R-1, ... L+1)
			IF (aj < aj-1) aj ↔ aj-1, k: = j FI
		OD
		L: = k
		DO (j: = L, L+1, ... R-1)
			IF (aj > aj+1) aj ↔ aj+1, k: = j, FI
		OD
		R: = k
	OD (L < R)

    * */
    public int[] sortUsingShaker(int[] arrayToSort){
        double startTimeMs = System.currentTimeMillis();
        int swaps = 0;
        int compareAttempts = 0;
        int temp ;
        int leftBorder = 0;
        int rightBorder = arrayToSort.length - 1;
        int swapIndex = arrayToSort.length - 1;

        do {
            for (int j = rightBorder; j > leftBorder; j--) {
                compareAttempts++;
                if (arrayToSort[j] < arrayToSort[j-1]){
                    temp = arrayToSort[j-1];
                    arrayToSort[j-1] = arrayToSort[j];
                    arrayToSort[j] = temp;
                    swapIndex = j;
                    swaps++;
                }
            }
            leftBorder = swapIndex;
            for(int j = leftBorder; j < rightBorder; j++) {
                compareAttempts++;
                if(arrayToSort[j] > arrayToSort[j+1]){
                    temp = arrayToSort[j+1];
                    arrayToSort[j+1] = arrayToSort[j];
                    arrayToSort[j] = temp;
                    swapIndex = j;
                    swaps++;
                }
            }
            rightBorder = swapIndex;
        } while (leftBorder < rightBorder);

        double stopTimeMs = System.currentTimeMillis();
        Utils.DBG("Shaker Sorting was finished in "+ (stopTimeMs - startTimeMs) + " milliseconds");
        Utils.DBG("Compare attempts => "+compareAttempts);
        Utils.DBG("Swaps => "+swaps / 2); // because each array change operation (like in cycle) is not swap but move, only a half of swap
        return arrayToSort;
    }

}
