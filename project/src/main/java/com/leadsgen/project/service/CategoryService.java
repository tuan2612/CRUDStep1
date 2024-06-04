package com.leadsgen.project.service;

import com.leadsgen.project.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface CategoryService {
    boolean isExistByName(String name);

    Page<Category> getAllCategory(Pageable pageable);
    void createCategory(Category form);
    void updateCategory(Category form);

    void deleteCategory(long id);
    boolean isExistById(long id);
}
