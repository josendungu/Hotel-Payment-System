package com.mtugo.HMS.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "Meals")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Meal {

    @Id
    @SequenceGenerator(
            sequenceName = "meal_sequence",
            allocationSize = 1,
            name = "meal_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "meal_sequence"
    )
    private Long mealId;

    @Column(
            nullable = false,
            columnDefinition = "TEXT"
    )
    private String mealName;

    @Column(nullable = false)
    private int mealPrice;

    @Column(nullable = false)
    private String mealImage;

}
