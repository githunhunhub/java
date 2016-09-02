package com.hunhun.java1;

public class TestSeason {
	public static void main(String[] args) {
		Season spring = Season.SPRING;
		System.out.println(spring);
		spring.show();
		System.out.println(spring.getSeasonName());

	}
}

// ö����
class Season {
	// 1.�����������Ϊprivate final
	private final String seasonName;
	private final String seasonDesc;

	// 2.����Ϊfinal�������ڹ������г�ʼ��
	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	// 3.ͨ������������������
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	// 4.����ö����Ķ���:����Ķ�������Ϊpublic static final
	public static final Season SPRING = new Season("Spring", "��ů������");
	public static final Season SUMMER = new Season("Summer", "�������ף�");
	public static final Season AUTUMN = new Season("Autumn", "�����ˬ��");
	public static final Season WINTER = new Season("Winter", "��ѩ������");

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}

	public void show() {
		System.out.println("����һ�������ļ���!");
	}

}
