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
        Utils.DBG("Swaps => "+swaps);
        return arrayToSort;
    }
    /*
    *
    * х:=аL, i:=L, j:=R,
        DО (i≤j)
            DО (ai<x) i:=i+1 OD
            DО (aj>x) j:=j-1 OD
                IF (i<=j)
                    ai↔ aj,, i:=i+1, j:=j-1
                FI
        OD
        IF (L<j)
            <Сортування частини масиву з границями (L,j)>
        FI
        IF (i<R)
            < Сортування частини масиву з границями (i,R)>
        FI
*/
    public int[] sortUsingQuickSorter(int[] arrayToSort){
        double startTimeMs = System.currentTimeMillis();

        int leftBorder = 0;
        int rightBorder = arrayToSort.length - 1;
        int compareElement = arrayToSort[arrayToSort.length/2];

        quickSort(arrayToSort,leftBorder,rightBorder,compareElement);

        double stopTimeMs = System.currentTimeMillis();
        Utils.DBG("Quick Sorting was finished in "+ (stopTimeMs - startTimeMs) + " milliseconds");
        Utils.DBG("Compare attempts => "+quickSortCompareCnt);
        Utils.DBG("Swaps => "+quickSortSwapCnt);
        return arrayToSort;
    }

    private static int quickSortSwapCnt = 0;
    private static int quickSortCompareCnt = 0;
    private void quickSort(int[] arrayToSort, int left, int right,int compareElement){
        int temp;
        int i = left;
        int j = right;
        while (i <= j){
            while(arrayToSort[i] < compareElement){
                i++;
            }
            while (arrayToSort[j] > compareElement){
                j--;
            }
            if(i <= j){
                temp = arrayToSort[right];
                arrayToSort[right] = arrayToSort[left];
                arrayToSort[left] = temp;
                quickSortSwapCnt++;
                i++;
                j--;
            }
            if(left < j){
                quickSort(arrayToSort,left,j,compareElement);
            }
            if(i < right){
                quickSort(arrayToSort,i,right,compareElement);
            }
        }
    }
}
