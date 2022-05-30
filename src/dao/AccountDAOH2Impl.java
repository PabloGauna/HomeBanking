package dao;

import entities.Account;
import entities.AccountType;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AccountDAOH2Impl extends DAOH2Impl<Account> implements AccountDAO {
    public String getSelectAllQuery() {
        return "SELECT * FROM account";
    }

    public String getSelectByIdQuery(int id) {
        return "SELECT * FROM account WHERE number = '" + id + "'";
    }

    public String getDeleteByIdQuery(int id) {
        return "DELETE FROM account WHERE number = '" + id + "'";
    }

    public String getInsertQuery(Account account) {
        int number = account.getNumber();
        BigDecimal balance = account.getBalance();
        AccountType type = account.getType();
        String user = account.getUser();

        return "INSERT INTO account " +
                "(number, balance, type, user) VALUES ('"
                + number + "','"
                + balance + "','"
                + type.ordinal() + "','"
                + user + "')";
    }

    public String getUpdateQuery(Account account) {
        return "UPDATE account set balance = " + account.getBalance() + ", "
                + "type = " + account.getType().ordinal() + ", "
                + "user = '" + account.getUser() + "' "
                + "WHERE number = " + account.getNumber();
    }

    public Account mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int number = resultSet.getInt("number");
        BigDecimal balance = resultSet.getBigDecimal("balance");
        String user = resultSet.getString("user");
        AccountType type = AccountType.values()[resultSet.getShort("type")];

        return new Account(number, balance, user , type );
    }
}
