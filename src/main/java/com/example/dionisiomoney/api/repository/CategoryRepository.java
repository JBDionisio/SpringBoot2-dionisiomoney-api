package com.example.dionisiomoney.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.dionisiomoney.api.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long>{

}
