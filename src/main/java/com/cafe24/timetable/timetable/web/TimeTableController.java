package com.cafe24.timetable.timetable.web;

import com.cafe24.timetable.common.exception.OutOfRangeGradesException;
import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.timetable.service.CreatingTimeTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("timetable")
@RestController
public class TimeTableController {

	@Autowired
	private CreatingTimeTableService service;

	private static final int LIMIT_COUNT = 21;

	@PostMapping
	public List<List<Subject>> create(@RequestBody List<Subject> subjectList) {
		if (CollectionUtils.isEmpty(subjectList) || subjectList.size() > LIMIT_COUNT) {
			throw new OutOfRangeGradesException();
		}

		return service.create(subjectList);
	}
}
