package com.leadsgen.project.controller;


import com.leadsgen.project.DTO.CategoryDTO;
import com.leadsgen.project.DTO.CreateCategoryDTO;
import com.leadsgen.project.DTO.DeleteCategoryDTO;
import com.leadsgen.project.DTO.UpdateCategoryDTO;
import com.leadsgen.project.entity.Category;
import com.leadsgen.project.messenger.Response;
import com.leadsgen.project.service.CategoryService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
@Validated
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private ModelMapper modelMapper;

    @GetMapping("getAll")
    public Page<CategoryDTO> getAllCategory(@PageableDefault(page = 0, size = 5) Pageable pageable) {
        Page<Category> dto = categoryService.getAllCategory(pageable);
        List<CategoryDTO> dtos = modelMapper.map(dto.getContent(), new TypeToken<List<CategoryDTO>>() {
        }.getType());
        Page<CategoryDTO> dtoPages = new PageImpl<>(dtos, pageable, dto.getTotalElements());
        return dtoPages;
    }

    @PostMapping("create")
    public ResponseEntity<?> createCategory(@RequestBody @Valid CreateCategoryDTO form) {
        Category category = modelMapper.map(form, Category.class);
        try {
            categoryService.createCategory(category);
            Response response = new Response(HttpStatus.CREATED, "created", "created");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception exception) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "create fail! ", exception.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

    @PutMapping("update")
    public ResponseEntity<?> updateCategory( @RequestBody UpdateCategoryDTO form) {
        Category category = modelMapper.map(form, Category.class);
        try {
            categoryService.updateCategory(category);
            Response response = new Response(HttpStatus.OK, "updated", "updated");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception exception) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "update Fail!", exception.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("delete")
    public ResponseEntity<?> deleteCategory(DeleteCategoryDTO form ) {
        Category category = modelMapper.map(form, Category.class);
        try {
            categoryService.deleteCategory(category.getId());
            Response response = new Response(HttpStatus.OK, "deleted", "deleted");
            return new ResponseEntity<>(response, HttpStatus.OK);
        } catch (Exception exception) {
            Response response = new Response(HttpStatus.BAD_REQUEST, "delete Fail!", exception.getMessage());
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);

        }
    }
}
