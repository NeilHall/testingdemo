package com.example.testingdemo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class FizzBuzzServiceTest {

    @Mock
    FizzBuzzRepository fizzBuzzRepositoryMock;

    @InjectMocks
    FizzBuzzService subject;

    @Captor
    ArgumentCaptor<FizzBuzzEntity> fizzBuzzEntityCaptor;

    @Test
    void saveToDbCache() {
        subject.saveToDbCache(10, "Buzz");
        verify(fizzBuzzRepositoryMock, times(1)).save(fizzBuzzEntityCaptor.capture());
        FizzBuzzEntity actualFizzBuzzEntity = fizzBuzzEntityCaptor.getValue();
        assertThat(actualFizzBuzzEntity.getId(), is(10));
        assertThat(actualFizzBuzzEntity.getResult(), is("Buzz"));

    }

    @Test
    @DisplayName("Result String should be returned if value found in database")
    void checkForDbCacheResult() {
        FizzBuzzEntity fizzBuzzEntity = new FizzBuzzEntity();
        fizzBuzzEntity.setId(11);
        fizzBuzzEntity.setResult("11");
        Optional<FizzBuzzEntity> opt = Optional.of(fizzBuzzEntity);

        when(fizzBuzzRepositoryMock.findById(11)).thenReturn(opt);

        Optional<String> result = subject.checkForDbCacheResult(11);
        assertTrue(result.isPresent());
        assertThat(result.get(), is("11"));
    }

    @Test
    @DisplayName("Empty optional if value not found in database")
    void checkForDbCacheResult2(){
        Optional<String> result = subject.checkForDbCacheResult(12);
        assertTrue(!result.isPresent());
    }

}