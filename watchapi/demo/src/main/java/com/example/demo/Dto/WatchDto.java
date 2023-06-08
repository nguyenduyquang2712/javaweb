package com.example.demo.Dto;

public class WatchDto {
    private Integer id;
    private String name;
    private Double price;
    private String description;
    private String dateOfManufacture;
    private String status;
    private String imgUrl;
    private Integer brandId;
    private Integer categoryId;

    public WatchDto() {
    }

    public WatchDto(Integer id, String name, Double price, String description, String dateOfManufacture, String status, String imgUrl, Integer brandId, Integer categoryId) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.description = description;
        this.dateOfManufacture = dateOfManufacture;
        this.status = status;
        this.imgUrl = imgUrl;
        this.brandId = brandId;
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

//    public Integer getBrandId() {
//        return brand;
//    }
//
//    public void setBrandId(Integer brandId) {
//        this.brand = brandId;
//    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDateOfManufacture() {
        return dateOfManufacture;
    }

    public void setDateOfManufacture(String dateOfManufacture) {
        this.dateOfManufacture = dateOfManufacture;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }
//
//    public Integer getCategoryId() {
//        return category;
//    }
//
//    public void setCategoryId(Integer categoryId) {
//        this.category = categoryId;
//    }
}
