package com.hunhun.eser1;

public class Kid extends ManKind{
	private int yearsOld;
	
	
	public int getYearsOld() {
		return yearsOld;
	}


	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}


	public void printAge() {
		System.out.println("yearsOld is : " + yearsOld);
	}
}
