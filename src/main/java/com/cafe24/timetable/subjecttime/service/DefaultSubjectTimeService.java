package com.cafe24.timetable.subjecttime.service;

import com.cafe24.timetable.common.exception.DefaultMissingParamException;
import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import com.cafe24.timetable.subjecttime.repository.SubjectTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class DefaultSubjectTimeService implements SubjectTimeService {

	@Autowired
	private SubjectTimeRepository repository;

	@Override
	public List<SubjectTime> findBySubjectCode(String subjectCode) {
		if (StringUtils.isEmpty(subjectCode)) {
			throw new DefaultMissingParamException();
		}

		return repository.selectBySubjectCode(subjectCode);
	}
}

