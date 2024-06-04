package com.leadsgen.project.service;

import com.leadsgen.project.entity.Category;
import com.leadsgen.project.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public boolean isExistByName(String name) {
        return categoryRepository.existsByName(name);
    }

    @Override
    public Page<Category> getAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public void createCategory(Category form) {
        categoryRepository.save(form);
    }

    @Override
    public void updateCategory(Category form) {
        categoryRepository.save(form);
    }

    @Override
    @Transactional
    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    @Override
    public boolean isExistById(long id) {
        return categoryRepository.existsById(id);
    }


}
