package com.nelluri.strings;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindromeWithTwist {

    String solution(String s) {
        do {
        Map<String, Integer> palindromePrefixes = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            String prefix = s.substring(0, i + 1);
            if (checkIfPalindrome(prefix)) {
                palindromePrefixes.put(prefix, prefix.length());
            } else {
                continue;
            }

        }
        java.util.Map.Entry<String, Integer> maxEntry = null;
        for (java.util.Map.Entry<String, Integer> entry : palindromePrefixes.entrySet()) {
            if (maxEntry == null || entry.getValue()
                    .compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        if(maxEntry == null) {
            return "";
        }
        String maxLengthPalindrome = maxEntry.getKey();

        if (maxLengthPalindrome.length() <= 2) {
            return maxLengthPalindrome;
        } else {
          //  System.out.println(maxLengthPalindrome);
            s = s.replaceAll(maxLengthPalindrome, "");
            if(s.equals("")) {
                return "";
            }
        }
    }while(true);
       // System.out.println(maxLengthPalindrome);

       // return "";
    }



    boolean checkIfPalindrome(String s) {
        return s.equals(new StringBuilder(s).reverse().toString());
    }

    public static void main(String[] args) {
        LongestPalindromeWithTwist longestPalindromeWithTwist = new LongestPalindromeWithTwist();
        longestPalindromeWithTwist.solution("aaacodedoc");
    }

}
