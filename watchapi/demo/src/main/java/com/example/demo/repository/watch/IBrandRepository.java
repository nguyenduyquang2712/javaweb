package com.example.demo.repository.watch;

import com.example.demo.model.product.Brand;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBrandRepository extends JpaRepository<Brand, Integer> {
}
