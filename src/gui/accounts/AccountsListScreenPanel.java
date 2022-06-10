package gui.accounts;

import entities.Account;
import gui.ScreenManager;
import services.AccountService;
import services.AccountServiceException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AccountsListScreenPanel extends JPanel {
    private AccountService _accountService;
    private ScreenManager _screenManager;

    private AccountsNavigationButtonsPanel accountsNavigationButtonsPanel;
    private AccountsTableModel model;
    private JTable accountsTable;
    private JScrollPane tableScrollPanel;

    private JButton deleteAccountButton;

    public AccountsListScreenPanel(ScreenManager screenManager, AccountService accountService) throws AccountServiceException {
        _accountService = accountService;
        _screenManager = screenManager;

        this.setLayout(new FlowLayout());

        model = new AccountsTableModel();
        accountsTable = new JTable(model);
        tableScrollPanel = new JScrollPane(accountsTable);

        deleteAccountButton = new JButton("Borrar Cuenta");
        accountsNavigationButtonsPanel = new AccountsNavigationButtonsPanel(screenManager);

        this.add(new JLabel("Cuentas Bancarias"), BorderLayout.NORTH);
        this.add(tableScrollPanel, BorderLayout.CENTER);
        this.add(deleteAccountButton, BorderLayout.CENTER);
        this.add(accountsNavigationButtonsPanel, BorderLayout.PAGE_END);

        addActionListeners();
        loadAccountsTable();
    }

    private void addActionListeners(){
        deleteAccountButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Account deletedAccount = deleteAccountsTableSelectedRow();

                try {
                    _accountService.deleteAccount(deletedAccount.getNumber());
                } catch (AccountServiceException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });
    }

    public void loadAccountsTable() throws AccountServiceException {
        List<Account> accountList = _accountService.getAllAccounts();

        model.setContent(accountList);
    }

    private Account deleteAccountsTableSelectedRow() {
        int selectedRow = accountsTable.getSelectedRow();
        Account deletedAccount = model.getContent().get(selectedRow);
        model.getContent().remove(selectedRow);
        model.fireTableDataChanged();

        return deletedAccount;
    }
}
