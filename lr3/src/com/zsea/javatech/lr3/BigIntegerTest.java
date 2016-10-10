package com.zsea.javatech.lr3;

/**
 * Created by truerall on 10/10/16.
 */

import com.zsea.javatech.lr1.Utils;

import java.math.BigInteger;

class BigIntegerTest{
    public BigIntegerTest(){
         BigInteger a = new BigInteger("99999999999999999") ;
         BigInteger b = new BigInteger("88888888888888888888");
         Utils.DBG("bits in a = " + a.bitLength());
         Utils.DBG("bits in b = " + b.bitLength());
         Utils.DBG("a + b = " + a.add(b));
         Utils.DBG("a & b = " + a.and(b));
         Utils.DBG("a & ~b = " + a.andNot(b));
         Utils.DBG("a / b = " + a.divide(b));
         BigInteger[] r = a.divideAndRemainder(b);
         Utils.DBG("a / b: q = " + r[0] + ", r = " + r[1]);
         Utils.DBG("gcd(a, b) = " + a.gcd(b));
         Utils.DBG("max(a, b) = " + a.max(b));
         Utils.DBG("min(a, b) = " + a.min(b));
         Utils.DBG("a mod b = " + a.mod(b));
         Utils.DBG("I/a mod b = " + a.modInverse(b));
         Utils.DBG("алп mod b = " + a.modPow(a, b));
         Utils.DBG("a * b = " + a.multiply(b));
         Utils.DBG("-a = " + a.negate());
         Utils.DBG("~a = " + a.not());
         Utils.DBG("a | b = " + a.or(b));
         Utils.DBG("а л 3 = " + a.pow(3));
         Utils.DBG("a % b = " + a.remainder(b));
         Utils.DBG("a « 3 = " + a.shiftLeft(3));
         Utils.DBG("a » 3 = " + a.shiftRight(3));
         Utils.DBG("sign(a) = " + a.signum());
         Utils.DBG("a - b = " + a.subtract(b));
         Utils.DBG("а л b = " + a.xor(b));
    }
}
