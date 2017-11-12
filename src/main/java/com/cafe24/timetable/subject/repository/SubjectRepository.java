package com.cafe24.timetable.subject.repository;

import com.cafe24.timetable.subject.domain.Subject;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SubjectRepository {

	private static final String PREFIX = "subjectMapper.";

	@Autowired
	private SqlSession sqlSession;

	public List<Subject> selectByStartWithCode(String code) {
		return sqlSession.selectList(PREFIX + "selectByStartWithCode", code);
	}

	public Subject selectByCode(String code) {
		return sqlSession.selectOne(PREFIX + "selectByCode", code);
	}
}
