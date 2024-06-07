package com.leadsgen.project.dto;

import com.leadsgen.project.validate.CategoryNameIsNotExist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CreateCategoryDTO {
    @NotBlank(message = "The name mustn't be null value ")
    @Length(message = "The name length is max 50 characters",max = 50)
    @CategoryNameIsNotExist
    private String name;
}
