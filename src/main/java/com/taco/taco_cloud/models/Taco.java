package com.taco.taco_cloud.models;

import lombok.Data;

import java.util.List;

@Data
public class Taco {

    private String name;

    private List<Ingredients> ingredients;
}
