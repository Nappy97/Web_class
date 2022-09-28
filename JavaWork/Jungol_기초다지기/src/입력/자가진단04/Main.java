package 입력.자가진단04;

/* http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=149&sca=1020
512 : 입력 - 자가진단4
추의 무게를 저장할 변수와 중력의 비율을 저장할 변수를 선언하고,
다음 두 값을 변수에 저장하여 곱셈 계산식을 출력하는 프로그램을 작성하라.

추의 무게 = 49, 중력의 비율 = 0.2683

출력 예
49 * 0.268300 = 13.146700
 */
public class Main {

	public static void main(String[] args) {
		int weight = 49;
		double gravityRate = 0.2683;
		
		System.out.printf("%d * %.6f = %.6f\n", weight, gravityRate, weight * gravityRate);

	}

}
