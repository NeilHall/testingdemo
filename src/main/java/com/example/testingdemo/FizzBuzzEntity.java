package com.example.testingdemo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="fizzbuzz")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FizzBuzzEntity {
    @Column(name="id")
    @Id
    int id;

    @Column(name = "result")
    String result;
}
