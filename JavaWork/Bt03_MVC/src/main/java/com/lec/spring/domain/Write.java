package com.lec.spring.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Write {
	
	private String name;
	private String subject;
	private String content;
	private Integer age;
}
