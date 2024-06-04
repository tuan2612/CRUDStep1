package com.leadsgen.project.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class CategoryDTO {
    private String name;
    @JsonFormat(pattern = "HH:mm:ss dd-MM-yyyy")
    private Date createAt;
}
