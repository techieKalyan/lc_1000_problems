package com.nelluri.designpatterns.adapter;

public interface BankAPI {

    boolean transferMoney(String src, String dest, Double amt);

    double getBalance(String accName);

}
