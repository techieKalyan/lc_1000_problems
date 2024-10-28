package com.nelluri.arrays;
/*
Write a fizzbuzz function that returns a List<String> with the numbers from 1 to n with the following restrictions:

for multiples of 3 store "Fizz" instead of the number

for multiples of 5 store "Buzz" instead of the number

for numbers which are multiples of both 3 and 5 store "FizzBuzz"
 */


import java.util.ArrayList;
import java.util.List;

public class Fizzbuzz {

    public ArrayList<String> fizzbuzz(int n) {
        ArrayList<String> fizzResponse = new ArrayList<String>();
        for (int i = 0; i < n; i++) {
            if ((i + 1) % 15 == 0) {
                fizzResponse.add("FizzBuzz");
                continue;
            } else if ((i + 1) % 3 == 0) {
                fizzResponse.add("Fizz");
            } else if ((i + 1) % 5 == 0) {
                fizzResponse.add("Buzz");
            } else {
                fizzResponse.add(Integer.valueOf(i + 1).toString());
            }
        }
        return fizzResponse;
    }

    public static void main(String[] args) {
        Fizzbuzz fb = new Fizzbuzz();
        ArrayList<String> response = fb.fizzbuzz(15);
        for(String s: response) {
            System.out.println(s);
        }
    }



}
