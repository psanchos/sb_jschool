package ru.sbrf.jschool.multithread.part2;

public class Account {
    private int balance = 50;
    public int getBalance() {
        return balance;
    }
    public void withdraw(int amount){
        this.balance = this.balance - amount;
    }
}
