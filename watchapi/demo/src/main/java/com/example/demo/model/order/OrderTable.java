package com.example.demo.model.order;

import com.example.demo.model.product.Watch;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
public class OrderTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer amount;
    @JsonManagedReference
    @OneToOne
    @JoinColumn(name = "watch_id", referencedColumnName = "id")
    private Watch watch;

    public OrderTable() {
    }

    public OrderTable(Integer id, Integer amount, Watch watch) {
        this.id = id;
        this.amount = amount;
        this.watch = watch;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Watch getWatch() {
        return watch;
    }

    public void setWatch(Watch watch) {
        this.watch = watch;
    }
}
