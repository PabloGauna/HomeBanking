package com.company;

import entities.Account;
import entities.AccountType;
import services.AccountService;
import services.AccountServiceException;
import services.IAccountService;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        IAccountService accountService = new AccountService();

        Account account = new Account(12313123, new BigDecimal(100), "Pablo", AccountType.CAJA_DE_AHORROS);

        try {
            accountService.createAccount(account);
        } catch (AccountServiceException e) {
            e.printStackTrace();
        }

        try {
            account = accountService.getAccountById(12313123);
        } catch (AccountServiceException e) {
            e.printStackTrace();
        }

        account.setUser("Pepito");

        try {
            accountService.updateAccount(account);
        } catch (AccountServiceException e) {
            e.printStackTrace();
        }

        try {
            accountService.deleteAccount(12313123);
        } catch (AccountServiceException e) {
            e.printStackTrace();
        }


    }
}
