package com.spring.baemin.web.food.service;

import com.spring.baemin.web.common.paging.Criteria;
import com.spring.baemin.web.food.domain.Restaurant;
import com.spring.baemin.web.food.repository.FoodMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final FoodMapper foodMapper;

    public void create(Restaurant restaurant) throws Exception {
        foodMapper.create(restaurant);
    };

    public void remove(int restaurantNum){
        foodMapper.remove(restaurantNum);
    }

    public Restaurant more(int restaurantNum){

            return foodMapper.more(restaurantNum);

    }

    public void rewrite(Restaurant restaurant){
        foodMapper.rewrite(restaurant);
    }

//    public List<Restaurant> findAll() {
//        return foodMapper.findAll();
//    }

    public List<Restaurant> findAll(Criteria criteria) throws Exception {
        return foodMapper.findAll(criteria);
    }

    public int getTotal() {
        return foodMapper.getTotalCount();
    }
}
