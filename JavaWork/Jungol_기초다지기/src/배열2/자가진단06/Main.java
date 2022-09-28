package 배열2.자가진단06;

import java.util.Scanner;

/*
569 : 배열2 - 자가진단6 
http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=206&sca=10a0


[문제]
5명 학생의 국어 영어 수학 과학 4과목의 점수를 입력 받아서 
각 개인별로 평균이 80 이상이면“합격” 그렇지 않으면“불합격”을 출력하고 
합격한 사람의 수를 출력하는 프로그램을 작성하시오.


[입력예]
85 67 95 65
80 95 86 56
100 98 67 86
95 76 84 65
67 86 90 76

[출력예]
fail
fail
pass
pass
fail
Successful : 2

*/

public class Main {

	public static void main(String[] args) {
		// 5명 학생 x 4개 과목 점수 담을 2차원 배열 준비
		int[][] score = new int[5][4];
		
		Scanner sc = new Scanner(System.in);
		
		for (int stu = 0; stu < score.length; stu++) {
			for(int subj = 0; subj < score[stu].length; subj++) {
				score[stu][subj] = sc.nextInt();
			}
		}
		
		sc.close();
		
		
		int sum;
		double avg;
		int success = 0;   // 합격(pass) 한 학생수
		
		// 학생별로 점수 계산
		for(int stu = 0; stu < score.length; stu++) {
			sum = 0;
			avg = 0.0;
			
			// stu 번째 학생의 총점 구하기 => sum
			for(int subj = 0; subj < score[stu].length; subj++) {
				sum += score[stu][subj];
			}
			// stu 번째 학생의 평균 구하기
			avg = (double)sum / score[stu].length;
			
			if(avg >= 80) {
				System.out.println("pass");
				success++;  // 합격자수 +1 증가
			} else {
				System.out.println("fail");
			}
			
		}
		
		System.out.println("Successful : " + success);
		
		
		// # 배열2 - 형성5

	}

}




















