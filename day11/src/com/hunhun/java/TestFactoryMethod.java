package com.hunhun.java;

public class TestFactoryMethod {
	public static void main(String[] args) {
		IWorkFactory i = new StudnetWorkFactory();
		i.getWork().doWork();

		IWorkFactory i1 = new TeacherWorkFactory();
		i1.getWork().doWork();
	}
}

interface IWorkFactory {
	Work getWork();
}

class StudnetWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new StudentWork();
	}

}

class TeacherWorkFactory implements IWorkFactory {

	@Override
	public Work getWork() {
		return new TeacherWork();
	}

}

interface Work {
	void doWork();
}

class StudentWork implements Work {

	@Override
	public void doWork() {
		System.out.println("doing homework");
	}
}

class TeacherWork implements Work {

	@Override
	public void doWork() {
		System.out.println("see homework");
	}

}