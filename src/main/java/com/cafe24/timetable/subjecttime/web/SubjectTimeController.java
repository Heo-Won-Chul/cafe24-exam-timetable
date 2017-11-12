package com.cafe24.timetable.subjecttime.web;

import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import com.cafe24.timetable.subjecttime.repository.SubjectTimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("subjecttime")
@RestController
public class SubjectTimeController {

	@Autowired
	private SubjectTimeRepository repository;

	@GetMapping
	public List<SubjectTime> findAll(@RequestParam("subjectCode") String subjectCode) {
		return repository.selectBySubjectCode(subjectCode);
	}
}
