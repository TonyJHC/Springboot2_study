package com.sparta.week02.controller;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import com.sparta.week02.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController // json으로 넘겨줘야함
public class CourseController {

    private final CourseRepository courseRepository; // 꼭 필요하니까 final --> 필요한 생성자를 자동으로 만들어줌 단 ! @RequiredArgsConstructor 롬복 필수

    private final CourseService courseService;

    // PostMapping을 통해서, 같은 주소라도 방식이 다름을 구분합니다.
    @PostMapping("/api/courses") // 해당 url로 POST방식 ( 데이터 생성 ) 요청이 오면
    public Course createCourse(@RequestBody CourseRequestDto requestDto) { // @RequestBody --> Controller에서 요청을 받는 녀석 ( 스프링은 요청을 주고받는 방식을 강제한다 )
        // requestDto 는, 생성 요청을 의미합니다.
        // 강의 정보를 만들기 위해서는 강의 제목과 튜터 이름이 필요하잖아요?
        // 그 정보를 가져오는 녀석입니다.

        // 저장하는 것은 Dto가 아니라 Course이니, Dto의 정보를 course에 담아야 합니다.
        // 잠시 뒤 새로운 생성자를 만듭니다.
        Course course = new Course(requestDto);

        // JPA를 이용하여 DB에 저장하고, 그 결과를 반환합니다.
        return courseRepository.save(course);
    }

    @GetMapping("/api/courses") // 해당 url 로 GET방식 ( 데이터 조회 ) 요청이 오면
    public List<Course> getCourses() { // 해당 메소드를 실행해라 ( 라고 스프링에게 알려주기 )
        return courseRepository.findAll(); // 모든 데이터
    }

    @PutMapping("/api/courses/{id}") // {} 안에는 유동적인 값이 온다
    public Long updateCourse(@PathVariable Long id, @RequestBody CourseRequestDto requestDto) {  // @PathVariable --> 클라이언트로부터 수정할 유동적인 값을 받으면 자동으로 Long id에 넣어준다.
        return courseService.update(id, requestDto);
    }

    @DeleteMapping("/api/courses/{id}")
    public Long deleteCourse(@PathVariable Long id) {
        courseRepository.deleteById(id);
        return id;
    }


}


