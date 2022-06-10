package gui;

import gui.accounts.AccountsListPanel;
import services.AccountServiceException;

import javax.swing.*;

public class ClasePrincipal {
    private static ScreenManager screenManager;

    public static void main(String[] args) {
        ClasePrincipal ppal = new ClasePrincipal();
        ppal.startManager();
        ppal.showFrame();
    }

    public void startManager() {
        screenManager = new ScreenManager();
        screenManager.createMainScreen();
        screenManager.showAccountsListPanel();
    }

    public void showFrame() {
        screenManager.showFrame();
    }
}
