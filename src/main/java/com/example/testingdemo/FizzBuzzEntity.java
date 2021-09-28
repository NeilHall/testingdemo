package com.example.testingdemo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fizzbuzz")
@Getter
@Setter
public class FizzBuzzEntity {
    @Column(name="id")
    @Id
    int id;

    @Column(name = "result")
    String result;
}
