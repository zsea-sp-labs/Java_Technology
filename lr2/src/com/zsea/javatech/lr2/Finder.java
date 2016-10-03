package com.zsea.javatech.lr2;

import com.zsea.javatech.lr1.Utils;

/**
 * Created by truerall on 10/2/16.
 */
public class Finder {
    public void findUsingKMPSerch(String toSearchIn, String toSearch){

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
