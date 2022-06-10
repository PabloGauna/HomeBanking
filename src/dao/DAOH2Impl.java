package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public abstract class DAOH2Impl<T> {

    public abstract String getSelectAllQuery();
    public abstract String getSelectByIdQuery(int id);
    public abstract String getDeleteByIdQuery(int id);
    public abstract String getInsertQuery(T entity);
    public abstract String getUpdateQuery(T entity);
    public abstract T mapResultSetToEntity(ResultSet resultSet) throws SQLException;

    private void executeUpdate(String query) throws DuplicatedEntryException, DAOException {
        Connection c = DBManager.connect();

        try {
            Statement s = c.createStatement();
            s.executeUpdate(query);
            c.commit();
        } catch (SQLException e) {
            try {
                c.rollback();
                e.printStackTrace();
            } catch (SQLException e1) {
                throw new DAOException(e1);
            }

            if (e.getErrorCode() == 23505) {
                throw new DuplicatedEntryException(e);
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    private List<T> executeQuery(String query) throws DAOException {
        List<T> result = new ArrayList<>();

        Connection c = DBManager.connect();
        try {
            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                T entity = mapResultSetToEntity(rs);
                result.add(entity);
            }
        } catch (SQLException e) {
            try {
                c.rollback();
            } catch (SQLException e1) {
                throw new DAOException(e1);
            }
        } finally {
            try {
                c.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return result;
    }

    public void create(T entity) throws DAOException, DuplicatedEntryException {
        String sql = getInsertQuery(entity);
        executeUpdate(sql);
    }

    public void delete(int id) throws DAOException, DuplicatedEntryException {
        String sql = getDeleteByIdQuery(id);
        executeUpdate(sql);
    }

    public void update(T entity) throws DAOException, DuplicatedEntryException {
        String sql = getUpdateQuery(entity);
        executeUpdate(sql);
    }

    public List<T> getAll() throws DAOException {
        String sql = getSelectAllQuery();
        List<T> result = executeQuery(sql);

        return result;
    }

    public T getById(int id) throws DAOException {
        String sql = getSelectByIdQuery(id);
        List<T> result = executeQuery(sql);

        return result.get(0);

    }
}
