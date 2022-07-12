package entities;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class CreditCardTransaction {
    private CreditCard creditCard;
    private LocalDateTime date;
    private String reference;
    private BigDecimal amount;
    private BigDecimal balance;

    public CreditCardTransaction(CreditCard creditCard, LocalDateTime date, String reference, BigDecimal amount, BigDecimal balance) {
        this.setCreditCard(creditCard);
        this.setDate(date);
        this.setReference(reference);
        this.setAmount(amount);
        this.setBalance(balance);
    }

    public CreditCard getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
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
