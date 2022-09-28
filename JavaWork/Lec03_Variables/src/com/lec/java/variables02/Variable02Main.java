package com.lec.java.variables02;

public class Variable02Main {

	public static void main(String[] args) {

		// 변수 선언과 동시에 초기화
		int num1 = 10;
		System.out.println("num1 = " + num1);
		
		num1 = 11111;   // 변수의 값은 언제든지 변경할수 있다 (그래서 변수!)
		System.out.println("num1 = " + num1);
		
		int korean = 50;
		int english = 60;
		int mathematics = 33;
		System.out.println("총점 : " + (korean + english + mathematics));
		
		int total = korean + english + mathematics;
		System.out.println("총점 : " + total);
		System.out.println("평균 : " + total / 3.0);
		
		// 변수명 바꿀때는 refactor-rename 사용하자!   ALT+SHIFT+R
		
	}

}
