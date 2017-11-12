package com.cafe24.timetable.subject.web;

import com.cafe24.timetable.common.exception.DefaultMissingParamException;
import com.cafe24.timetable.common.util.Cafe24Utils;
import com.cafe24.timetable.subject.domain.Subject;
import com.cafe24.timetable.subject.service.SubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("subject")
@RestController
public class SubjectController {

	@Autowired
	private SubjectService service;

	@GetMapping
	public List<Subject> findList(@RequestParam("keyword") String keyword) {
		if (Cafe24Utils.isSqlInjection(keyword)) {
			throw new DefaultMissingParamException();
		}

		return service.findByStartWithCode(keyword);
	}
}
