package com.lec.java.datetime05;

import java.sql.Timestamp;
import java.time.LocalDateTime;

/*
 * java.sql.Timestamp;
 * 1970.01.01 00:00:00  GMT 기준 의 경과 시간을 ms 로 계산해 담은 객체
 */
public class DateTime05Main {

	public static void main(String[] args) {
		System.out.println("java.sql.Timestamp");
		
		Timestamp t;
		
		System.out.println("현재ms " + System.currentTimeMillis());
		t = new Timestamp(System.currentTimeMillis());
		System.out.println(t);
		
		t = new Timestamp(2000L);
		System.out.println(t);
		
		
		//----------------------------------------------
		// 문자열 -> Timestamp
		// 	방법1 : 정해진 형식 + Timesatmp.valutOf()
		System.out.println("String -> Timestamp");
		String now = "2022-07-06 20:36:12.0";
		t = Timestamp.valueOf(now);
		System.out.println(t);
		
		
		// Timestamp --> LocalDateTime
		LocalDateTime datetime1 = t.toLocalDateTime();
		System.out.println(datetime1);
		
		
		// 	방법2 : String -> Date -> Timestamp 
		// TODO
		
		//----------------------------------------------
		// Timestamp -> 문자열
		// SimpleDateFormat + Timestamp:getTime()
		// tODO
		
	}

}
