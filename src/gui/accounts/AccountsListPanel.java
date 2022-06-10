package gui.accounts;

import entities.Account;
import gui.ScreenManager;
import services.AccountService;
import services.AccountServiceException;

import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AccountsListPanel extends JPanel {
    private JTable accountsTable;
    private AccountsTableModel model;
    private JScrollPane tableScrollPanel;

    private AccountService service = new AccountService();

    public AccountsListPanel(ScreenManager screenManager) throws AccountServiceException {
        this.setLayout(new FlowLayout());

        model = new AccountsTableModel();
        accountsTable = new JTable(model);
        tableScrollPanel = new JScrollPane(accountsTable);
        this.add(tableScrollPanel);

        loadAccountsTable();
    }

    private void loadAccountsTable() throws AccountServiceException {
        List<Account> accountList = service.getAllAccounts();

        model.setContent(accountList);
    }
}
