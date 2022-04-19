package TESTS_AND_CODE;

import java.math.BigInteger;
import java.util.Random;
import java.util.SortedSet;
import java.util.TreeSet;

public class SingleThreadedBigPrimes {
    public static void main(String[] args) {

        long start = System.currentTimeMillis();

        SortedSet<BigInteger> primes= new TreeSet<>();

        while(primes.size()<100)
        {
            BigInteger bigInteger = new BigInteger(2000,new Random());
            primes.add(bigInteger.nextProbablePrime());
        }




        long end = System.currentTimeMillis();

        System.out.println(primes);

        System.out.println("Took a : " +(end-start));
    }
}
