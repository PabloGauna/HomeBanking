package dao;

import entities.Account;
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
        float balance = account.getBalance();
        return "INSERT INTO account (number, balance) VALUES ('" + number + "','" + balance + "')";
    }

    public String getUpdateQuery(Account account) {
        return "UPDATE account set number = '" + account.getNumber() + "WHERE number = '" + account.getNumber() + "'";
    }

    public Account mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int number = resultSet.getInt("number");
        return new Account(number, 0.0f);
    }
}
