package repository;

import bean.Product;

import java.util.List;

public interface IProductRepository {
    boolean add(Product product);
    List<Product> findAll();
    List<Product> findId(int id);

    boolean edit(Product product);

    boolean remove(int id);

}
