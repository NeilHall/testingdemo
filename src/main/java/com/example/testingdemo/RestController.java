package com.example.testingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("fizzbuzz")
public class RestController {
    @Autowired FizzBuzzManager fizzBuzzManager;

    @GetMapping(value = "/{id}", produces = "application/json")
    public @ResponseBody String getAnswer(@PathVariable int id) {

        String result = fizzBuzzManager.getFizzBuzzAnswer(id);

        return result;
    }
}
