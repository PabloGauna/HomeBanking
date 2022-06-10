package gui;

import gui.accounts.AccountsListScreenPanel;
import gui.accounts.CreateAccountScreenPanel;
import services.AccountService;
import services.AccountServiceException;

import javax.swing.*;
import java.awt.*;

public class ScreenManager {

    private JFrame frame;
    private AccountsListScreenPanel accountsListScreenPanel;
    private CreateAccountScreenPanel createAccountScreenPanel;

    private AccountService accountService = new AccountService();

    public ScreenManager() {
        try {
            accountsListScreenPanel = new AccountsListScreenPanel(this, accountService);
            createAccountScreenPanel = new CreateAccountScreenPanel(this, accountService);
        } catch (AccountServiceException e) {
            throw new RuntimeException(e);
        }
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
        frame.getContentPane().removeAll();
        frame.getContentPane().add(createAccountScreenPanel);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }
}
