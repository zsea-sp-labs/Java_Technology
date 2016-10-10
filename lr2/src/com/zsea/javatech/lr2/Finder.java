package com.zsea.javatech.lr2;

import com.zsea.javatech.lr1.Utils;

/**
 * Created by truerall on 10/2/16.
 */
public class Finder {
    public void findUsingKMPSearchS1DecreasingCalculatedPrefixLength(String stringToSearchIn, String stringToSearch){
        Utils.DBG("KMPSearch");
        int matchesCnt = 0;
        long startTime = System.currentTimeMillis();
        int[] prefixFunction = new int[stringToSearch.length()];
        for(int i = 1; i < stringToSearch.length(); i++){ // ?
            int j = prefixFunction[i-1];
            while(j > 0 && stringToSearch.charAt(j)!=stringToSearch.charAt(i)){
                j = prefixFunction[j-1];
            }
            if(stringToSearch.charAt(j) == stringToSearch.charAt(i)) prefixFunction[i] = j+1;
        }
        Utils.DBG("S^1 Prefix function array ");
        Utils.DBG(prefixFunction);
        // здесь мы можем понять весь смысл префикс функции. изначально наши образци начинают сравниватся по элементно аки в тривиальном
        // но именно полученная префикс функция образца помогает нам понять на какую позицию мы можем максимально сместить курсор сравнения
        // в случае обнаружения совпадения / расхождения элементов
        int j = 0;
        for (int i = 0; i < stringToSearchIn.length();i++){
            while(j > 0 && stringToSearch.charAt(j)!=stringToSearchIn.charAt(i)){
                j = prefixFunction[j-1];
            }
            if(stringToSearch.charAt(j) == stringToSearchIn.charAt(i)) {
                j++;
            }
            if(j == stringToSearch.length()){
                Utils.DBG("match found at i = "+ (i - j + 1));
                j = prefixFunction[j-1]; // данное смещение решает проблему образца "aba" в строке "abababa" собственно именно потому нам и нужна префикс функция
                matchesCnt++;
            }
        }
        printResults(startTime,System.currentTimeMillis(),matchesCnt);
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
            Utils.DBG("---------");
        }
    }
}
