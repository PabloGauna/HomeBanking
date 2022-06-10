package gui.accounts;

import entities.Account;
import entities.AccountType;
import gui.ScreenManager;
import services.AccountService;
import services.AccountServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class CreateAccountScreenPanel extends JPanel {

    private AccountsNavigationButtonsPanel accountsNavigationButtonsPanel;
    private JTextField numberTxt;
    private JTextField balanceTxt;
    private JTextField userTxt;
    private JTextField typeTxt;

    private JButton addAccountButton;

    private ScreenManager _screenManager;
    private AccountService _accountService;

    public CreateAccountScreenPanel(ScreenManager screenManager, AccountService accountService){
        _screenManager = screenManager;
        _accountService = accountService;

        accountsNavigationButtonsPanel = new AccountsNavigationButtonsPanel(screenManager);

        this.CreateAddAccountForm();
        this.AddActionListeners();

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

    private void AddActionListeners(){
        this.addAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    _accountService.createAccount(new Account(
                        Integer.parseInt(numberTxt.getText()),
                        new BigDecimal(balanceTxt.getText()),
                        userTxt.getText(),
                        AccountType.valueOf(typeTxt.getText())
                    ));

                    _screenManager.showAccountsListScreenPanel();
                } catch (AccountServiceException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
