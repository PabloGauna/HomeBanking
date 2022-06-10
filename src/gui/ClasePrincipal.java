package gui;

import services.AccountServiceException;

import javax.swing.*;

public class ClasePrincipal {
    public static void main(String[] args) {
        JFrame j = new JFrame("Cuentas");

        try {
            j.getContentPane().add(new AccountsListPanel());
        } catch (AccountServiceException e) {
            throw new RuntimeException(e);
        }

        j.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        j.pack();
        j.setVisible(true);
    }
}
