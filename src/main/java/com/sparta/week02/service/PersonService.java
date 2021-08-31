package com.sparta.week02.service;


import com.sparta.week02.domain.Person;
import com.sparta.week02.domain.PersonRepository;
import com.sparta.week02.domain.PersonRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // Lombok을 사용하여 CourseRepository를 자동으로 넘겨주는 생성자 코드를 절약함
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class PersonService {

    private final PersonRepository personRepository;

    @Transactional
    public Long update(Long id ,PersonRequestDto personRequestDto){
        Person person1 = personRepository.getById(id);

        person1.update(personRequestDto);
        return person1.getId();
    }
}
