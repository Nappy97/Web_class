package 반복제어문2.형성평가04;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int total = 0; // 누적합계
		
		int i = 0;
		while(i < n) {
			total += sc.nextInt();
			i++;
		}
		
		double avg = (double)total / n;  // 평균
		System.out.printf("%.2f", avg);
		
		sc.close();
	}

}
