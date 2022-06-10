package gui;

import gui.accounts.AccountsListPanel;
import services.AccountServiceException;

import javax.swing.*;

public class ScreenManager {

    private JFrame frame;
    private AccountsListPanel accountsListPanel;

    public ScreenManager() {
        try {
            accountsListPanel = new AccountsListPanel(this);
        } catch (AccountServiceException e) {
            throw new RuntimeException(e);
        }
    }

    public void createMainScreen() {
        frame = new JFrame();
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void showFrame() {
        frame.setVisible(true);
    }

    public void showAccountsListPanel() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(accountsListPanel);
        frame.getContentPane().validate();//RE-dispongo los elementos segun el layout
        frame.getContentPane().repaint();//RE-pinto los elementos dispuestos en el paso anterior
    }
}
