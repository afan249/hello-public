package com.friend.spider.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * fyc
 */

@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("")
    public String home(){
        return "探活!!!";
    }

}

