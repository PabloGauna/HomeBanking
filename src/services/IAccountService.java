package services;

import entities.Account;

public interface IAccountService {
    void createAccount(Account account) throws AccountServiceException;
}
