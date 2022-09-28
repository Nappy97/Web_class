package com.lec.java.inherit07;

public class Person {
	// 멤버 변수
	private String name;
	
	
	// getter & setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	// 메소드
	protected void showInfo() {
		System.out.println("이름: " + name);
	}
	
	// final 메소드 : 더이상 오버라이딩 불가
	// public final void showInfo()  <-- 해보자. 어디에 에러나는가?
	
	// final 클래스 : 더이상 상속 불가 
	// final class Person     <-- 해보자, 어디에 에러나는가?`
	
}
