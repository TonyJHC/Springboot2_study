package com.sparta.week02;

import com.sparta.week02.domain.Course;
import com.sparta.week02.domain.CourseRepository;
import com.sparta.week02.domain.CourseRequestDto;
import com.sparta.week02.service.CourseService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.List;


//@EnableJpaAuditing // 생성일자/수정일자 반영을 위해서
//@SpringBootApplication
//public class Week02Application {
//
//    public static void main(String[] args) {
//        SpringApplication.run(Week02Application.class, args);
//    }
//
//    @Bean
//    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
//        return (args) -> {
//            courseRepository.save(new Course("Fever", "Choi"));

//            System.out.println("data print");
//            List<Course> courseList = courseRepository.findAll();
//            for (int i = 0; i < courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//
//
//            Course new_course = new Course("Spring", "Tony"); // 안좋은 예시임 Dto를 만들어서 해야됨
//            CourseRequestDto requestDto = new CourseRequestDto("Petcoms", "Hyun"); // Dto만들어서 함
//            courseService.update(1L, requestDto);
//            courseList = courseRepository.findAll();
//            for (int i = 0; i < courseList.size(); i++) {
//                Course course = courseList.get(i);
//                System.out.println(course.getId());
//                System.out.println(course.getTitle());
//                System.out.println(course.getTutor());
//            }
//

//        };
//    }
//}


@EnableJpaAuditing
@SpringBootApplication
public class Week02Application {

    public static void main(String[] args) {
        SpringApplication.run(Week02Application.class, args);
    }

    @Bean
    public CommandLineRunner demo(CourseRepository courseRepository, CourseService courseService) {
        return (args) -> {
            courseRepository.save(new Course("프론트엔드의 꽃, 리액트", "임민영"));

            System.out.println("데이터 인쇄");
            List<Course> courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }

            CourseRequestDto requestDto = new CourseRequestDto("웹개발의 봄, Spring", "임민영");
            courseService.update(1L, requestDto);
            courseList = courseRepository.findAll();
            for (int i=0; i<courseList.size(); i++) {
                Course course = courseList.get(i);
                System.out.println(course.getId());
                System.out.println(course.getTitle());
                System.out.println(course.getTutor());
            }
        };
    }
}
