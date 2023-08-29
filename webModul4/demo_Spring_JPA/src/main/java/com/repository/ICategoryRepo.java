package com.repository;

import com.model.Category;
import org.springframework.data.repository.CrudRepository;

public interface ICategoryRepo extends CrudRepository<Category, Integer> {
}
