package com.example.demo.service.order;

import com.example.demo.model.order.OrderTable;

import java.util.List;

public interface IOrderService {
    OrderTable getOrder(Integer id);

    void addNewWatch(Integer id);

    void addAmount(Integer id, Integer amount);

    List<OrderTable> getAll();

    void updateOrder(Integer id, Integer amount);

    void deleteOrder(Integer id);

    void deleteAllOrder();
}
