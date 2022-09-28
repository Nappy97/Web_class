package 입력.자가진단07;
/*


[입력예]
[출력예]
 */
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//두 개의 정수를 입력 받기
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		// 곱과 몫을 출력하기
		// ex)
//		16 * 5 = 80
//		16 / 5 = 3
		System.out.println(num1 + " * " + num2 + " = " + (num1 * num2));
		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		
		sc.close();
	}

}