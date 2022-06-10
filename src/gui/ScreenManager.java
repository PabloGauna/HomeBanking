package gui;

import entities.Account;
import gui.accounts.AccountsListScreenPanel;
import gui.accounts.CreateAccountScreenPanel;
import gui.accounts.EditAccountScreenPanel;
import services.AccountService;
import services.AccountServiceException;

import javax.swing.*;

public class ScreenManager {

    private JFrame frame;
    private AccountsListScreenPanel accountsListScreenPanel;
    private CreateAccountScreenPanel createAccountScreenPanel;
    private EditAccountScreenPanel editAccountScreenPanel;

    private AccountService accountService = new AccountService();

    public AccountsListScreenPanel getAccountsListScreenPanel() {
        return accountsListScreenPanel;
    }

    public void setAccountsListScreenPanel(AccountsListScreenPanel accountsListScreenPanel) {
        this.accountsListScreenPanel = accountsListScreenPanel;
    }

    public ScreenManager() {
        accountsListScreenPanel = new AccountsListScreenPanel(this, accountService);
        createAccountScreenPanel = new CreateAccountScreenPanel(this, accountService);
        editAccountScreenPanel = new EditAccountScreenPanel(this, accountService);
    }

    public void createMainScreen() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 550);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    public void showAccountsListScreenPanel() {
        try {
            accountsListScreenPanel.loadAccountsTable();
        } catch (AccountServiceException e) {
            throw new RuntimeException(e);
        }

        frame.getContentPane().removeAll();
        frame.getContentPane().add(accountsListScreenPanel);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void showCreateAccountScreenPanel() {
        createAccountScreenPanel.getNumberTxt().setText("");
        createAccountScreenPanel.getBalanceTxt().setText("");
        createAccountScreenPanel.getUserTxt().setText("");
        createAccountScreenPanel.getTypeTxt().setText("");

        frame.getContentPane().removeAll();
        frame.getContentPane().add(createAccountScreenPanel);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }

    public void showEditAccountScreenPanel(Account account) {
        editAccountScreenPanel.getNumberTxt().setText(String.valueOf(account.getNumber()));
        editAccountScreenPanel.getBalanceTxt().setText(String.valueOf(account.getBalance()));
        editAccountScreenPanel.getUserTxt().setText(String.valueOf(account.getUser()));
        editAccountScreenPanel.getTypeTxt().setText(String.valueOf(account.getType()));

        frame.getContentPane().removeAll();
        frame.getContentPane().add(editAccountScreenPanel);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }
}
