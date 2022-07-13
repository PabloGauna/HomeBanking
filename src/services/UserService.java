package services;

import dao.DAOException;
import dao.DuplicatedEntryException;
import dao.user.UserDAO;
import dao.user.UserDAOH2Impl;
import entities.Account;
import entities.User;

import java.util.List;

public class UserService {
    private final UserDAO userDAO = new UserDAOH2Impl();

    public void createUser(User user) throws UserServiceException {
        try {
            userDAO.create(user);
        } catch (DAOException | DuplicatedEntryException e) {
            e.printStackTrace();
            throw new UserServiceException(e);
        }
    }

    public void updateUser(User user) throws UserServiceException {
        try {
            userDAO.update(user);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (DuplicatedEntryException e) {
            e.printStackTrace();
            throw new UserServiceException(e);
        }
    }

    public User getUserById(int id) throws UserServiceException {
        User result;
        try {
            result = userDAO.getById(id);
        } catch (DAOException e) {
            e.printStackTrace();
            throw new UserServiceException(e);
        }
        return result;
    }

    public List<User> getAllUsers() throws UserServiceException {
        List<User> result;
        try {
            result = userDAO.getAll();
        } catch (DAOException e) {
            throw new UserServiceException(e);
        }
        return result;
    }

    public void deleteUser(int id) throws UserServiceException {
        try {
            userDAO.delete(id);
        } catch (DAOException e) {
            e.printStackTrace();
        } catch (DuplicatedEntryException e) {
            e.printStackTrace();
            throw new UserServiceException(e);
        }
    }
}
