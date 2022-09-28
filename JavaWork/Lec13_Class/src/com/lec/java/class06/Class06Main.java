package com.lec.java.class06;

public class Class06Main {

	public static void main(String[] args) {
		System.out.println("클래스 연습 : 성적처리");
		
		Score score1 = new Score();
		
		score1.setKor(100);
		score1.setEng(34);
		score1.setName("hong");
		
		System.out.println(score1.getKor());
		
		// toString() 
		System.out.println(score1);
		
		
		
		Score score2 = Score.builder()
			.kor(60)
			.eng(56)
			.name("kim")
			.build()
			;
		
		System.out.println(score2);
		
		

		System.out.println("프로그램 종료");
	} // end main()

} // end class Clas06Main










