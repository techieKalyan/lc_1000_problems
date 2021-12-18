package com.nelluri.hash;

import java.util.BitSet;

/*
This implementation uses Bitset of java for using bit array.
 */
public class CheckFirstDuplicateUsingBitSet {

    public char checkFirstDuplicateCharacter(String input1) {

        // Assuming only ASCII Character set in the input strings.
        BitSet bitSet = new BitSet(256);

        for(int i=0; i < input1.length(); i++) {
            if(bitSet.get(input1.charAt(i))) {
                return input1.charAt(i);
            }
            bitSet.set(input1.charAt(i));
        }

        return ' ';
    }

    public static void main(String[] args) {
        CheckFirstDuplicateUsingBitSet checkFirstDuplicateUsingBitSet = new CheckFirstDuplicateUsingBitSet();
        System.out.println(checkFirstDuplicateUsingBitSet.checkFirstDuplicateCharacter("abcdefsffdfd"));
    }

}
