package com.cafe24.timetable.timetable.service;

import com.cafe24.timetable.subject.domain.Subject;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface CreatingTimeTableService {

	List<List<Subject>> create(List<Subject> subjectList);
}
