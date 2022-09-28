package 반복제어문1.형성평가03;

import java.util.Scanner;

/*
127 : 반복제어문1 - 형성평가3
0 부터 100 까지의 정수를 계속 입력받다가 범위를 벗어나는 수가 입력되면 
그 이전까지 입력된 자료의 합계와 평균을 출력하는 프로그램을 작성하시오.
(평균은 반올림하여 소수 첫째자리까지 출력한다.)

입력 예]
55 100 48 36 0 101

출력 예]
sum : 239
avg : 47.8

 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num;
		int total = 0;  // 누적합산
		int count = 0;  // 합산한 숫자 개수
		
		while(true) {
			num = sc.nextInt();
			if(num < 0 || 100 < num) break;  // 무한루프 종료 조건
			
			total += num;
			count++;
		}
		
		// 결과 출력
		System.out.println("sum : " + total);
		System.out.printf("avg : %.1f", (double)total / count);
		
		
		sc.close();
	}

}












