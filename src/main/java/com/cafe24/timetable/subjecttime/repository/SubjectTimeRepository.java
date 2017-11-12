package com.cafe24.timetable.subjecttime.repository;

import com.cafe24.timetable.subjecttime.domain.SubjectTime;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectTimeRepository {

	private static final String PREFIX = "subjectTimeMapper.";

	@Autowired
	private SqlSession sqlSession;

	public List<SubjectTime> selectBySubjectCode(String subjectCode) {
		return sqlSession.selectList(PREFIX + "selectBySubjectCode", subjectCode);
	}
}
