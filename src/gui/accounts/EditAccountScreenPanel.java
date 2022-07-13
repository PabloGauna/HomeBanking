package gui.accounts;

import entities.Account;
import entities.types.AccountType;
import gui.ScreenManager;
import services.AccountService;
import services.AccountServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

public class EditAccountScreenPanel extends AccountFormPanel {

    private AccountsNavigationButtonsPanel accountsNavigationButtonsPanel;
    private JButton editAccountButton;
    private ScreenManager _screenManager;
    private AccountService _accountService;

    public EditAccountScreenPanel(ScreenManager screenManager, AccountService accountService){
        _screenManager = screenManager;
        _accountService = accountService;

        accountsNavigationButtonsPanel = new AccountsNavigationButtonsPanel(screenManager);

        this.createAddAccountForm();
        this.addActionListeners();

        this.add(accountsNavigationButtonsPanel, BorderLayout.PAGE_END);
    }

    private void createAddAccountForm(){
        JLabel titleLbl = new JLabel("Editar Cuenta");
        titleLbl.setPreferredSize(new Dimension(500,40));
        this.add(titleLbl);

        this.createAccountForm();

        editAccountButton = new JButton("Editar Cuenta");
        this.add(editAccountButton, BorderLayout.CENTER);
    }

    private void addActionListeners(){
        this.editAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    _accountService.updateAccount(new Account(
                        Integer.parseInt(getNumberTxt().getText()),
                        new BigDecimal(getBalanceTxt().getText()),
                        getUserTxt().getText(),
                        AccountType.valueOf(getTypeTxt().getText())
                    ));

                    _screenManager.showAccountsListScreenPanel();
                } catch (AccountServiceException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }
}
