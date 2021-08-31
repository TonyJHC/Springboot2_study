package com.sparta.week02.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor  // 2. 단 ! 해당 어노테이션 필요함
public class PersonRequestDto {
    private final String name;
    private final String job;
    private final int age;
    private final String address;

}
