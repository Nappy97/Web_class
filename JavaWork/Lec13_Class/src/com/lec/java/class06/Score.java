package com.lec.java.class06;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Getter  // getter 생성
//@Setter  // setter 생성
//@ToString  // toString() 생성
@NoArgsConstructor   // 기본생성자 생성
@AllArgsConstructor  // 매개변수 받는 생성자 생성
@RequiredArgsConstructor // @NonNull 이 붙은 필드 생성자
@Data  // getter, setter, toString, equals, hashCode..

@Builder   // builder 패턴 제공
public class Score {

	@NonNull
	private String name;
	@NonNull
	private Integer kor;
	private Integer eng;
	private Integer math;
	
	
}


















