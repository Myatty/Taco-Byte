package com.taco.taco_cloud.repositories;

import com.taco.taco_cloud.models.Ingredient;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {

}
