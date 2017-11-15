package com.cafe24.timetable.timetable.domain;

import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CombinationOfSubject {

	private Subject subject;
	private List<List<SubjectTime>> combiSubjectTimeList;

	public CombinationOfSubject(Subject subject, List<List<SubjectTime>> combiSubjectTimeList) {
		this.subject = subject;
		this.combiSubjectTimeList = combiSubjectTimeList;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public List<List<SubjectTime>> getCombiSubjectTimeList() {
		return combiSubjectTimeList;
	}

	public void setCombiSubjectTimeList(List<List<SubjectTime>> combiSubjectTimeList) {
		this.combiSubjectTimeList = combiSubjectTimeList;
	}

	public int sizeOfSubjectTimeList() {
		if (CollectionUtils.isEmpty(this.combiSubjectTimeList)) {
			return 0;
		} else {
			return this.combiSubjectTimeList.size();
		}
	}

	public List<SubjectTime> findSubjectTimeListByIndex(int index) {
		if (CollectionUtils.isEmpty(this.combiSubjectTimeList)) {
			return null;
		}

		return this.combiSubjectTimeList.get(index);
	}

	public List<Subject> toSubjectList(int selectedIndex) {
		List<Subject> subjectList = new ArrayList<>();
		List<SubjectTime> subjectTimeList = this.findSubjectTimeListByIndex(selectedIndex);

		for (SubjectTime subjectTime : subjectTimeList) {
			Subject subject = this.subject.clone();
			subject.setSubjectTimeList(Collections.singletonList(subjectTime));
			subjectList.add(subject);
		}

		return subjectList;
	}

	@Override
	public String toString() {
		return "CombinationOfSubject{" +
				"subject=" + subject +
				", combiSubjectTimeList=" + combiSubjectTimeList +
				'}';
	}
}
