package com.nelluri;

/*
Finds all prime from 1 to a range(n)
 */
import java.util.BitSet;

public class SievePrimes {

    // initially all the bits will be set to 0.
    BitSet primes = new BitSet(100000);

    void computePrimes() {
        // start with first prime number
        int p=2;
        do {
                int idx = 2;
                while (p * idx < primes.size()) {
                    primes.set(p * idx);
                    idx += 1;
                }
                int i=p+1;
                for(; i < primes.size(); i++) {
                    if(primes.get(i) == false) {
                        p = i;
                        break;
                    }
                }
                if(i == primes.size()) {
                    break;
                }
        } while(true);

        for(int i=2; i < primes.size(); i++) {
            if(primes.get(i) == false) {
                System.out.println(i);
            }
        }

    }
    public static void main(String[] args) {
        SievePrimes primes = new SievePrimes();
        primes.computePrimes();
    }

}
