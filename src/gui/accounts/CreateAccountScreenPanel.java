package gui.accounts;

import gui.ScreenManager;
import javax.swing.*;
import java.awt.*;

public class CreateAccountScreenPanel extends JPanel {

    private AccountsNavigationButtonsPanel accountsNavigationButtonsPanel;
    private JTextField numberTxt;
    private JTextField balanceTxt;
    private JTextField userTxt;
    private JTextField typeTxt;

    private JButton addAccountButton;

    public CreateAccountScreenPanel(ScreenManager screenManager){
        accountsNavigationButtonsPanel = new AccountsNavigationButtonsPanel(screenManager);

        this.CreateAddAccountForm();

        this.add(accountsNavigationButtonsPanel, BorderLayout.PAGE_END);
    }

    private void CreateAddAccountForm(){
        JLabel titleLbl = new JLabel("Nueva Cuenta");
        titleLbl.setPreferredSize(new Dimension(500,40));

        JLabel numberLbl = new JLabel("Numero:");
        JLabel balanceLbl = new JLabel("Balance:");
        JLabel userLbl = new JLabel("Usuario:");
        JLabel typeLbl = new JLabel("Tipo cta:");

        addAccountButton = new JButton("Crear Cuenta");

        numberTxt = new JTextField("");
        numberTxt.setPreferredSize(new Dimension(400,40));
        balanceTxt = new JTextField("");
        balanceTxt.setPreferredSize(new Dimension(400,40));
        userTxt = new JTextField("");
        userTxt.setPreferredSize(new Dimension(400,40));
        typeTxt = new JTextField("");
        typeTxt.setPreferredSize(new Dimension(400,40));

        this.add(titleLbl, BorderLayout.CENTER);
        this.add(numberLbl, BorderLayout.CENTER);
        this.add(numberTxt, BorderLayout.CENTER);
        this.add(balanceLbl, BorderLayout.CENTER);
        this.add(balanceTxt, BorderLayout.CENTER);
        this.add(userLbl, BorderLayout.CENTER);
        this.add(userTxt, BorderLayout.CENTER);
        this.add(typeLbl, BorderLayout.CENTER);
        this.add(typeTxt, BorderLayout.CENTER);

        this.add(addAccountButton, BorderLayout.CENTER);
    }
}
