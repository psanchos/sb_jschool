package ru.sbrf.jschool.spring.jdbc.model;

import java.math.BigDecimal;

/**
 * Created by SBT-Pozdnyakov-AN on 30.07.2018.
 */
public class Account {
    private Integer id;
    private String currency;
    private BigDecimal balance;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", currency='" + currency + '\'' +
                ", balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
