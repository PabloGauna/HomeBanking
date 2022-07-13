package entities;

import entities.types.AccountType;

import java.math.BigDecimal;

public class Account {

    private int number;
    private BigDecimal balance;
    private String user;
    private AccountType type;

    public Account(int number, BigDecimal balance, String user, AccountType type) {
        this.setNumber(number);
        this.setBalance(balance);
        this.setUser(user);
        this.setType(type);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public AccountType getType() {
        return type;
    }

    public void setType(AccountType type) {
        this.type = type;
    }
}
