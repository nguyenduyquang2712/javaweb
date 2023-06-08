package com.example.demo.service.watch.impl;

import com.example.demo.Dto.WatchDto;
import com.example.demo.model.product.Brand;
import com.example.demo.model.product.Category;
import com.example.demo.model.product.Watch;
import com.example.demo.repository.watch.IBrandRepository;
import com.example.demo.repository.watch.ICategoryRepository;
import com.example.demo.repository.watch.IWatchRepository;
import com.example.demo.service.watch.IWatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchService implements IWatchService {
    @Autowired
    private IWatchRepository watchRepository;
    @Autowired
    private IBrandRepository brandRepository;
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Watch> getAllWatch() {
        return watchRepository.getAllWatch();
    }

    @Override
    public List<Brand> getAllBrand() {
        return brandRepository.findAll();
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Watch> getWatchById(Integer id) {
        return watchRepository.findById(id);
    }

    @Override
    public void createWatch(WatchDto watch) {
        watchRepository.createWatch(watch.getName(),watch.getDateOfManufacture(),watch.getDescription(),watch.getPrice(),watch.getStatus(),watch.getImgUrl(),watch.getCategoryId(),watch.getBrandId());
    }

    @Override
    public void updateWatch(WatchDto watch) {
        watchRepository.updateWatch(watch.getId(),watch.getName(),watch.getDateOfManufacture(),watch.getDescription(),watch.getPrice(),watch.getStatus(),watch.getImgUrl(),watch.getCategoryId(),watch.getBrandId());
    }

    @Override
    public void deleteWatchById(Integer id) {
        watchRepository.deleteWatchById(id);
    }

    @Override
    public List<Watch> getSearchWatches(String searchName) {
        return watchRepository.getSearchWatches(searchName);
    }

    @Override
    public List<Watch> getSearchWatchesByBrand(Integer brandId) {
        return watchRepository.getSearchWatchesByBrand(brandId);
    }


}
