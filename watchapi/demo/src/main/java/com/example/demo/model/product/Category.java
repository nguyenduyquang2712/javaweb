package com.example.demo.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String type;
    @JsonBackReference
    @OneToMany(mappedBy = "category")
    private Set<Watch> watches;
    @Column(columnDefinition = "int default 0")
    private Integer deleteStatus;

    public Category() {
    }

    public Category(Integer id, String type, Integer deleteStatus, Set<Watch> watches) {
        this.id = id;
        this.type = type;
        this.deleteStatus = deleteStatus;
        this.watches = watches;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getDeleteStatus() {
        return deleteStatus;
    }

    public void setDeleteStatus(Integer deleteStatus) {
        this.deleteStatus = deleteStatus;
    }

    public Set<Watch> getWatches() {
        return watches;
    }

    public void setWatches(Set<Watch> watches) {
        this.watches = watches;
    }
}
