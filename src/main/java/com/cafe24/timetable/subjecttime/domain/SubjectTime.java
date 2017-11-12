package com.cafe24.timetable.subjecttime.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public class SubjectTime {

	private long seq;
	private int dayOfWeek;
	@JsonFormat(pattern = "HH:mm")
	private LocalTime startTime;
	@JsonFormat(pattern = "HH:mm")
	private LocalTime endTime;

	public SubjectTime() {}

	public SubjectTime(long seq, int dayOfWeek, LocalTime startTime, LocalTime endTime) {
		this.seq = seq;
		this.dayOfWeek = dayOfWeek;
		this.startTime = startTime;
		this.endTime = endTime;
	}

	public long getSeq() {
		return seq;
	}

	public void setSeq(long seq) {
		this.seq = seq;
	}

	public int getDayOfWeek() {
		return dayOfWeek;
	}

	public void setDayOfWeek(int dayOfWeek) {
		this.dayOfWeek = dayOfWeek;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	@Override
	public String toString() {
		return "SubjectTime{" +
				"seq=" + seq +
				", dayOfWeek=" + dayOfWeek +
				", startTime=" + startTime +
				", endTime=" + endTime +
				'}';
	}
}
