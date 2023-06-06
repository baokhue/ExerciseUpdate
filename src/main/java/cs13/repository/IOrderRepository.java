package repository;

import bean.Orders;

import java.util.List;

public interface IOrderRepository {
    boolean add(Orders orders);
    List<Orders> findAll();
    List<Orders> findId( int id);
}
