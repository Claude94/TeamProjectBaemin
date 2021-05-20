package com.spring.baemin.web.food.repository;

import com.spring.baemin.web.food.domain.FoodCategory;
import com.spring.baemin.web.food.domain.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FoodMapperTest {

    @Autowired
    private FoodMapper mapper;

    @Test
    void create() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName("김밥나라");
        restaurant.setNumber("010-2421-9850");
        restaurant.setMenus("fkaus, rrrrr,s sdasdasd");
        restaurant.setCategory(FoodCategory.KOREAN_FOOD);

        mapper.create(restaurant);
    }

    @Test
    void remove() {
    }

    @Test
    void more() {
    }

    @Test
    void rewrite() {
    }

    @Test
    void findAll() {
    }
}