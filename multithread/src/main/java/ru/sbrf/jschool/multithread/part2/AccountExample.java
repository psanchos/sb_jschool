package ru.sbrf.jschool.multithread.part2;

public class AccountExample extends Thread{

    private Account account;

    public AccountExample(Account account) {
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            account.withdraw(10);
            if (account.getBalance() < 0) {
                System.err.println("account is overdrawn");
            }
        }
    }

    public Account getAccount() {
        return account;
    }

    public static void main(String[] args) throws InterruptedException {
        Account account = new Account();
        AccountExample t1 = new AccountExample(account);
        AccountExample t2 = new AccountExample(account);

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        System.out.println(account.getBalance());

    }
}
