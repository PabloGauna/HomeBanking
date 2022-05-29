package services;

import dao.AccountDAO;
import dao.AccountDAOH2Impl;
import dao.DAOException;
import dao.DuplicatedEntryException;
import entities.Account;

public class AccountService implements IAccountService  {
    private final AccountDAO accountDAO = new AccountDAOH2Impl();

    public void createAccount(Account account) throws AccountServiceException {
        try {
            accountDAO.create(account);
        } catch (DAOException | DuplicatedEntryException e) {
            e.printStackTrace();
            throw new AccountServiceException(e);
        }
    }
}
