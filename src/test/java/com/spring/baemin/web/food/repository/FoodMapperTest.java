package com.spring.baemin.web.food.repository;

import com.spring.baemin.web.food.domain.FoodCategory;
import com.spring.baemin.web.food.domain.Restaurant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FoodMapperTest {

    @Autowired
    private FoodMapper mapper;

    @Test
    void create() {
        Restaurant restaurant = new Restaurant();
        restaurant.setRestaurantName("진짜루");
        restaurant.setNumber("010-1112-3333");
        restaurant.setMenus("ㄷㄹ허ㅜㅑㄴㅇㅍㄴ알");
        restaurant.setCategory(FoodCategory.CHINA_FOOD);

        mapper.create(restaurant);
    }

    @Test
    void remove() {
        mapper.remove(3);
    }

    @Test
    void more() {
        Restaurant restaurant;
        restaurant = mapper.more(5);
        System.out.println(restaurant);
    }

    @Test
    void rewrite() {
        Restaurant restaurant = new Restaurant();
        restaurant.setMenus("변경변경변경 블라블라블라~~~~~");
        restaurant.setRestaurantNum(5);
        mapper.rewrite(restaurant);
    }

    @Test
    void findAll() {
        List<Restaurant> resList = mapper.findAll();
        for (Restaurant restaurant : resList) {
            System.out.println(restaurant);
        }

    }
}