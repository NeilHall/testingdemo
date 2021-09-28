package com.example.testingdemo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FizzBuzzRepository extends JpaRepository<FizzBuzzEntity, Integer> {
}
