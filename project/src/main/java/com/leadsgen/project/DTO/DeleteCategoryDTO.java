package com.leadsgen.project.dto;

import com.leadsgen.project.validate.CategoryIdIsNotExist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeleteCategoryDTO {
    @NotBlank(message = "ID không được để trống")
    @CategoryIdIsNotExist
    private long id;
}
