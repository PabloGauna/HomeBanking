package dao.user;

import dao.DAOH2Impl;
import entities.User;
import entities.types.UserType;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDAOH2Impl extends DAOH2Impl<User> implements UserDAO {
    public String getSelectAllQuery() {
        return "SELECT * FROM user";
    }

    public String getSelectByIdQuery(int id) {
        return "SELECT * FROM user WHERE id = '" + id + "'";
    }

    public String getDeleteByIdQuery(int id) {
        return "DELETE FROM user WHERE id = '" + id + "'";
    }

    public String getInsertQuery(User user) {
        int id = user.getId();
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        UserType type = user.getType();

        return "INSERT INTO account " +
                "(id, firstName, lastName, type) VALUES ('"
                + id + "','"
                + firstName + "','"
                + lastName + "','"
                + type.ordinal() + "')";
    }

    public String getUpdateQuery(User user) {
        return "UPDATE account set firstName = " + user.getFirstName() + ", "
                + "lastName = " + user.getLastName() + ", "
                + "type = '" + user.getType().ordinal() + "' "
                + "WHERE id = " + user.getId();
    }

    public User mapResultSetToEntity(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String firstName = resultSet.getString("firstName");
        String lastName = resultSet.getString("lastName");
        UserType type = UserType.values()[resultSet.getShort("type")];

        return new User(id, firstName, lastName , type );
    }
}
