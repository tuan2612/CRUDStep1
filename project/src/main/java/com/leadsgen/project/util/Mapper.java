package com.leadsgen.project.util;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class Mapper {
    @Bean
    public static ModelMapper init(){
        return new ModelMapper();
    }
}
