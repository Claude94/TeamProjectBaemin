package com.spring.baemin.web.food.domain;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter @Getter
@ToString
public class Restaurant {

    private static int sequence;

    private int restaurantNum;
    private String restaurantName;
    private String number;
    private String menus;
    private FoodCategory category;

    public Restaurant() {
        this.restaurantNum = ++sequence;
    }

    public Restaurant(String restaurantName, String number, String menus, FoodCategory category) {
        this.restaurantName = restaurantName;
        this.number = number;
        this.menus = menus;
        this.category = category;
    }
}
