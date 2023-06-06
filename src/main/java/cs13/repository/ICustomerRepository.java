package repository;

import bean.Customer;
import bean.Product;

import java.sql.SQLException;
import java.util.List;

public interface ICustomerRepository {
    boolean add(Customer customer);
    List<Customer> findAll();
    List<Customer> findId(int id);

    boolean edit(Customer customer) throws SQLException;

    boolean remove(int id);
}
