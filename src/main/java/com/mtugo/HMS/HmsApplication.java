package com.mtugo.HMS;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mtugo.HMS.dto.FoodBukkaMeal;
import com.mtugo.HMS.dto.FoodBukkaResult;
import com.mtugo.HMS.model.Meal;
import com.mtugo.HMS.repository.MealRepository;
import lombok.extern.slf4j.Slf4j;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.ResponseBody;
import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@Slf4j
public class HmsApplication {

//	private final MealRepository mealRepository;
//
//	public HmsApplication(MealRepository mealRepository) {
//		this.mealRepository = mealRepository;
//	}

	public static void main(String[] args) {
		SpringApplication.run(HmsApplication.class, args);
	}


//	@Bean
//	public void fetchMeals() throws IOException, JSONException {
//
//
//		OkHttpClient client = new OkHttpClient();
//
//		Request request = new Request.Builder()
//				.url("https://foodbukka.herokuapp.com/api/v1/menu")
//				.get()
//
//				.build();
//
//		ResponseBody response = client.newCall(request).execute().body();
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		FoodBukkaResult entity = objectMapper.readValue(response.string(), FoodBukkaResult.class);
//
//		List<Meal> meals = new ArrayList<>();
//
//		for (FoodBukkaMeal apiMeal: entity.getMeals()){
//			log.info(String.valueOf(apiMeal));
//
//			Meal mealInstance = Meal.builder()
//					.mealPrice(1)
//					.mealName(apiMeal.getMenuName())
//					.mealImage(apiMeal.getImages().get(0))
//					.build();
//
//			meals.add(mealInstance);
//		}
//
//		mealRepository.saveAll(meals);
//
//
//
//
//	}

}
