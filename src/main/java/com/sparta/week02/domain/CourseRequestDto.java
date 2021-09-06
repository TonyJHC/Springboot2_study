package com.sparta.week02.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor  // 2. 단 ! 해당 어노테이션 필요함
public class CourseRequestDto {
    private  final String title; // 1. final로 필수적인 요소라고 명함 --> 필요한 생성자를 자동으로 만들어줌
    private  final String tutor;
}
