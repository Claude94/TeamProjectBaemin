package com.spring.baemin.web.food.controller;

import com.spring.baemin.web.food.domain.Restaurant;
import com.spring.baemin.web.food.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@Log4j2
//@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService ;
    @Autowired
    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }

    @GetMapping("/list")
    public String boardList() {
        List<Restaurant> resList = boardService.findAll();
        System.out.println(resList);
        return "board-list";
    }


}
