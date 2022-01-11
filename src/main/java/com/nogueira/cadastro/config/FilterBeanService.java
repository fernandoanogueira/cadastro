package com.nogueira.cadastro.config;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;

@Service
public class FilterBeanService {

    public static Object mapearRetornoConformeParametros(String[] campos, String filtro, Object objeto) {
    	SimpleFilterProvider filterProvider = new SimpleFilterProvider();
    	
        filterProvider.addFilter(filtro, SimpleBeanPropertyFilter.filterOutAllExcept(campos));

        ObjectMapper objectMapper = new ObjectMapper();
        
        objectMapper.setFilterProvider(filterProvider);
        
        return objectMapper.convertValue(objeto, objeto.getClass());
    }
}