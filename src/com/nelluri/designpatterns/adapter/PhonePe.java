package com.nelluri.designpatterns.adapter;

public class PhonePe {
    public static void main(String[] args) {
        BankAPI bankAPI = new ICICIBankAdapter();
        bankAPI.transferMoney("src","dest", Double.valueOf(1000));
        System.out.println("Balance is " + bankAPI.getBalance("Kalyan"));
    }
}
