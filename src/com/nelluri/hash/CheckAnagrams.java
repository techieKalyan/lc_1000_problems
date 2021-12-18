package com.nelluri.hash;

import java.util.HashMap;
import java.util.Map;

public class CheckAnagrams {

    public boolean check(String input1, String input2) {
        if(input1 == null || input2 == null) {
            return false;
        }
        if(input1.length() != input2.length()) {
            return false;
        }
        char[] inputChar1 = input1.toCharArray();
        char[] inputChar2 = input2.toCharArray();

        Map<Character, Integer> lookup = new HashMap<>();

        for(int i=0; i < inputChar1.length; i++) {
            lookup.put(inputChar1[i],lookup.getOrDefault(inputChar1[i],0)+1);
        }

        for(int i=0; i < inputChar2.length; i++) {
            if(lookup.containsKey(inputChar2[i]) == false || lookup.get(inputChar2[i]) == 0) {
                return false;
            }
            lookup.put(inputChar2[i],lookup.get(inputChar2[i])-1);
        }

        return true;
    }

    public static void main(String[] args) {
        CheckAnagrams checkAnagrams = new CheckAnagrams();
        System.out.println("Are these anagrams ? " + checkAnagrams.check("aabbcdd","abcdabd"));
    }
}
