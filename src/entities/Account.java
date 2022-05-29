package entities;

public class Account {

    private int number;
    private float balance;

    public Account(int number, float balance) {
        this.setNumber(number);
        this.setBalance(balance);
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }
}
