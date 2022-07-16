package com.mtugo.HMS.repository;

import com.mtugo.HMS.model.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}
