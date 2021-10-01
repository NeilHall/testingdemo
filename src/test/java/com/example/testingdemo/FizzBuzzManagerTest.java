package com.example.testingdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FizzBuzzManagerTest {

    @Mock
    FizzBuzzService fizzBuzzServiceMock;

    @Mock
    FizzBuzzHelper fizzBuzzHelperMock;

    @InjectMocks
    FizzBuzzManager subject;

    @Test
    @DisplayName("Should return String result if found in db")
    void getFizzBuzzAnswer() {
        Optional<String> opt = Optional.of("FizzBuzz");
        when(fizzBuzzServiceMock.checkForDbCacheResult(30)).thenReturn(opt);

        String result = subject.getFizzBuzzAnswer(30);
        assertThat(result, is("FizzBuzz"));
    }

    @Test
    @DisplayName("Should return String result if not found in db")
    void getFizzBuzzAnswer2(){
        when(fizzBuzzServiceMock.checkForDbCacheResult(30)).thenReturn(Optional.empty());
        when(fizzBuzzHelperMock.getResult(30)).thenReturn("FizzBuzz");

        String result = subject.getFizzBuzzAnswer(30);
        assertThat(result, is("FizzBuzz"));
    }
}