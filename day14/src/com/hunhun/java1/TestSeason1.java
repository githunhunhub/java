package com.hunhun.java1;

public class TestSeason1 {
	public static void main(String[] args) {
		Season1 spring = Season1.SPRING;
		System.out.println(spring);
		spring.show();
		System.out.println(spring.getSeasonName());
		// 1.values()
		Season1[] seasons = Season1.values();
		for (int i = 0; i < seasons.length; i++) {
			System.out.println(seasons[i]);
		}
		System.out.println();
		// 2.valueOf(String name)
		String str = "WINTER";
		Season1 sea = Season1.valueOf(str);
		System.out.println(sea);
		
		System.out.println();

		Thread.State[] states = Thread.State.values();
		for (int i = 0; i < states.length; i++) {
			System.out.println(states[i]);
		}
		sea.show();
	}
}

interface Info {
	void show();
}

// ö����
enum Season1 implements Info{
	SPRING("Spring", "��ů������"){
		public void show() {
			System.out.println("Spring !!!");
		}
	}, 
	SUMMER("Summer", "�������ף�"){
		public void show(){
			System.out.println("Summer !!!");
		}
	}, 
	AUTUMN("Autumn", "�����ˬ��"){
		public void show(){
			System.out.println("Summer !!!");
		}
	},
	WINTER("Winter", "��ѩ������"){
		public void show(){
			System.out.println("Summer !!!");
		}
	};

	private final String seasonName;
	private final String seasonDesc;

	private Season1(String seasonName, String seasonDesc) {
		this.seasonName =  seasonName;
		this.seasonDesc = seasonDesc;
	}

	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}

//	public void show() {
//		System.out.println("����һ�������ļ���!");
//	}
}
