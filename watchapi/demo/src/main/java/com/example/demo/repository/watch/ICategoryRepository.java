package com.example.demo.repository.watch;

import com.example.demo.model.product.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category,Integer> {
}
