package com.example.ted.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ModelMapperConfiguration {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }


}
