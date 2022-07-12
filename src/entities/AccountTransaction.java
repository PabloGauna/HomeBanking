package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class AccountTransaction {
    private Account account;
    private LocalDateTime date;
    private String reference;
    private BigDecimal amount;
    private BigDecimal balance;

    public AccountTransaction(Account account, LocalDateTime date, String reference, BigDecimal amount, BigDecimal balance) {
        this.setAccount(account);
        this.setDate(date);
        this.setReference(reference);
        this.setAmount(amount);
        this.setBalance(balance);
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
