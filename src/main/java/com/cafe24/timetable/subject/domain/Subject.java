package com.cafe24.timetable.subject.domain;

import com.cafe24.timetable.subjecttime.domain.SubjectTime;

import java.util.List;

public class Subject {

	private String code;
	private String name;
	private int grade;
	private List<SubjectTime> subjectTimeList;

	public Subject() {}

	public Subject(String code) {
		this.code = code;
	}

	public Subject(String code, String name, int grade) {
		this.code = code;
		this.name = name;
		this.grade = grade;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public List<SubjectTime> getSubjectTimeList() {
		return subjectTimeList;
	}

	public void setSubjectTimeList(List<SubjectTime> subjectTimeList) {
		this.subjectTimeList = subjectTimeList;
	}

	@Override
	public String toString() {
		return "Subject{" +
				"code='" + code + '\'' +
				", name='" + name + '\'' +
				", grade=" + grade +
				", subjectTimeList=" + subjectTimeList +
				'}';
	}
}
