package ru.sbrf.jschool.multithread.part2;

public class AccountExample {

    private Account account = new Account();

    public void makeWithdrawal(int amt) {
        if (account.getBalance() >= amt) {
            account.withdraw(amt);
            System.out.println(String.format("Thread %s withdraw new ballance %d",
                    Thread.currentThread().getName(),
                    account.getBalance()));
        }else{
            //System.out.println(String.format("not enough for %s ", Thread.currentThread().getName()));
        }
    }

    public void run(){
        for(int i = 0; i< 5;i++){
            makeWithdrawal(10);
            if(account.getBalance()<0){
                System.err.println("account is overdrawn");
            }
        }
    }
    public Account getAccount() {
        return account;
    }

    public static void main(String[] args) {
        AccountExample accountExample  = new AccountExample();
        for(int i=0; i<6;i++){
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    accountExample.run();
                }
            });
            t.start();
        }
    }
}
