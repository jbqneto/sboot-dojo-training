package com.jbqneto.dojo.training.application.representation;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IngredientRepresentation {

    private long id;
    private String name;
    private String detail;
    private Double quantity;
    private String unity;
}
