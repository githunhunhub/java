package com.hunhun.java;


public class Person implements Comparable{
	private String name;
	private Integer age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
		super();
	}
	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	//当向TreeSet中添加自定义对象，按此方法排序
	@Override
	public int compareTo(Object o) {
		if(o instanceof Person){
			Person p = (Person)o;
//			return this.name.compareTo(p.name);
//			return -this.age.compareTo(p.age);
			//多重排序
			int i = this.age.compareTo(p.age);
			if(i == 0){
				return this.name.compareTo(p.name);
			}else {
				return i;
			}
		}
		return 0;
	};
	
}
