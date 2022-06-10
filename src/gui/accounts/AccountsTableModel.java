package gui.accounts;

import entities.Account;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class AccountsTableModel extends AbstractTableModel {

    private static final int COLUMNA_NUMBER = 0;
    private static final int COLUMNA_BALANCE = 1;
    private static final int COLUMNA_USER = 2;
    private static final int COLUMNA_TYPE = 3;

    private String[] nombresColumnas = {"Numero", "Balance", "Usuario", "Tipo"};
    private Class[] tiposColumnas = {Integer.class, Double.class, String.class, Integer.class};

    private List<Account> accountList;

    public int getColumnCount() {
        return nombresColumnas.length;
    }

    public int getRowCount() {
        return accountList.size();
    }

    public void setValueAt(Object value, int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        super.setValueAt(value, rowIndex, columnIndex);
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        Account a = accountList.get(rowIndex);

        Object result = null;
        switch(columnIndex) {
            case COLUMNA_NUMBER:
                result = a.getNumber();
                break;
            case COLUMNA_BALANCE:
                result = a.getBalance();
                break;
            case COLUMNA_USER:
                result = a.getUser();
                break;
            case COLUMNA_TYPE:
                result = a.getType();
                break;
            default:
                result = new String("");
        }

        return result;
    }

    public String getColumnName(int col) {
        return nombresColumnas[col];
    }
    public Class getColumnClass(int col) {
        return tiposColumnas[col];
    }

    public List<Account> getContent() {
        return accountList;
    }
    public void setContent(List<Account> content) {
        this.accountList = content;
    }
}
