package com.example.testingdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzHelperTest {

    @Test
    @DisplayName("Check FizzBuzz is returned when divisible by 15")
    void test1() {
        FizzBuzzHelper fizzBuzzHelper = new FizzBuzzHelper();
        String result = fizzBuzzHelper.getResult(30);

        assertThat(result, is("FizzBuzz"));
    }

    @Test
    @DisplayName("Check Fizz is returned when divisible by 3")
    void test2() {
        FizzBuzzHelper fizzBuzzHelper = new FizzBuzzHelper();
        String result = fizzBuzzHelper.getResult(9);

        assertThat(result, is("Fizz"));
    }

//    @Test
    @DisplayName("Check Buzz is returned when divisible by 5")
    void test3() {
        FizzBuzzHelper fizzBuzzHelper = new FizzBuzzHelper();
        String result = fizzBuzzHelper.getResult(10);

        assertThat(result, is("Buzz"));
    }

    @Test
    @DisplayName("Check the original number is returned when not divisible")
    void test4() {
        FizzBuzzHelper fizzBuzzHelper = new FizzBuzzHelper();
        String result = fizzBuzzHelper.getResult(44);

        assertThat(result, is("44"));
    }

}
