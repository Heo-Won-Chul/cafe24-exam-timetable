package com.cafe24.timetable.timetable.domain;

import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.subjecttime.domain.SubjectTime;

import java.util.List;

public class CombinationOfSubject {

	private Subject subject;
	private List<List<SubjectTime>> subjectTimeList;

	public CombinationOfSubject(Subject subject, List<List<SubjectTime>> subjectTimeList) {
		this.subject = subject;
		this.subjectTimeList = subjectTimeList;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<List<SubjectTime>> getSubjectTimeList() {
		return subjectTimeList;
	}

	public void setSubjectTimeList(List<List<SubjectTime>> subjectTimeList) {
		this.subjectTimeList = subjectTimeList;
	}

	@Override
	public String toString() {
		return "CombinationOfSubject{" +
				"subject=" + subject +
				", subjectTimeList=" + subjectTimeList +
				'}';
	}
}
