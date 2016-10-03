package com.zsea.javatech.lr2;

import com.zsea.javatech.lr1.Utils;

/**
 * Created by truerall on 10/2/16.
 */
public class Finder {
    public void findUsingKMPSerch(String toSearchIn, String toSearch){

    }
    public void findUsingSimpleSearch(String toSearchIn, String toSearch){

    }
    public void findUsingDefaultSearch(String toSearchIn, String toSearch){
        long startMilliseconds = System.currentTimeMillis();
        String[] detectionArray = toSearchIn.split(toSearch);
        printResults(startMilliseconds,System.currentTimeMillis(),detectionArray.length);
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
