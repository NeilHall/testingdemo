package com.example.testingdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RestControllerTest {

    @Mock
    FizzBuzzManager fizzBuzzManagerMock;

    @InjectMocks
    RestController subject;

    @Test
    @DisplayName("Should return String result")
    void getAnswer() {
        when(fizzBuzzManagerMock.getFizzBuzzAnswer(10)).thenReturn("Fizz");
        String result = subject.getAnswer(10);
        assertThat(result, is("Fizz"));
    }
}