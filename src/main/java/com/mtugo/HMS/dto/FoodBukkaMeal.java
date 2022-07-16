package com.mtugo.HMS.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Data
public class FoodBukkaMeal {

    private List<String> images;

    @JsonProperty("_id")
    private String id;

    private String description;

    @JsonProperty("menuname")
    private String menuName;

    @JsonProperty("__v")
    private String v;
}
