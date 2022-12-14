package com.lec.spring.di04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.lec.spring.beans.Score;

@Configuration
public class Config04 {

	public Config04() {
		System.out.println("Config04() 생성");
	}

	@Bean(name = "Park")
	public Score score1() {
		return new Score(100, 80, 75, "좋아용");
	}

	@Bean(name = "Kim")
	public Score score2() {
		return new Score(24, 42, 63, "나빠요");
	}
}
