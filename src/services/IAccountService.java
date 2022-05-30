package services;

import entities.Account;

public interface IAccountService {
    void createAccount(Account account) throws AccountServiceException;
    void updateAccount(Account account) throws AccountServiceException;
    Account getAccountById(int id) throws AccountServiceException;
    void deleteAccount(int id) throws AccountServiceException;
}
