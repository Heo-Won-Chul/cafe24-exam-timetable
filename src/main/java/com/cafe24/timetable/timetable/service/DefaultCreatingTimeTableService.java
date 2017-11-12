package com.cafe24.timetable.timetable.service;

import com.cafe24.timetable.common.exception.DefaultServerException;
import com.cafe24.timetable.common.exception.OutOfRangeGradesException;
import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.subject.service.SubjectService;
import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import com.cafe24.timetable.timetable.domain.CombinationOfSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.*;

@Service
public class DefaultCreatingTimeTableService implements CreatingTimeTableService {

	@Autowired
	private SubjectService subjectService;

	@Autowired
	private CombinationOfSubjectService combinationOfSubjectService;

	private static final int MIN_SUM_GRADES = 18;
	private static final int MAX_SUM_GRADES = 21;

	// 시간표 자동 생성
	public List<List<Subject>> create(List<Subject> subjectList) {
		if (CollectionUtils.isEmpty(subjectList)) {
			throw new DefaultServerException();
		}

		List<List<Subject>> timeTableList = new ArrayList<>();
		subjectService.addSubjectTimeList(subjectList);

		if (isOutOfRange(subjectList)) {
			throw new OutOfRangeGradesException();
		}

		List<CombinationOfSubject> combinationOfSubjectList = new ArrayList<>();
		for (Subject subject : subjectList) {
			CombinationOfSubject combinationOfSubject = combinationOfSubjectService.create(subject);
			combinationOfSubjectList.add(combinationOfSubject);
		}

		return createTimeTableList(timeTableList, Collections.emptyList(), combinationOfSubjectList, 0);
	}

	// 범위 검사
	private boolean isOutOfRange(List<Subject> subjectList) {
		int sumGrades = 0;
		for (Subject subject : subjectList) {
			int grade = subject.getGrade();
			sumGrades += grade;
		}

		return sumGrades < MIN_SUM_GRADES || sumGrades > MAX_SUM_GRADES;
	}

	// 시간표 추가
	private List<List<Subject>> createTimeTableList(List<List<Subject>> timeTableList, List<Subject> subjectList, List<CombinationOfSubject> combiSubjectList, int currentIndex) {
		if (currentIndex == combiSubjectList.size()) {
			timeTableList.add(subjectList);
			return timeTableList;
		}

		CombinationOfSubject combinationOfSubject = combiSubjectList.get(currentIndex);

		for (int i = 0; i < combinationOfSubject.getSubjectTimeList().size(); i++) {
			List<SubjectTime> subjectTimeList = combinationOfSubject.getSubjectTimeList().get(i);
			if (isNotReduplicated(subjectList, subjectTimeList)) {
				List<Subject> clonedSubjectList = createClonedSubjectList(subjectList);
				clonedSubjectList.addAll(toSubjectList(combinationOfSubject, i));
				
				createTimeTableList(timeTableList, clonedSubjectList, combiSubjectList, currentIndex + 1);
			}
		}

		return timeTableList;
	}

	// 기존 데이터 중복 검사
	private boolean isNotReduplicated(List<Subject> subjectList, List<SubjectTime> subjectTimeList) {
		if (CollectionUtils.isEmpty(subjectList)) {
			return true;
		}

		for (Subject subject : subjectList) {
			SubjectTime standardSubjectTime = subject.getSubjectTimeList().get(0);
			for (SubjectTime subjectTime : subjectTimeList) {
				if (isReduplicated(standardSubjectTime, subjectTime)) {
					return false;
				}
			}
		}

		return true;
	}

	// 중복된 요일, 시간 검사
	private boolean isReduplicated(SubjectTime standardSubjectTime, SubjectTime subjectTime) {
		boolean equalDayOfWeek = standardSubjectTime.getDayOfWeek() == subjectTime.getDayOfWeek();
		boolean equalStartTime = standardSubjectTime.getStartTime().equals(subjectTime.getStartTime());
		return equalDayOfWeek && equalStartTime;
	}

	// 과제 목록 복사
	private List<Subject> createClonedSubjectList(List<Subject> subjectList) {
		List<Subject> cloneSubjectList = new ArrayList<>(subjectList.size());

		for (Subject subject : subjectList) {
			Subject clonedSubject = new Subject(subject.getCode(), subject.getName(), subject.getGrade());
			clonedSubject.setSubjectTimeList(subject.getSubjectTimeList());
			cloneSubjectList.add(clonedSubject);
		}

		return cloneSubjectList;
	}

	// CombinationOfSubject에서 List<Subject>로 변경
	private List<Subject> toSubjectList(CombinationOfSubject combiSubject, int selectedIndex) {
		if (ObjectUtils.isEmpty(combiSubject)) {
			throw new DefaultServerException();
		}

		List<Subject> subjectList = new ArrayList<>();
		List<SubjectTime> subjectTimeList = combiSubject.getSubjectTimeList().get(selectedIndex);

		for (SubjectTime subjectTime : subjectTimeList) {
			Subject subject = new Subject(combiSubject.getSubject().getCode(), combiSubject.getSubject().getName(), combiSubject.getSubject().getGrade());
			subject.setSubjectTimeList(Arrays.asList(subjectTime));
			subjectList.add(subject);
		}

		return subjectList;
	}
}
