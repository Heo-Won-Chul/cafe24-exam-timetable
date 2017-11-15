package com.cafe24.timetable.timetable.service;

import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.timetable.domain.CombinationOfSubject;

import java.util.List;

public interface CombinationOfSubjectService {

	List<CombinationOfSubject> toCombinationOfSubjectList(List<Subject> subjectList);
}
