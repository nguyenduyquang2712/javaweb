package com.example.demo.service.order.impl;

import com.example.demo.model.order.OrderTable;
import com.example.demo.repository.order.IOrderRepository;
import com.example.demo.service.order.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderRepository orderRepository;

    @Override
    public OrderTable getOrder(Integer id) {
        return orderRepository.getOrder(id);
    }

    @Override
    public void addNewWatch(Integer id) {
        orderRepository.addNewWatch(id);
    }

    @Override
    public void addAmount(Integer id, Integer amount) {
        orderRepository.addAmount(id, amount);
    }

    @Override
    public List<OrderTable> getAll() {
        return orderRepository.findAll();
    }

    @Override
    public void updateOrder(Integer id, Integer amount) {
        orderRepository.updateOrder(id, amount);
    }

    @Override
    public void deleteOrder(Integer id) {
        orderRepository.deleteOrder(id);
    }

    @Override
    public void deleteAllOrder() {
        orderRepository.deleteAll();
    }


}
