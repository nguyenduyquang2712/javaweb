package com.example.demo.service.watch;

import com.example.demo.Dto.WatchDto;
import com.example.demo.model.product.Brand;
import com.example.demo.model.product.Category;
import com.example.demo.model.product.Watch;

import java.util.List;
import java.util.Optional;

public interface IWatchService {
    List<Watch> getAllWatch();

    List<Brand> getAllBrand();

    List<Category> getAllCategory();

    Optional<Watch> getWatchById(Integer id);

    void createWatch(WatchDto watch);

    void updateWatch( WatchDto watch);

    void deleteWatchById(Integer id);

    List<Watch> getSearchWatches(String searchName);

    List<Watch> getSearchWatchesByBrand(Integer brandId);
}
