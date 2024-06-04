package com.leadsgen.project.validate;

import com.leadsgen.project.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CategoryIdNotExistsValidator implements ConstraintValidator<CategoryIdIsNotExist,Long> {
    @Autowired
    private CategoryService categoryService;
    @Override
    public boolean isValid(Long id, ConstraintValidatorContext constraintValidatorContext) {
        return categoryService.isExistById(id);
    }
}
