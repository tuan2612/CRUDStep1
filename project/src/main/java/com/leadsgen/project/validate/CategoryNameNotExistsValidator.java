package com.leadsgen.project.validate;

import com.leadsgen.project.service.CategoryService;

import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryNameNotExistsValidator implements ConstraintValidator<CategoryNameIsNotExist,String> {
    @Autowired
    private CategoryService categoryService;

    @Override
    public boolean isValid(String name, ConstraintValidatorContext constraintValidatorContext) {
        return !categoryService.isExistByName(name);
    }
}
