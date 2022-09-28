package com.lec.java.array14;

import java.util.Arrays;

public class Array14Main {

	public static void main(String[] args) {
		System.out.println("Reference 타입 주의할 사항");
		
		int a = 10;
		int b = 20;
		System.out.println("a:" + a + ", b:" + b);
		
		a = b;
		System.out.println("a:" + a + ", b:" + b);
		
		a = 30;
		System.out.println("a:" + a + ", b:" + b);
		
		// 배열
		int [] arrA = new int[] {10, 10, 10};
		int [] arrB = new int[] {20, 20, 20};
		System.out.println("A:" + Arrays.toString(arrA) + ", B:" + Arrays.toString(arrB));
		
		arrA = arrB;
		System.out.println("A:" + Arrays.toString(arrA) + ", B:" + Arrays.toString(arrB));
		
		arrA[0] = 500;
		System.out.println("A:" + Arrays.toString(arrA) + ", B:" + Arrays.toString(arrB));

		System.out.println("\n프로그램 종료");
	} // end main

} // end class



















