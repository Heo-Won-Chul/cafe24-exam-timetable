package com.cafe24.timetable.timetable.service;

import com.cafe24.timetable.common.exception.DefaultServerException;
import com.cafe24.timetable.common.exception.OutOfRangeGradesException;
import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.subject.service.SubjectConverterService;
import com.cafe24.timetable.subject.service.SubjectService;
import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import com.cafe24.timetable.subjecttime.service.SubjectTimeService;
import com.cafe24.timetable.timetable.domain.CombinationOfSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class DefaultCreatingTimeTableService implements CreatingTimeTableService {

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private SubjectConverterService subjectConverterService;

	@Autowired
	private SubjectTimeService subjectTimeService;

	// 시간표 자동 생성
	public List<List<Subject>> create(List<Subject> subjectList) {
		if (CollectionUtils.isEmpty(subjectList)) {
			throw new DefaultServerException();
		}

		List<List<Subject>> timeTableList = new ArrayList<>();
		subjectList = subjectService.addSubjectTimeList(subjectList);

		if (subjectService.isOutOfRange(subjectList)) {
			throw new OutOfRangeGradesException();
		}

		List<CombinationOfSubject> combinationOfSubjectList = subjectConverterService.toCombinationOfSubjectList(subjectList);

		return addTimeTable(timeTableList, Collections.emptyList(), combinationOfSubjectList, 0);
	}

	// 시간표 추가
	private List<List<Subject>> addTimeTable(List<List<Subject>> timeTableList, List<Subject> subjectList, List<CombinationOfSubject> combiSubjectList, int currentIndex) {
		if (currentIndex == combiSubjectList.size()) {
			timeTableList.add(subjectList);
			return timeTableList;
		}
		
		CombinationOfSubject combinationOfSubject = combiSubjectList.get(currentIndex);

		for (int i = 0; i < combinationOfSubject.sizeOfSubjectTimeList(); i++) {
			List<SubjectTime> subjectTimeList = subjectConverterService.toSubjectTimeList(subjectList);
			List<SubjectTime> compareSubjectTimeList = combinationOfSubject.findSubjectTimeListByIndex(i);

			if (subjectTimeService.isNoneMatchedList(subjectTimeList, compareSubjectTimeList)) {
				List<Subject> clonedSubjectList = new ArrayList<>(subjectList);
				clonedSubjectList.addAll(combinationOfSubject.toSubjectList(i));
				
				addTimeTable(timeTableList, clonedSubjectList, combiSubjectList, currentIndex + 1);
			}
		}

		return timeTableList;
	}
}
