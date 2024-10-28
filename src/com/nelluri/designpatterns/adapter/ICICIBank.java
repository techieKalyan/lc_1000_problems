package com.nelluri.designpatterns.adapter;

public class ICICIBank {

    boolean transferDudhu(String src, String dest, Double amt) {
        System.out.println(amt + " Amount transferred from " + src + " to " + dest);
        return true;
    }

    double getBalanceMoney(String accName) {
        return 100000;
    }

}
