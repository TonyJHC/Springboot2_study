package com.sparta.week02.service;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor // Lombok을 사용하여 CourseRepository를 자동으로 넘겨주는 생성자 코드를 절약함
@Service // 스프링에게 이 클래스는 서비스임을 명시
public class CourseService {

    // final: 서비스에게 꼭 필요한 녀석임을 명시
    private final CourseRepository courseRepository; // Repository에서 sql문을 날리니까 필요함 --> update하려면 sql문 필요하니까

    // ----------- Lombok 을 통해 절약된 코드 --------------------
    // 생성자를 통해, Service 클래스를 만들 때 꼭 Repository를 넣어주도록
    // 스프링에게 알려줌
//    public CourseService(CourseRepository courseRepository) { // 스프링이 CourseService를 만들때 매개변수를 넣어준다 ( final ) 표시를 했기 때문
//        this.courseRepository = courseRepository;
//    }

    ///////////////////////////위에까지가 CourseRepository를 사용하기 쉽게 Spring이 손쉽게 설정해줌

    @Transactional // SQL 쿼리가 일어나야 함을 스프링에게 알려줌
    public Long update(Long id, CourseRequestDto requestDto) {
        Course course1 = courseRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 아이디가 존재하지 않습니다.")
        );

        course1.update(requestDto); // 업데이트
        return course1.getId(); // 업데이트 된 테이블의 data(row) 의 id를 알려줌

    }
}
