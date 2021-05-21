package com.spring.baemin.web.food.service;

import com.spring.baemin.web.common.paging.Criteria;
import com.spring.baemin.web.food.domain.Restaurant;
import com.spring.baemin.web.food.repository.FoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final FoodMapper foodMapper;

    public void create(Restaurant restaurant){
        foodMapper.create(restaurant);
    }

    public void  remove(int restaurantNum) {
        foodMapper.remove(restaurantNum);
    }

    public Restaurant more(int restaurantNum) {
        return foodMapper.more(restaurantNum);
    }

    public void  rewrite(Restaurant restaurant) {
        foodMapper.rewrite(restaurant);
    }

    public List<Restaurant> findAll(Criteria criteria){
        return foodMapper.findAll(criteria);
    }

    public int getTotal() {
        return foodMapper.getTotalCount();
    }

    public List<Restaurant> findAll() {
        return foodMapper.findAll();
    }

}
