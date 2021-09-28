package com.example.testingdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FizzBuzzService {

    @Autowired
    FizzBuzzRepository fizzBuzzRepository;

    public Optional<String> checkForDbCacheResult(int number) {
        Optional<FizzBuzzEntity> existingDbEntry = fizzBuzzRepository.findById(number);
        if(existingDbEntry.isPresent()) {
            return Optional.of(existingDbEntry.get().getResult());
        }
        return Optional.empty();
    }

    public void saveToDbCache(int number, String result) {
        FizzBuzzEntity fizzBuzzEntity = new FizzBuzzEntity();
        fizzBuzzEntity.setId(number);
        fizzBuzzEntity.setResult(result);
        fizzBuzzRepository.save(fizzBuzzEntity);
    }
}
