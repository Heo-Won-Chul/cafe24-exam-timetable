package com.cafe24.timetable.subject.service;

import com.cafe24.timetable.common.exception.DefaultMissingParamException;
import com.cafe24.timetable.common.exception.DefaultServerException;
import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.subject.repository.SubjectRepository;
import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import com.cafe24.timetable.subjecttime.service.SubjectTimeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class DefaultSubjectService implements SubjectService {

	@Autowired
	private SubjectRepository repository;

	@Autowired
	private SubjectTimeService subjectTimeService;

	@Override
	public List<Subject> findByStartWithCode(String code) {
		if (StringUtils.isEmpty(code)) {
			throw new DefaultMissingParamException();
		}

		return repository.selectByStartWithCode(code);
	}

	@Override
	public Subject findByCode(String code) {
		if (StringUtils.isEmpty(code)) {
			throw new DefaultMissingParamException();
		}

		return repository.selectByCode(code);
	}

	// 과목 목록에 과목, 과목 일정 추가
	@Override
	public List<Subject> addSubjectTimeList(List<Subject> subjectList) {
		if (CollectionUtils.isEmpty(subjectList)) {
			throw new DefaultServerException();
		}

		for (int i = 0; i < subjectList.size(); i++) {
			Subject selectedSubject = findByCode(subjectList.get(i).getCode());
			Subject updatedSubject = addSubjectTime(selectedSubject);
			subjectList.set(i, updatedSubject);
		}

		return subjectList;
	}

	// 과목에 과목 일정 추가
	@Override
	public Subject addSubjectTime(Subject subject) {
		if (ObjectUtils.isEmpty(subject)) {
			throw new DefaultServerException();
		}

		List<SubjectTime> subjectTimeList = subjectTimeService.findBySubjectCode(subject.getCode());
		subject.setSubjectTimeList(subjectTimeList);
		return subject;
	}

	@Override
	public boolean isNotReduplicated(List<Subject> subjectList, List<SubjectTime> subjectTimeList) {
		if (CollectionUtils.isEmpty(subjectList)) {
			return true;
		}

		for (Subject subject : subjectList) {
			SubjectTime standardSubjectTime = subject.findSubjectTimeByIndex(0);
			for (SubjectTime subjectTime : subjectTimeList) {
				if (standardSubjectTime.isReduplicated(subjectTime)) {
					return false;
				}
			}
		}

		return true;
	}

	@Override
	public List<Subject> findClonedList(List<Subject> subjectList) {
		List<Subject> cloneList = new ArrayList<>(subjectList.size());

		for (Subject subject : subjectList) {
			Subject cloneSubject = subject.clone();
			cloneList.add(cloneSubject);
		}

		return cloneList;
	}
}
