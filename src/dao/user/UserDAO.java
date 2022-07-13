package dao.user;

import dao.DAOException;
import dao.DuplicatedEntryException;
import entities.User;
import java.util.List;

public interface UserDAO {
    void create(User entity) throws DAOException, DuplicatedEntryException;
    void delete(int id) throws DAOException, DuplicatedEntryException;
    void update(User entity) throws DAOException, DuplicatedEntryException;
    User getById(int id) throws DAOException;
    List<User> getAll() throws DAOException;
}
