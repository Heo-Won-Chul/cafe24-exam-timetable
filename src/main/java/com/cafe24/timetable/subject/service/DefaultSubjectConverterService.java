package com.cafe24.timetable.subject.service;

import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import com.cafe24.timetable.timetable.domain.CombinationOfSubject;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultSubjectConverterService implements SubjectConverterService {

	@Override
	public List<SubjectTime> toSubjectTimeList(List<Subject> subjectList) {
		if (CollectionUtils.isEmpty(subjectList)) {
			return null;
		}

		List<SubjectTime> subjectTimeList = new ArrayList<>();

		for (Subject subject : subjectList) {
			subjectTimeList.add(subject.findSubjectTimeByIndex(0));
		}

		return subjectTimeList;
	}

	@Override
	public List<CombinationOfSubject> toCombinationOfSubjectList(List<Subject> subjectList) {
		if (CollectionUtils.isEmpty(subjectList)) {
			return null;
		}

		List<CombinationOfSubject> combinationOfSubjectList = new ArrayList<>();
		for (Subject subject : subjectList) {
			CombinationOfSubject combinationOfSubject = subject.toCombinationOfSubject();
			combinationOfSubjectList.add(combinationOfSubject);
		}
		return combinationOfSubjectList;
	}
}
