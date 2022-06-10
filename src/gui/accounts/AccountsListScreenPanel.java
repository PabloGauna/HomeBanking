package gui.accounts;

import entities.Account;
import gui.ScreenManager;
import services.AccountService;
import services.AccountServiceException;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AccountsListScreenPanel extends JPanel {

    private AccountsNavigationButtonsPanel accountsNavigationButtonsPanel;
    private AccountsTableModel model;
    private JTable accountsTable;
    private JScrollPane tableScrollPanel;

    private AccountService accountService;

    public AccountsListScreenPanel(ScreenManager screenManager, AccountService as) throws AccountServiceException {
        accountService = as;

        this.setLayout(new FlowLayout());
        accountsNavigationButtonsPanel = new AccountsNavigationButtonsPanel(screenManager);

        model = new AccountsTableModel();
        accountsTable = new JTable(model);
        tableScrollPanel = new JScrollPane(accountsTable);

        this.add(tableScrollPanel);
        this.add(accountsNavigationButtonsPanel, BorderLayout.PAGE_END);

        loadAccountsTable();
    }

    public void loadAccountsTable() throws AccountServiceException {
        List<Account> accountList = accountService.getAllAccounts();

        model.setContent(accountList);
    }
}
