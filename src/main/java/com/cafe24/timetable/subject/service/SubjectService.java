package com.cafe24.timetable.subject.service;

import com.cafe24.timetable.subject.domain.Subject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SubjectService {

	List<Subject> findByStartWithCode(String code);
	Subject findByCode(String code);

	List<Subject> addSubjectTimeList(List<Subject> subjectList);
	Subject addSubjectTime(Subject subject);

	boolean isOutOfRange(List<Subject> subjectList);


}
