package com.lec.java.inherit07;

public class BusinessPerson extends Person {
	// 멤버 변수
	private String company;

	// getter & setter
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	
	@Override
//	void showInfo() {  // 불가
//	public void showInfo() { // 가능
	protected void showInfo() {
		super.showInfo();
		System.out.println("회사: " + company);
	}
	
	// ↓ 요건 오버로딩
	private void showInfo(int id) {
		System.out.println("id: " + id);
		System.out.println("이름: " + getName());
		System.out.println("회사: " + company);	
	}

	@Override
	public String toString() {
		return String.format("BusinessPerson: %s %s", getName(), getCompany());
	}
	
	// 이클립스에서 
	// ALT + SHIFT + S, V 를 누르면 오버라이드 진행
	//  ※ ALT + SHIFT + S 를 Show Source Quick Menu 라 함
	
	
	
}


















