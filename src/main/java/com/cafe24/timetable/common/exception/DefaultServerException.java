package com.cafe24.timetable.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR, reason = "오류가 발생했습니다.")
public class DefaultServerException extends RuntimeException {
}
