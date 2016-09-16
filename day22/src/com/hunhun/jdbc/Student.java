package com.hunhun.jdbc;

public class Student {
	private int flowId;

	private int type;

	private String idCard;

	private String examCard;

	private String name;

	private String location;

	private int grade;

	public Student() {
		super();
	}

	public Student(int flowId, int type, String idCard, String examCard, String name, String location, int grade) {
		super();
		this.flowId = flowId;
		this.type = type;
		this.idCard = idCard;
		this.examCard = examCard;
		this.name = name;
		this.location = location;
		this.grade = grade;
	}
	

	@Override
	public String toString() {
		return "Student [flowId=" + flowId + ", type=" + type + ", idCard=" + idCard + ", examCard=" + examCard
				+ ", name=" + name + ", location=" + location + ", grade=" + grade + "]";
	}

	public int getFlowId() {
		return flowId;
	}

	public void setFlowId(int flowId) {
		this.flowId = flowId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getExamCard() {
		return examCard;
	}

	public void setExamCard(String examCard) {
		this.examCard = examCard;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

}
