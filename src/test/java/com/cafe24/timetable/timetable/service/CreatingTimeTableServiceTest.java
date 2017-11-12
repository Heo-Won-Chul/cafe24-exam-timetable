package com.cafe24.timetable.timetable.service;

import com.cafe24.timetable.common.exception.OutOfRangeGradesException;
import com.cafe24.timetable.subject.domain.Subject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CreatingTimeTableServiceTest {

	@Autowired
	private CreatingTimeTableService service;

	@Test
	public void successTimeTable() throws Exception {
		List<Subject> selectedSubjectList = Arrays.asList(
				new Subject("COM_A"),
				new Subject("COM_C"),
				new Subject("COM_D"),
				new Subject("COM_G"),
				new Subject("COM_H"),
				new Subject("COM_K"),
				new Subject("COM_O")
		);
		assertThat(service.create(selectedSubjectList)).isNotEmpty();
	}

	@Test(expected = OutOfRangeGradesException.class)
	public void outOfRangeGradesTimeTable() throws Exception {
		List<Subject> selectedSubjectList = Arrays.asList(
				new Subject("COM_A"),
				new Subject("COM_C"),
				new Subject("COM_D"),
				new Subject("COM_G"),
				new Subject("COM_H"),
				new Subject("COM_K")
		);
		assertThat(service.create(selectedSubjectList)).isEmpty();
		assertThat(service.create(Collections.emptyList())).isEmpty();
	}
}