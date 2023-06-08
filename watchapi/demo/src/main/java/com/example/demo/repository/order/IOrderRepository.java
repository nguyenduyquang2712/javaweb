package com.example.demo.repository.order;

import com.example.demo.model.order.OrderTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface IOrderRepository extends JpaRepository<OrderTable, Integer> {
    @Query(value="select * from order_table where watch_id=:id",nativeQuery=true)
    OrderTable getOrder(@Param("id") Integer id);
    
    @Modifying
    @Query(value="insert into order_table (amount,watch_id) values(1,:id)",nativeQuery=true)
    void addNewWatch(@Param("id") Integer id);


    @Modifying
    @Query(value="update order_table set amount=:amount where watch_id=:id", nativeQuery=true)
    void addAmount(Integer id, Integer amount);

    @Modifying
    @Query(value="update order_table set amount=:amount where id=:id",nativeQuery=true)
    void updateOrder(@Param("id") Integer id,
                     @Param("amount") Integer amount);

    @Modifying
    @Query(value="delete from order_table where id=:id", nativeQuery=true)
    void deleteOrder(@Param("id") Integer id);
}
