package services;

import dao.AccountDAO;
import dao.AccountDAOH2Impl;
import dao.DAOException;
import dao.DuplicatedEntryException;
import entities.Account;

import java.util.List;

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

    public void updateAccount(Account account) throws AccountServiceException {
        try {
            accountDAO.update(account);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (DuplicatedEntryException e) {
            e.printStackTrace();
            throw new AccountServiceException(e);
        }
    }

    public Account getAccountById(int id) throws AccountServiceException {
        Account result;
        try {
            result = accountDAO.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new AccountServiceException(e);
        }
        return result;
    }

    public List<Account> getAllAccounts() throws AccountServiceException {
        List<Account> result;
        try {
            result = accountDAO.getAll();
        } catch (DAOException e) {
            throw new AccountServiceException(e);
        }
        return result;
    }

    public void deleteAccount(int id) throws AccountServiceException {
        try {
            accountDAO.delete(id);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (DuplicatedEntryException e) {
            e.printStackTrace();
            throw new AccountServiceException(e);
        }
    }
}
