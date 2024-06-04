package com.leadsgen.project.repository;

import com.leadsgen.project.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
        boolean existsByName(String name);
        void deleteById(long id);

        boolean existsById(long id);
}
