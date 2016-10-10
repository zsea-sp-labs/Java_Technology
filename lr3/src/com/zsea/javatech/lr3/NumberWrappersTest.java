package com.zsea.javatech.lr3;

import com.zsea.javatech.lr1.Utils;

/**
 * Created by truerall on 10/10/16.
 */
public class NumberWrappersTest {
    public NumberWrappersTest(){
        int i = 0;
        short sh = 0;
        double d = 0;
        String testDouble = "3.14";
        String testShort = "23";
        String testInteger = "32";
        Integer k1 = new Integer(55);
        Integer k2 = new Integer(100);
        Double d1 = new Double(3.14);
        Long l1 = new Long(123);
        Float f1 = new Float(1.0f);
        Byte b1 = new Byte("4");

        try{
            i = Integer.parseInt(testInteger);
            sh = Short.parseShort(testShort);
            d = Double.parseDouble(testDouble);
        }catch(Exception e){}
        double x = 1.0/0.0;
        Utils.DBG("i = " + i) ;
        Utils.DBG("sh - " + sh) ;
        Utils.DBG("d. = " + d) ;
        Utils.DBG("kl.intValue() = " + k1.intValue());
        Utils.DBG("dl.intValue() '= "+ d1.intValue());
        Utils.DBG("kl > k2? " + k1.compareTo(k2));
        Utils.DBG ("x = " + x);
        Utils.DBG("x isNaN? " + Double.isNaN(x));
        Utils.DBG("x isInfinite? " + Double.isInfinite(x));
        Utils.DBG("x == Infinity? " + (x == Double.POSITIVE_INFINITY) );
        Utils.DBG("d = " + Double.doubleToLongBits(d));
        Utils.DBG("i = " + Integer.toBinaryString(i));
        Utils.DBG("i = " + Integer.toHexString(i));
        Utils.DBG("i = " + Integer.toOctalString(i));
        Utils.DBG("l1 bitcount = " + Long.bitCount(l1));
        Utils.DBG("f1 HexString = " + Float.toHexString(f1));
        Utils.DBG("b1 float value ="+b1.floatValue());
    }
}

