package com.taco.taco_cloud.web;

import com.taco.taco_cloud.repositories.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.core.convert.converter.Converter;
import com.taco.taco_cloud.models.Ingredient;
import com.taco.taco_cloud.models.Ingredient.Type;


import java.util.HashMap;
import java.util.Map;

@Component
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private IngredientRepository ingredientRepository;

    @Autowired
    public IngredientByIdConverter(IngredientRepository ingredientRepository) {
        this.ingredientRepository = ingredientRepository;
    }

    @Override
    public Ingredient convert(String id){
        return ingredientRepository.findById(id).orElse(null);
    }
}