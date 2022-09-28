package 입력.형성평가04;

import java.util.Scanner;

/* http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=9&sca=1020
109 : 입력 - 형성평가4
세 개의 정수를 입력받아 합을 출력하는 프로그램을 작성하시오.

입력 예]
20 50 100

출력 예]
sum = 170
 * 
 */
public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		
		System.out.printf("sum = %d\n", num1 + num2 + num3);
		
		sc.close();

	}

}
