package com.hunhun.java;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;

import org.junit.Test;

public class TestObjectInputOutputStream {
	@Test
	//�����л�
	public void testObjectInputStream(){
		ObjectInputStream ois = null;
		try {
			ois = new ObjectInputStream(
					new FileInputStream("person.txt"));
			
			Person p1 = (Person)ois.readObject();
			System.out.println(p1);
			Person p2 = (Person)ois.readObject();
			System.out.println(p2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			if(ois!=null){
				try {
					ois.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	@Test
	//��������л���ͨ��ObjectOutputStreamת��Ϊ��������
	public void testObjectOutputStream() {
		Person p1 = new Person("С��", 23, new Pet("��"));
		Person p2 = new Person("С��", 21, new Pet("��"));

		ObjectOutputStream oos = null;
		try {
			oos = new ObjectOutputStream(new FileOutputStream("Person.txt"));

			oos.writeObject(p1);
			oos.flush();
			oos.writeObject(p2);
			oos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (oos != null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
}

class Person implements Serializable{	//Ҫ�����Ҫ�������л�
	private static final long serialVersionUID = 12345678L;
	String name;
	Integer age;
	Pet pet;

	public Person(String name, Integer age, Pet pet) {
		super();
		this.name = name;
		this.age = age;
		this.pet = pet;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", pet=" + pet + "]";
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
class Pet implements Serializable{
	private static final long serialVersionUID = 108764567L;
	String name;
	public Pet(String name){
		this.name = name;
	}
	@Override
	public String toString() {
		return "Pet [name=" + name + "]";
	}
	
}