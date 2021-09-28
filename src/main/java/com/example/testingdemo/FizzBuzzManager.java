package com.example.testingdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class FizzBuzzManager {
    @Autowired
    FizzBuzzService fizzBuzzService;

    @Autowired
    FizzBuzzHelper fizzBuzzHelper;

    public String getFizzBuzzAnswer(int number) {
        Optional<String> dbResult = fizzBuzzService.checkForDbCacheResult(number);

        if (dbResult.isPresent()) {
            return dbResult.get();
        }

        String result = fizzBuzzHelper.getResult(number);
        fizzBuzzService.saveToDbCache(number, result);

        return result;
    }
}
