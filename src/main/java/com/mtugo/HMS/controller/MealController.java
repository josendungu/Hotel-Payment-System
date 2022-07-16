package com.mtugo.HMS.controller;

import com.mtugo.HMS.model.Meal;
import com.mtugo.HMS.service.MealServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/meals")
@CrossOrigin(origins = "*")
public class MealController {

    private final MealServiceImpl mealService;

    public MealController(MealServiceImpl mealService) {
        this.mealService = mealService;
    }

    @GetMapping
    public ResponseEntity<List<Meal>> fetchAllMeals() {
        return ResponseEntity.ok(mealService.fetchAllMeals());
    }

}
