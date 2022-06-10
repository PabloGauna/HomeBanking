package gui.accounts;

import javax.swing.*;
import java.awt.*;

public abstract class AccountFormPanel extends JPanel {
    private JTextField numberTxt;
    private JTextField balanceTxt;
    private JTextField userTxt;
    private JTextField typeTxt;

    public JTextField getNumberTxt() {
        return numberTxt;
    }

    public void setNumberTxt(JTextField numberTxt) {
        this.numberTxt = numberTxt;
    }

    public JTextField getBalanceTxt() {
        return balanceTxt;
    }

    public void setBalanceTxt(JTextField balanceTxt) {
        this.balanceTxt = balanceTxt;
    }

    public JTextField getUserTxt() {
        return userTxt;
    }

    public void setUserTxt(JTextField userTxt) {
        this.userTxt = userTxt;
    }

    public JTextField getTypeTxt() {
        return typeTxt;
    }

    public void setTypeTxt(JTextField typeTxt) {
        this.typeTxt = typeTxt;
    }

    public void createAccountForm(){
        JLabel numberLbl = new JLabel("Numero:");
        JLabel balanceLbl = new JLabel("Balance:");
        JLabel userLbl = new JLabel("Usuario:");
        JLabel typeLbl = new JLabel("Tipo cta:");

        numberTxt = new JTextField("");
        numberTxt.setPreferredSize(new Dimension(400,40));
        balanceTxt = new JTextField("");
        balanceTxt.setPreferredSize(new Dimension(400,40));
        userTxt = new JTextField("");
        userTxt.setPreferredSize(new Dimension(400,40));
        typeTxt = new JTextField("");
        typeTxt.setPreferredSize(new Dimension(400,40));

        this.add(numberLbl, BorderLayout.CENTER);
        this.add(numberTxt, BorderLayout.CENTER);
        this.add(balanceLbl, BorderLayout.CENTER);
        this.add(balanceTxt, BorderLayout.CENTER);
        this.add(userLbl, BorderLayout.CENTER);
        this.add(userTxt, BorderLayout.CENTER);
        this.add(typeLbl, BorderLayout.CENTER);
        this.add(typeTxt, BorderLayout.CENTER);
    }
}
