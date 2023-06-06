package repository;

import bean.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductRepositoryImlp implements IProductRepository {
    @Override
    public boolean add(Product product) {
        Connection connection = ConnectDb.getConnection();
        PreparedStatement statement = null;

        if (connection != null) {

            try {
                statement = connection.prepareStatement(UnityDB.ADD_PRODUCT);
                statement.setInt(1, product.getId());
                statement.setString(2, product.getName());
                statement.setDouble(3, product.getPrice());
                statement.setInt(4, product.getAmount());
                statement.executeUpdate();
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
            return true;

        }

        return false;
    }

    @Override
    public List<Product> findAll() {

        Connection connection = ConnectDb.getConnection();
        Statement statement = null;
        ResultSet resultSet = null;
        List<Product> productList = new ArrayList<>();
        if (connection != null) {
            try {
                statement = connection.createStatement();
                resultSet = statement.executeQuery(UnityDB.FIND_ALL_PRODUCT);
                Product product = null;
                while (resultSet.next()) {
                    int id = resultSet.getInt("p_id");
                    String name = resultSet.getString("p_ame");
                    Double price = resultSet.getDouble("p_rice");
                    int amount = resultSet.getInt("p_amount");

                    product = new Product(id, name, price, amount);

                    productList.add(product);
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
        return productList;
    }

    @Override
    public List<Product> findId(int id) {
        Connection connection = ConnectDb.getConnection();
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Product product = null;
        List<Product> list = new ArrayList<>();

        if (connection != null) {

            try {
                statement = connection.prepareStatement(UnityDB.FIND_BY_ID_PRODUCT);
                statement.setInt(1, id);
                resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    int idd = resultSet.getInt("p_id");
                    String name = resultSet.getString("p_ame");
                    Double price = null;
                    price = resultSet.getDouble("p_rice");
                    int amount = resultSet.getInt("p_amount");
                    product = new Product(idd, name, price, amount);
                    list.add(product);
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
    public boolean edit(Product product) {
        Connection connection = ConnectDb.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {

            try {
                statement = connection.prepareStatement(UnityDB.EDIT_PRODUCT);
                statement.setString(1, product.getName());
                statement.setDouble(2, product.getPrice());
                statement.setInt(3, product.getAmount());
                statement.setInt(4, product.getId());
                statement.executeUpdate();
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
            return true;
        }

        return false;
    }

    @Override
    public boolean remove(int id) {
        Connection connection = ConnectDb.getConnection();
        PreparedStatement statement = null;
        if (connection != null) {
            try {
                statement = connection.prepareStatement(UnityDB.DELETE_PRODUCT);
                statement.setInt(1,id);
                statement.executeUpdate();
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
            return true;
        }

        return false;
    }
}
