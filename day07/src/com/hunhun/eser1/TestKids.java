package com.hunhun.eser1;

public class TestKids {
	public static void main(String[] args) {
		Kid someKid = new Kid();
		
		someKid.setSex(1);
		someKid.setSalary(1024);
		someKid.setYearsOld(18);
		
		someKid.manOrWoman();
		someKid.employeed();
		someKid.printAge();
	}
}
