package com.cafe24.timetable.subject.domain;

import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import com.cafe24.timetable.timetable.domain.CombinationOfSubject;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Subject implements Cloneable {

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

	public SubjectTime findSubjectTimeByIndex(int index) {
		if (CollectionUtils.isEmpty(this.subjectTimeList)) {
			return null;
		}

		return this.subjectTimeList.get(index);
	}

	private static final int THREE_GRADE = 3;

	public CombinationOfSubject toCombinationOfSubject() {
		List<List<SubjectTime>> combinationList = new ArrayList<>();
		if (this.grade == THREE_GRADE) {
			combinationList.add(Arrays.asList(findSubjectTimeByIndex(0), findSubjectTimeByIndex(1)));
			combinationList.add(Arrays.asList(findSubjectTimeByIndex(0), findSubjectTimeByIndex(2)));
			combinationList.add(Arrays.asList(findSubjectTimeByIndex(1), findSubjectTimeByIndex(2)));
		} else {
			combinationList.add(Collections.singletonList(findSubjectTimeByIndex(0)));
			combinationList.add(Collections.singletonList(findSubjectTimeByIndex(1)));
			combinationList.add(Collections.singletonList(findSubjectTimeByIndex(2)));
		}

		return new CombinationOfSubject(this.clone(), combinationList);
	}

	@Override
	public Subject clone() {
		try {
			return (Subject) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
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
