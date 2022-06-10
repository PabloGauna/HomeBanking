package services;

import dao.DAOException;
import entities.Account;
import java.util.List;

public interface IAccountService {
    void createAccount(Account account) throws AccountServiceException;
    void updateAccount(Account account) throws AccountServiceException;
    Account getAccountById(int id) throws AccountServiceException;
    List<Account> getAllAccounts() throws AccountServiceException, DAOException;
    void deleteAccount(int id) throws AccountServiceException;
}
