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
        printResults(arrayToSort,startTimeMs,System.currentTimeMillis(),compareAttempts,swaps);
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
        printResults(arrayToSort,startTimeMs,System.currentTimeMillis(),compareAttempts,swaps /2); // because each array change operation (like in cycle) is not swap but move, only a half of swap
        return arrayToSort;
    }

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

        printResults(arrayToSort,startTimeMs,System.currentTimeMillis(),compareAttempts,swaps);
        return arrayToSort;
    }

    public int[] sortUsingQuickSorter(int[] arrayToSort){
        double startTimeMs = System.currentTimeMillis();
        int leftBorder = 0;
        int rightBorder = arrayToSort.length - 1;

        quickSort(arrayToSort,leftBorder,rightBorder);

        printResults(arrayToSort,startTimeMs,System.currentTimeMillis(),quickSortCompareCnt,quickSortSwapCnt);
        return arrayToSort;
    }

    private static int quickSortSwapCnt = 0;
    private static int quickSortCompareCnt = 0;
    private void quickSort(int[] arrayToSort, int left, int right){
        int temp;
        int i = left;
        int j = right;
        int compareElement = arrayToSort[left + (right - left) / 2];

        while (i <= j){
            while(arrayToSort[i] < compareElement){
                i++;
                quickSortCompareCnt++;
            }
            quickSortCompareCnt++;
            while (arrayToSort[j] > compareElement){
                j--;
                quickSortCompareCnt++;
            }
            quickSortCompareCnt++;
            if(i <= j){
                temp = arrayToSort[j];
                arrayToSort[j] = arrayToSort[i];
                arrayToSort[i] = temp;
                quickSortSwapCnt++;
                i++;
                j--;
            }
            if(left < j){
                quickSort(arrayToSort,left,j);
            }
            if(i < right){
                quickSort(arrayToSort,i,right);
            }
        }
    }

    public int[] sortUsingShell(int[] arrayToSort){
        double startTimeMs = System.currentTimeMillis();
        int compareAttempts = 0;
        int swaps = 0;
        int temp = 0;
        int step = arrayToSort.length / 2;

        while(step > 0) {
            for(int i = 0; i < (arrayToSort.length - step); i++) {
                int j = i;
                while(j >= 0 && arrayToSort[j] > arrayToSort[j + step]){
                    compareAttempts++;
                    temp = arrayToSort[j];
                    arrayToSort[j] = arrayToSort[j + step];
                    arrayToSort[j + step] = temp;
                    swaps++;
                    j--;
                }
                if(j+1 >=0) compareAttempts++;
            }
            step = step / 2;
        }
        printResults(arrayToSort,startTimeMs,System.currentTimeMillis(),compareAttempts,swaps);
        return arrayToSort;
    }

    private void printResults(int[] arrayToSort,double startTimeMs,double stopTimeMs, int compareAttempts, int swaps){
        Utils.DBG("Results : ");
        Utils.DBG(arrayToSort);
        Utils.DBG("Shell Sorting was finished in "+ (stopTimeMs - startTimeMs) + " milliseconds");
        Utils.DBG("Compare attempts => "+compareAttempts);
        Utils.DBG("Swaps => "+swaps);
    }
}
