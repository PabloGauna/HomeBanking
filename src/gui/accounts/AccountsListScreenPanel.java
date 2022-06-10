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

    private AccountService service = new AccountService();

    public AccountsListScreenPanel(ScreenManager screenManager) throws AccountServiceException {
        this.setLayout(new FlowLayout());
        accountsNavigationButtonsPanel = new AccountsNavigationButtonsPanel(screenManager);

        model = new AccountsTableModel();
        accountsTable = new JTable(model);
        tableScrollPanel = new JScrollPane(accountsTable);

        this.add(tableScrollPanel);
        this.add(accountsNavigationButtonsPanel, BorderLayout.PAGE_END);

        loadAccountsTable();
    }

    private void loadAccountsTable() throws AccountServiceException {
        List<Account> accountList = service.getAllAccounts();

        model.setContent(accountList);
    }
}
