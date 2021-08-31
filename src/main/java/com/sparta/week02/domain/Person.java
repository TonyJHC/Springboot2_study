package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Person extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String job;

    @Column(nullable = false)
    private int age;

    @Column(nullable = false)
    private String address;

    public Person(PersonRequestDto personRequestDto){
        this.name = personRequestDto.getName();
        this.address = personRequestDto.getAddress();
        this.age = personRequestDto.getAge();
        this.job = personRequestDto.getJob();
    }

    public void update(PersonRequestDto personRequestDto){
        this.job = personRequestDto.getJob();
        this.age = personRequestDto.getAge();
        this.address = personRequestDto.getAddress();
        this.name = personRequestDto.getName();
    }

}