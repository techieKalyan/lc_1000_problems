package com.nelluri.designpatterns.adapter;

public class ICICIBankAdapter implements BankAPI{

    ICICIBank bank = new ICICIBank();

    @Override
    public boolean transferMoney(String src, String dest, Double amt) {
        return bank.transferDudhu(src, dest, amt);
    }

    @Override
    public double getBalance(String accName) {
        return bank.getBalanceMoney(accName);
    }
}
