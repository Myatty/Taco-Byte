package com.taco.taco_cloud.repositories;

import com.taco.taco_cloud.models.Ingredient;
import org.springframework.stereotype.Repository;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.List;


@Repository
public class JdbcIngredientTemplate implements IngredientRepository{

    private JdbcTemplate jdbcTemplate;

    public JdbcIngredientTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Iterable<Ingredient> findAll(){
        return jdbcTemplate.query(
                "SELECT id, name, type FROM Ingredient",
                this::mapRowToIngredient
        );
    }

    @Override
    public Optional<Ingredient> findById(String id){

        List<Ingredient> results = jdbcTemplate.query(
                "SELECT id, name, type FROM Ingredient WHERE id = ?",
                this::mapRowToIngredient,
                id
        );

        return results.size() == 0 ? Optional.empty() : Optional.of(results.get(0));

    }

    @Override
    public Ingredient save(Ingredient ingredient){
        jdbcTemplate.update(
                "INSERT INTO Ingredient (id, name, type) VALUES (?,?,?,?) ",
                ingredient.getId(),
                ingredient.getName(),
                ingredient.getType().toString()
        );

        return ingredient;
    }

    private Ingredient mapRowToIngredient(ResultSet row, int rowNum) throws SQLException {

        return new Ingredient(
                row.getString("id"),
                row.getString("name"),
                Ingredient.Type.valueOf(row.getString("type"))
        );
    }
}
