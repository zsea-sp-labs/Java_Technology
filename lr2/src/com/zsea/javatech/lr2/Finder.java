package com.zsea.javatech.lr2;

import com.zsea.javatech.lr1.Utils;

/**
 * Created by truerall on 10/2/16.
 */
public class Finder {
    public void findUsingKMPSearchS2IncreasingPrefixLength(String str){
        int[] prefixFunction = new int[str.length()];// для i = 0 нет смысла считать префикс функцию - массив из 1 го элемента значит префикс = суффикс = длинна строки
        for(int i = 1; i < str.length(); i++){ // pref function index which is also border length of prefix (pref.length < i)
            Utils.DBG("i = "+i);
            int j;
            for (j = 0; j <= i-1 ; j++){ // j изменяет длинну префикса начиная с самого мелкого (0) и подымаецо до i-1 - максимально возможного
                boolean prefixMatches = true;
                Utils.DBG("j = "+j);
                for(int k = 0; k<=j; k++){ // k является индексом позволяющим проходить весь массив для сравнения до длины сравниемого суфикса
                    Utils.DBG(" str["+k+"] = "+ str.charAt(k) );
                    Utils.DBG(" compareTo str["+(i-j+k)+"]= "+str.charAt((i-j+k)));
                    if(str.charAt(k) != str.charAt(i - j + k )){
                        prefixMatches = false;
                        break;
                    }
                }
                Utils.DBG("I ve reached this line with J = " +j);
                if(prefixMatches) {
                    Utils.DBG("setting prefix func value to "+j);
                    prefixFunction[i] = j +1; // because of that array indexing starts from 0, which means 1;
                }
            }
        }
        Utils.DBG("Prefix function array ");
        Utils.DBG(prefixFunction);
    }
    public void findUsingKMPSearchTrivialIncreasingPrefixLength(String str){
        int[] prefixFunction = new int[str.length()];// для i = 0 нет смысла считать префикс функцию - массив из 1 го элемента значит префикс = суффикс = длинна строки
        for(int i = 1; i < str.length(); i++){ // pref function index which is also border length of prefix (pref.length < i)
            Utils.DBG("i = "+i);
            int j;
            for (j = 0; j <= i-1 ; j++){ // j изменяет длинну префикса начиная с самого мелкого (0) и подымаецо до i-1 - максимально возможного
                boolean prefixMatches = true;
                Utils.DBG("j = "+j);
                for(int k = 0; k<=j; k++){ // k является индексом позволяющим проходить весь массив для сравнения до длины сравниемого суфикса
                    Utils.DBG(" str["+k+"] = "+ str.charAt(k) );
                    Utils.DBG(" compareTo str["+(i-j+k)+"]= "+str.charAt((i-j+k)));
                    if(str.charAt(k) != str.charAt(i - j + k )){
                        prefixMatches = false;
                        break;
                    }
                }
                Utils.DBG("I ve reached this line with J = " +j);
                if(prefixMatches) {
                    Utils.DBG("setting prefix func value to "+j);
                    prefixFunction[i] = j +1; // because of that array indexing starts from 0, which means 1;
                }
            }
        }
        Utils.DBG("Prefix function array ");
        Utils.DBG(prefixFunction);
    }

    public void findUsingKMPSearchTrivialDecreasingPrefixLength(String str){
        int[] prefixFunction = new int[str.length()];// для i = 0 нет смысла считать префикс функцию - массив из 1 го элемента значит префикс = суффикс = длинна строки
        for(int i = str.length()-1; i >= 1; i--){ // pref function index which is also border length of prefix (pref.length < i)
            int j;
            for (j = i-1; j >= 0 ; j--){ // j изменяет длинну префикса начиная с самого крупного (i-1) и опускаясь до 1 (2 символов)
                boolean prefixMatches = true;
                for(int k = 0; k<=j; k++){ // k является индексом позволяющим проходить весь массив для сравнения
                    if(str.charAt(k) != str.charAt(i - j + k )){
                        prefixMatches = false;
                        break;
                    }
                }
                if(prefixMatches) {
                    prefixFunction[i] = j +1; // because of that array indexing starts from 0, which means 1;
                    break;
                }
            }
        }
        Utils.DBG("Prefix function array ");
        Utils.DBG(prefixFunction);
    }

    public void findUsingSimpleSearch(String toSearchIn, String toSearch){
        Utils.DBG("SimpleSearch");
        long startTime = System.currentTimeMillis();
        int matchesCount = 0;
        for(int i = 0; i < toSearchIn.length();i++){
            for(int j = 0; j< toSearch.length(); j++){
                if(toSearchIn.charAt(i+j) != toSearch.charAt(j)){
                    break;
                } else if ( j == toSearch.length() - 1){
                    Utils.DBG("match found at i = "+i);
                    matchesCount++;
                }
            }
        }
        printResults(startTime, System.currentTimeMillis(), matchesCount);
    }

    public void findUsingDefaultSearch(String toSearchIn, String toSearch){
        Utils.DBG("DefaultSearch");
        int matchesCount = 0;
        long startMilliseconds = System.currentTimeMillis();
        int index = toSearchIn.indexOf(toSearch);
        while(index >= 0) {
            Utils.DBG("Match found at index = "+index);
            matchesCount++;
            index = toSearchIn.indexOf(toSearch, index+1);
        }
        printResults(startMilliseconds,System.currentTimeMillis(),matchesCount);
    }

    private void printResults(long startMilliseconds,long stopMilliseconds,int matchesCount){
        if(matchesCount <= 0){
            Utils.DBG("No matches for text");
        } else {
            Utils.DBG("Matches cnt = " + matchesCount);
            Utils.DBG("Search time = " + (stopMilliseconds - startMilliseconds));
        }
    }
}
