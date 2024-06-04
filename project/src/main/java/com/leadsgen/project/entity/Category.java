package com.leadsgen.project.entity;

import com.leadsgen.project.validate.CategoryNameIsNotExist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.validator.constraints.Length;


import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.UUID;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name ="Category" )
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "`name`")
    private String name;
    @Temporal(TemporalType.TIMESTAMP)
    @CreationTimestamp
    @Column(name="create_at",updatable = false)
    private Date createAt;
}
