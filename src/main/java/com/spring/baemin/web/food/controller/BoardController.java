package com.spring.baemin.web.food.controller;

import com.spring.baemin.web.food.service.BoardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Log4j2
@RequiredArgsConstructor
@RequestMapping("")
public class BoardController {

    private final BoardService boardService ;

}
