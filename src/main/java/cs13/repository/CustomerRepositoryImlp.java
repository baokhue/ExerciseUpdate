package repository;

import bean.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImlp implements ICustomerRepository {

    @Override
    public boolean add(Customer customer) {
        Connection connection = ConnectDb.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(UnityDB.ADD_CUSTOMER);
                statement.setInt(1, customer.getId());
                statement.setString(2, customer.getName());
                statement.executeUpdate();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                    ConnectDb.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            return true;
        }
        return false;
    }

    @Override
    public List<Customer> findAll() {
        Connection connection = ConnectDb.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Customer> customerList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(UnityDB.FIND_ALL_CUSTOMER);
                while (resultSet.next()) {
                    int id = resultSet.getInt("c_id");
                    String name = resultSet.getString("c_name");
                    customerList.add(new Customer(id, name));
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                    statement.close();
                    ConnectDb.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return customerList;
    }

    @Override
    public List<Customer> findId(int id) {
        Connection connection = ConnectDb.getConnection();
        PreparedStatement statement;
        ResultSet resultSet = null;
        Customer customer = null;
        List<Customer> list = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UnityDB.FIND_BY_ID_CUSTOMER);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int cId = resultSet.getInt("c_id");
                    String name = resultSet.getString("c_name");
                    customer = new Customer(cId, name);
                    list.add(customer);
                }

            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    resultSet.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                ConnectDb.close();
            }
        }
        return list;
    }

    @Override
    public boolean edit(Customer customer) throws SQLException {
        Connection connection = ConnectDb.getConnection();
        PreparedStatement statement;
        statement = null;
        boolean rowEdit = false;
        if (connection != null) {

            try {
                statement = connection.prepareStatement(UnityDB.EDIT_CUSTOMER);
                statement.setString(1, customer.getName());
                statement.setInt(2, customer.getId());
                rowEdit = statement.executeUpdate() > 0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                statement.close();
                ConnectDb.close();
            }
        }
        return rowEdit;
    }

    @Override
    public boolean remove(int id) {
        Connection connection = ConnectDb.getConnection();
        PreparedStatement statement = null;
        boolean rowDelete = false;

        if (connection != null) {
            try {
                statement = connection.prepareStatement(UnityDB.REMOVE_BY_ID_CUSTOMER);
                statement.setInt(1, id);
                rowDelete = statement.executeUpdate() > 0;
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    statement.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                ConnectDb.close();
            }

        }
        return rowDelete;
    }
}
