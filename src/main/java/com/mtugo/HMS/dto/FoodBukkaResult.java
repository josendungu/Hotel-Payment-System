package com.mtugo.HMS.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
public class FoodBukkaResult {

    @JsonProperty("Total Menu")
    private int totalMenu;

    @JsonProperty("Result")
    private List<FoodBukkaMeal> meals;


}
