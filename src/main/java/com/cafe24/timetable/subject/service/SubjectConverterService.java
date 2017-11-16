package com.cafe24.timetable.subject.service;

import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import com.cafe24.timetable.timetable.domain.CombinationOfSubject;

import java.util.List;

public interface SubjectConverterService {

	List<SubjectTime> toSubjectTimeList(List<Subject> subjectList);
	List<CombinationOfSubject> toCombinationOfSubjectList(List<Subject> subjectList);
}
