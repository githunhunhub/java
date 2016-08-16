package com.hunhun.exer;

public class Kid extends ManKind{
	private int yearsOld;
	private int salary;
	
	public int getYearsOld() {
		return yearsOld;
	}


	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}


	public void printAge() {
		System.out.println("yearsOld is : " + yearsOld);
	}
	
	public void employeed() {
		if (salary == 0) {
			System.out.println("Student no job!");
		}else {
			System.out.println("Students needn't have a job.");
		}
	}
}
