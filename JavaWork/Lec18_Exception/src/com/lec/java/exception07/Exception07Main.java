package com.lec.java.exception07;

import java.util.Scanner;

/* Exception 클래스 만들어 사용하기  & throw
 	Exception 또는 RuntimeException 클래스를 상속 받아서 만듬
 */
public class Exception07Main {

	static Scanner sc = new Scanner(System.in);
	
	
	// TODO : ScoreException 을 throws 하는 메소드 만들기
	public static int inputScore() throws ScoreException{
		int score = sc.nextInt();

		if(score < 0 || score > 100) {
//			ScoreException ex = new ScoreException();
			
			// 예외 메세지를 작성.
			ScoreException ex = new ScoreException(score + "는 입력할수 없는 점수 (0 ~ 100)");
			
			throw ex;   // 예외 객체를 인위적으로 throw
		}
		
		return score;
	} // end inputScore()
	
	
	public static void main(String[] args) {
		System.out.println("예외 클래스 만들기, throw");
		
		System.out.println();

		// TODO : ScoreException 을 catch 해보자
		while(true) {			
			try {			
				System.out.println("국어 점수 입력:");
				int kor = inputScore();
				System.out.println("kor = " + kor);
				break;
				
//			System.out.println("영어 점수 입력:");
//			int eng = inputScore();
//			System.out.println("eng = " + eng);
				
			} catch(ScoreException ex) {
				System.out.println(ex.getMessage());
				System.out.println("다시 입력하세요");
				sc.nextLine();
			} 
		}
		
		sc.close();

			
		System.out.println("프로그램 종료");
	} // end main()

} // end class Exception07Main












