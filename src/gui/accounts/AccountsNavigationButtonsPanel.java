package gui.accounts;

import gui.ScreenManager;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AccountsNavigationButtonsPanel extends JPanel {

    private ScreenManager screenManager;
    private JButton accountsListBtn;
    private JButton newAccountBtn;
    private JButton editAccountBtn;

    public AccountsNavigationButtonsPanel(ScreenManager screenManager) {
        this.screenManager = screenManager;
        createButtons();
    }

    public void createButtons() {
        accountsListBtn = new JButton("Ver Cuentas");
        newAccountBtn = new JButton("Nueva Cuenta");
        editAccountBtn = new JButton("Editar Cuenta");

        this.add(accountsListBtn);
        this.add(newAccountBtn);
        this.add(editAccountBtn);

        this.accountsListBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screenManager.showAccountsListScreenPanel();
            }
        });

        this.newAccountBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screenManager.showCreateAccountScreenPanel();
            }
        });

        this.editAccountBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                screenManager.showEditAccountScreenPanel(
                        screenManager.getAccountsListScreenPanel().getAccountsTableSelectedAccount()
                );
            }
        });
    }

    public JButton getNewAccountBtn() {
        return newAccountBtn;
    }

    public void setNewAccountBtn(JButton newAccountBtn) {
        this.newAccountBtn = newAccountBtn;
    }

    public JButton getEditAccountBtn() {
        return editAccountBtn;
    }

    public void setEditAccountBtn(JButton editAccountBtn) {
        this.editAccountBtn = editAccountBtn;
    }
}


