package com.spring.baemin.web.food.controller;

import com.spring.baemin.web.common.paging.Criteria;
import com.spring.baemin.web.common.paging.pageMaker;
import com.spring.baemin.web.food.domain.ModifyRestaurant;
import com.spring.baemin.web.food.domain.Restaurant;
import com.spring.baemin.web.food.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@Log4j2
//@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String boardList(Criteria criteria, Model model) {
        List<Restaurant> resList = boardService.findAll(criteria);
//        for (Restaurant restaurant : resList) {
//            System.out.println(restaurant.getCategory().getFoodName());
//        }
        model.addAttribute("list", resList);
        model.addAttribute("pageMaker", new pageMaker(criteria, boardService.getTotal()));
        return "/board/list";
    }

    //매점 등록 화면 요청
    @GetMapping("/write")
    public String write() {
        return "/board/write";
    }

    //매점 등록 처리 요청
    @PostMapping("/write")
    public String write(Restaurant restaurant) {
        try {
            boardService.create(restaurant);
            return "redirect:/board/list";
        } catch (Exception e) {
            return "redirect:/board/write";
        }
    }

    //입점 매점 목록 요청
    /*@GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("list", boardService.findAll());
        return "list";
    }*/

    //등록 매점 삭제 요청
    @GetMapping("/delete")
    public String delete(int restaurantNum) {
        boardService.remove(restaurantNum);
        return "redirect:/board/list";
    }

    //매점 정보 상세보기 요청
    @GetMapping("/content")
    public String content(int restaurantNum, Model model) {
        Restaurant content = boardService.more(restaurantNum);
        model.addAttribute("restaurant", content);
        return "/board/content";
    }

    //매점 정보 수정하기 화면요청
    @GetMapping("/modify")
    public String modify(int restaurantNum, Model model) {
        model.addAttribute("restaurant", boardService.more(restaurantNum));
        return "/board/modify";
    }

    //매점 정보 수정 처리요청
    @PostMapping("/modify")
    public String modify(ModifyRestaurant modRestaurant) {

        // 원본데이터를 찾아서 수정데이터로 변경하는 로직(서비스에 넣어주는게 좋다)
        Restaurant restaurant = boardService.more(modRestaurant.getRestaurantNum());
        restaurant.setRestaurantName(modRestaurant.getRestaurantName());
        restaurant.setNumber(modRestaurant.getNumber());
        restaurant.setMenus(modRestaurant.getMenus());
        restaurant.setCategory(modRestaurant.getCategory());
        try {
            boardService.rewrite(restaurant);
            return "redirect:/board/content?restaurantNum=" + modRestaurant.getRestaurantNum();
        } catch (Exception e) {
            return "redirect:/board/modify?restaurantNum=" + modRestaurant.getRestaurantNum();
        }
    }
}
