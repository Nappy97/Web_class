package com.lec.java.input01;

import java.util.Scanner;  // import 필요 (외부 객체이기 때문에)

/*
 * 표준입력(Standard Input): 키보드로부터 입력
 * Scanner 객체 사용
 * 
 */
public class Input01Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);   //  Scanner 객체 생성
		
		// 키보드 입력 작업들 수행...
		int num1, num2;
		
		System.out.print("숫자 1을 입력하세요: ");
		num1 = sc.nextInt();   // 키보드로부터 정수 한개를 입력받아서 결과를 int값으로 돌려줌 (리턴)`
		System.out.print("숫자 2를 입력하세요: ");
		num2 = sc.nextInt();
		
		System.out.println(num1 + " + " + num2 + " = " + (num1 + num2));
		
		// 각 primitive 타입에 대해 nextXXX() 메소드 제공
//		sc.nextByte();
//		sc.nextShort();
//		sc.nextLong();
//		sc.nextFloat();
//		sc.nextDouble();
//		sc.nextBoolean();
		
		sc.close(); // Scanner 객체를 사용한 뒤에는 반드시 close() 를 해주어야 한다
		// close() <-- 사용한 시스템 자원 (키보드, hw, 파일, 네트워크 등...) 을 시스템에 반납
	}

}




















