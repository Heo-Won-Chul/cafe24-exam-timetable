package com.cafe24.timetable.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "이수 가능 학점은 18학점 이상, 21학점 이하 입니다.")
public class OutOfRangeGradesException extends RuntimeException {
}
