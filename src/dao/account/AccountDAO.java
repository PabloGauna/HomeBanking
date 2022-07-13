package dao.account;

import dao.DAOException;
import dao.DuplicatedEntryException;
import entities.Account;
import java.util.List;

public interface AccountDAO {
    void create(Account entity) throws DAOException, DuplicatedEntryException;
    void delete(int id) throws DAOException, DuplicatedEntryException;
    void update(Account entity) throws DAOException, DuplicatedEntryException;
    Account getById(int id) throws DAOException;
    List<Account> getAll() throws DAOException;
}
