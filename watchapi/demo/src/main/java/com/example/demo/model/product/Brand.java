package com.example.demo.model.product;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String tag;
    private String origin;
    @JsonBackReference
    @OneToMany(mappedBy = "brand")
    private Set<Watch> watches;
    @Column(columnDefinition = "int default 0")
    private Integer deleteStatus;
    public Brand() {
    }

    public Brand(Integer id, String tag, String origin, String imgUrl, Integer deleteStatus, Set<Watch> watches) {
        this.id = id;
        this.tag = tag;
        this.origin = origin;
        this.deleteStatus = deleteStatus;
        this.watches = watches;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
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
