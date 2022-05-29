package dao;

import entities.Account;
import java.util.List;

public interface AccountDAO {
    void create(Account entity) throws DAOException, DuplicatedKeyException ;
    void delete(int id) throws DAOException, DuplicatedKeyException ;
    void update(Account entity) throws DAOException, DuplicatedKeyException ;
    Account getById(int id) throws DAOException;
    List<Account> getAll() throws DAOException;
}
