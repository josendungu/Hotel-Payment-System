package com.mtugo.HMS.service;

import com.mtugo.HMS.model.Meal;
import com.mtugo.HMS.repository.MealRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MealServiceImpl implements MealService {

    private final MealRepository mealRepository;

    public MealServiceImpl(MealRepository mealRepository) {
        this.mealRepository = mealRepository;
    }

    @Override
    public List<Meal> fetchAllMeals() {
        return mealRepository.findAll();
    }



}
