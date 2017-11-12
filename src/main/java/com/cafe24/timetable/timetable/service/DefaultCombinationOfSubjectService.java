package com.cafe24.timetable.timetable.service;

import com.cafe24.timetable.common.exception.DefaultServerException;
import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import com.cafe24.timetable.timetable.domain.CombinationOfSubject;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DefaultCombinationOfSubjectService implements CombinationOfSubjectService {

	private static final int THREE_GRADE = 3;

	@Override
	public CombinationOfSubject create(Subject subject) {
		if (ObjectUtils.isEmpty(subject)) {
			throw new DefaultServerException();
		}

		List<List<SubjectTime>> combinationList = new ArrayList<>();
		if (subject.getGrade() == THREE_GRADE) {
			combinationList.add(Arrays.asList(subject.getSubjectTimeList().get(0), subject.getSubjectTimeList().get(1)));
			combinationList.add(Arrays.asList(subject.getSubjectTimeList().get(0), subject.getSubjectTimeList().get(2)));
			combinationList.add(Arrays.asList(subject.getSubjectTimeList().get(1), subject.getSubjectTimeList().get(2)));
		} else {
			combinationList.add(Arrays.asList(subject.getSubjectTimeList().get(0)));
			combinationList.add(Arrays.asList(subject.getSubjectTimeList().get(1)));
			combinationList.add(Arrays.asList(subject.getSubjectTimeList().get(2)));
		}

		return new CombinationOfSubject(subject, combinationList);
	}
}
