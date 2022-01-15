package com.nelluri.strings;

import java.lang.*;
import java.util.*;

public class CheckPalindrom {
    public static void main(String[] args) {
        // YOUR CODE GOES HERE
        // Please take input and print output to standard input/output (stdin/stdout)
        // DO NOT USE ARGUMENTS FOR INPUTS
        // E.g. 'Scanner' for input & 'System.out' for output
        CheckPalindrom main = new CheckPalindrom();
        Scanner in = new Scanner(System.in);
        int numTestCases = Integer.parseInt(in.nextLine());

        for(int i=0; i < numTestCases ; i++) {
            String input = in.nextLine();
            int isPalindrome = main.checkForPalindrome(input);
            System.out.println(isPalindrome);
        }
        in.close();
    }

    public int checkForPalindrome(String input) {
        if(input == null || input.equals("")) {
            return 1;
        }
        char[] inputChars = input.toCharArray();

        int start = 0;
        int end = inputChars.length - 1;

        while(start < end) {
            if(inputChars[start] != inputChars[end]) {
                return 0;
            } else {
                start++;
                end--;
            }

        }
        if(start >= end) {
            return 1;
        } else{
            return 0;
        }
    }

}