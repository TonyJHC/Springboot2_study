package com.sparta.week02.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor // 기본생성자를 대신 생성해줍니다.
@Entity // 테이블임을 나타냅니다.
public class Course extends Timestamped { // 상속해서 사용

    @Id // ID 값, Primary Key로 사용하겠다는 뜻입니다.
    @GeneratedValue(strategy = GenerationType.AUTO) // 자동 증가 명령입니다. AUTO_INCREMENT
    private Long id;

    @Column(nullable = false) // 컬럼 값이고 반드시 값이 존재해야 함을 나타냅니다.
    private String title;

    @Column(nullable = false)
    private String tutor;

    // Post 방식으로 들어왔을 때 등록을 위해
    // 클라이언트에서 받은 정보 ( 이름, 튜터정보 ) 를 dto로 받은뒤
    // 실제 Class인 Course에 저장하여
    // DB에 반영해야된다. 따라서 Dto 형태로 받는 생성자가 필요함
    public Course(CourseRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }

    public Course(String title, String tutor) {
        this.title = title;
        this.tutor = tutor;
    }

    // 업데이트 함수
    public void update(CourseRequestDto requestDto ) {
        this.title = requestDto.getTitle();
        this.tutor = requestDto.getTutor();
    }
}
