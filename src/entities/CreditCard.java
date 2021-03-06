package entities;

import entities.types.CreditCardType;

import java.math.BigDecimal;

public class CreditCard {
    private int number;
    private BigDecimal availableCredit;
    private BigDecimal creditAccessLine;
    private String user;
    private CreditCardType type;
}
