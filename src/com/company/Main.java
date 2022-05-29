package com.company;

import entities.Account;
import services.AccountService;
import services.AccountServiceException;
import services.IAccountService;

public class Main {

    public static void main(String[] args) {
        IAccountService accountService = new AccountService();

        try {
            accountService.createAccount(new Account(12313123));
        } catch (AccountServiceException e) {
            e.printStackTrace();
        }
    }
}
