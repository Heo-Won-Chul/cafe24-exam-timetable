package com.cafe24.timetable.subjecttime.service;

import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface SubjectTimeService {

	List<SubjectTime> findBySubjectCode(String subjectCode);
}
