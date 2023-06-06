package repository;

import bean.Orders;

import java.util.List;

public class OrderRepositoryImlp implements IOrderRepository{
    @Override
    public boolean add(Orders orders) {
        return false;
    }

    @Override
    public List<Orders> findAll() {
        return null;
    }

    @Override
    public List<Orders> findId(int id) {
        return null;
    }
}
