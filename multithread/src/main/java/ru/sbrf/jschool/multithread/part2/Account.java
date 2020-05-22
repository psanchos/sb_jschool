package ru.sbrf.jschool.multithread.part2;

public class Account {
    private int balance = 100;
    public int getBalance() {
        return balance;
    }
    public void withdraw(int amount){
        if (balance>= amount) {
            balance = balance - amount;
            System.out.println(String.format("Thread %s withdraw new ballance %d",
                    Thread.currentThread().getName(),
                    balance));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(String.format("not enough for %s ", Thread.currentThread().getName()));
        }

    }
}
