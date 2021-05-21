package com.spring.baemin.web.food.repository;

import com.spring.baemin.web.common.paging.Criteria;
import com.spring.baemin.web.food.domain.Restaurant;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FoodMapper {

    void create(Restaurant restaurant);

    void remove(int restaurantNum);

    Restaurant more(int restaurantNum);

    void rewrite(Restaurant restaurant);

    List<Restaurant> findAll();

    List<Restaurant> findAll(Criteria criteria);

    int getTotalCount();

}
