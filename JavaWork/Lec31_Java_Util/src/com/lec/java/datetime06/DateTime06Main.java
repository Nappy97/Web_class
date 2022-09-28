package com.lec.java.datetime06;

import java.time.LocalDate;
import java.time.temporal.TemporalAdjusters;

public class DateTime06Main {

	public static void main(String[] args) {
		LocalDate start = LocalDate.now();
		System.out.println("start: " + start);
		
		// 특정날짜 기준으로 다음달
		System.out.println("start + 1 month: " + start.plusMonths(1));
		
		// 특정날까 기준으로 다음달의 마지막 날
		LocalDate end = start.plusMonths(1).with(TemporalAdjusters.lastDayOfMonth());
		System.out.println("다음달 마지막 날: " + end);
	}

}
