package com.zsea.javatech.lr2;

import com.zsea.javatech.lr1.Utils;

/** This class was created for research purposes.
 * I don't know why but, It was hard to me to understand how KMP works, that's why here we can see all steps of
 * getting this done. comments contain very valuable info.
 * Created by truerall on 10/10/16.
 */
public class InfoFinder {

    public void calculatePrefixFunctionS1(String stringToSearchIn, String stringToSearch){
        int matchesCnt = 0;
        long startTime = System.currentTimeMillis();
        int[] prefixFunction = new int[stringToSearch.length()];
        for(int i = 1; i < stringToSearch.length(); i++){ // ?
            Utils.DBG("i = "+i);
            int j = prefixFunction[i-1]; //TODO translate to eng
            // берем начальную точку отсчета уже обнаруженный префикс в прошлой итерации, если последующий символ будет схож значит
            // префикс функция достигла максимального значаения(по свойству 1), если же нет, то нам требуется уменьшить префикс - вопрос, до какого j?
            // ответ - исходя из свойства префикс функции 2(беря префикс функцию от текущего префикса можно получить все под префиксы строки)
            // пример "abacaba" > pi(7) = 3, pi(3) = 1, pi(1) = 0;
            // мы можем узнать ближайший меньший префикс (его длинну), использовав ее как j - можно будет увидеть
            // что теперь мы сравнимаем элемент идущий сразуже после уже подтвержденного префикса с последним элементом текущей стоки длинной i
            while(j > 0 && stringToSearch.charAt(j)!=stringToSearch.charAt(i)){
                j = prefixFunction[j-1];
            }
            if(stringToSearch.charAt(j) == stringToSearch.charAt(i)) prefixFunction[i] = j+1;
        }
        Utils.DBG("S^1 Prefix function array ");
        Utils.DBG(prefixFunction);
    }
    public void findUsingKMPSearchS2DecreasingCalculatedPrefixLength(String str){
        int[] prefixFunction = new int[str.length()];
        for(int i = 1; i < str.length(); i++){ // ?
            Utils.DBG("i = "+i);
            int j = 0;// пользуясь 1м свойством префиксфункции pi[i+1] <= pi[i]+1 мы можем определить максимально возможную длину суффикса
            for (j = prefixFunction[i-1]+1; j >= 0 ; j--){ // j изменяет длинну префикса начиная с макс возм длинны и опускаясь до 1 (2 символов)
                Utils.DBG("j = "+j);
                boolean prefixMatches = true;
                for(int k = 0; k < j; k++){ // k является индексом позволяющим проходить весь массив для сравнения
                    Utils.DBG(" str["+(k)+"] = "+ str.charAt(k) );
                    Utils.DBG(" compareTo str["+(i-j+k)+"]= "+str.charAt((i-j+k+1)));
                    if(str.charAt(k) != str.charAt(i - j + k +1)){
                        prefixMatches = false;
                        break;
                    }
                }
                Utils.DBG("I ve reached this line with J = " +j);
                if(prefixMatches) {
                    Utils.DBG("setting prefix func value to "+j);
                    prefixFunction[i] = j; // because of that array indexing starts from 0, which means 1;
                    break;
                }
            }
        }
        Utils.DBG("S^2 Prefix function array ");
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
}
