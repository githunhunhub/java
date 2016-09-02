package com.hunhun.java1;

public class TestSeason {
	public static void main(String[] args) {
		Season spring = Season.SPRING;
		System.out.println(spring);
		spring.show();
		System.out.println(spring.getSeasonName());

	}
}

// 枚举类
class Season {
	// 1.类的属性声明为private final
	private final String seasonName;
	private final String seasonDesc;

	// 2.声明为final的属性在构造器中初始化
	private Season(String seasonName, String seasonDesc) {
		this.seasonName = seasonName;
		this.seasonDesc = seasonDesc;
	}

	// 3.通过公共方法调用属性
	public String getSeasonName() {
		return seasonName;
	}

	public String getSeasonDesc() {
		return seasonDesc;
	}

	// 4.创建枚举类的对象:将类的对象声明为public static final
	public static final Season SPRING = new Season("Spring", "春暖花开！");
	public static final Season SUMMER = new Season("Summer", "夏日炎炎！");
	public static final Season AUTUMN = new Season("Autumn", "秋高气爽！");
	public static final Season WINTER = new Season("Winter", "白雪皑皑！");

	@Override
	public String toString() {
		return "Season [seasonName=" + seasonName + ", seasonDesc=" + seasonDesc + "]";
	}

	public void show() {
		System.out.println("这是一个美丽的季节!");
	}

}
