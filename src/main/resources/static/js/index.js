// dom 객체
const welTimeTable = $('#timetable');
const welPositionOfSize = $('#position-of-size');
const welInputDepartment = $('#input-department');
const welSelectSubjectList = $('#select-subject-list');
const welFormTimeTable = $('#form-timetable');
const welSpanCountGrades = $('#span-count-grades');
const welSpanSumGrades = $('#span-sum-grades');
const welBtnSubmit = $('#btn-submit');
const welBtnReset = $('#btn-reset');

const MIN_SUM_GRADES = 18;
const MAX_SUM_GRADES = 21;
const THREE_GRADE = 3;
const THREE_GRADE_COLOR = '#38ADC1';
const DEPARTMENT_ARRAY = [
	{
		id: 'COM',
		name: '컴퓨터공학과'
	}
];

const oTimetable = new TimeTable();

// FullCalendar 생성
$(document).ready(() => {
	createFullCalendar();
});

// form submit 차단
welFormTimeTable.submit((e) => {
	e.preventDefault();
});

// typeahead 활성화
welInputDepartment.typeahead({
	source: DEPARTMENT_ARRAY
});

// 자동 완성시, 과목 목록 가져오기
welInputDepartment.change(() => {
	let oSelectedDepartment = welInputDepartment.typeahead("getActive");

	if (oSelectedDepartment === undefined) {
		return;
	}

	if (oSelectedDepartment.name === welInputDepartment.val()) {
		createSubjectList(oSelectedDepartment);
	}
});

// 과목 목록 가져오기
const createSubjectList = (oSubject) => {
	welAjax.getCall(`subject?keyword=${oSubject.id}`, (oResponse) => {
		if (oResponse === undefined) {
			return;
		}

		let oSb = new StringBuilder();
		for (let oSubject of oResponse) {
			oSb.append(`<option value="${oSubject.code}" grade="${oSubject.grade}">${oSubject.name} (${oSubject.grade}학점)</option>`);
		}
		welSelectSubjectList.html(oSb.toString());
	});
};

// 초기화
welBtnReset.click(() => {
	welInputDepartment.val('');
	welSelectSubjectList.empty();
	welSpanCountGrades.html('0');
	welSpanSumGrades.html('0/21');
});

// 시간표 자동 생성
welBtnSubmit.click(() => {
	let aSelectedCode = welSelectSubjectList.val();

	let aSubject = [];
	for (let sCode of aSelectedCode) {
		aSubject.push({
			code: sCode
		});
	}

	welAjax.postCall('timetable', aSubject, (aResponse) => {
		if (aResponse === undefined) {
			return;
		}

		oTimetable.setData(aResponse);
		updateEvent();
	});
});

// 과목 선택 시, UI 재갱신(이수 학점, 과목 갯수, 버튼 활성화)
welSelectSubjectList.change(() => {
	let aSelectedCode = welSelectSubjectList.val();
	let nSumGrades = 0;
	for (let sCode of aSelectedCode) {
		nSumGrades += Number(welSelectSubjectList.find(`option[value='${sCode}']`).attr('grade'));
	}

	welSpanCountGrades.html(aSelectedCode.length);
	welSpanSumGrades.html(`${nSumGrades}/21`);

	if (nSumGrades < MIN_SUM_GRADES || nSumGrades > MAX_SUM_GRADES) {
		welBtnSubmit.addClass('disabled');
		welBtnSubmit.attr('disabled');
	} else {
		welBtnSubmit.removeClass('disabled');
		welBtnSubmit.removeAttr('disabled');
	}
});

// FullCalendar 생성
const createFullCalendar = () => {
	welTimeTable.fullCalendar({
		customButtons: {
			preTimeTable: {
				text: '이전',
				click: () => {
					if (oTimetable.isEmpty()) {
						return;
					}

					oTimetable.decrement();
					updateEvent();
				}
			},
			nextTimeTable: {
				text: '다음',
				click: () => {
					if (oTimetable.isEmpty()) {
						return;
					}

					oTimetable.increment();
					updateEvent();
				}
			}
		},
		height: 'auto', // 크기 조절 (parent, auto, Number)
		defaultView: 'agendaWeek', // 주간
		editable: false, // 수정 불가능
		header: {
			left: false,
			center: false,
			right: 'preTimeTable, nextTimeTable'
		},
		allDaySlot: false, // all-day 표기 삭제
		slotDuration: '01:00:00', // 1시간 간격
		weekends: false, // 주말 삭제
		minTime: '09:00:00', // 최소 표기 시간
		maxTime: '17:00:00', // 최대 표기 시간
		slotLabelFormat: 'hh시', //  간격 포맷
		timeFormat: 'HH', // event 시간 포맷
		columnFormat: 'ddd', // 월, 화, 수, ...
		eventRender: (event, element, view) => {
			convertByFcTime(event, element);
		}
	});
};

// FullCalendar event 재갱신
const updateEvent = () => {
	welTimeTable.fullCalendar('removeEvents');
	welTimeTable.fullCalendar('addEventSource', toEvents(oTimetable.current()));
	welPositionOfSize.html(oTimetable.format());
};

// data를 event로 변경
const toEvents = (aData) => {
	if (aData === undefined) {
		return;
	}

	let aEvent = [];
	for (let oData of aData) {
		let oEvent = {};
		oEvent.title = oData.name;
		oEvent.start = toTime(oData.subjectTimeList[0].dayOfWeek, oData.subjectTimeList[0].startTime);
		oEvent.end = toTime(oData.subjectTimeList[0].dayOfWeek, oData.subjectTimeList[0].endTime);
		if (oData.grade === THREE_GRADE) {
			oEvent.backgroundColor = THREE_GRADE_COLOR;
			oEvent.borderColor = THREE_GRADE_COLOR;
		}
		aEvent.push(oEvent);
	}
	return aEvent;
};

// 요일과 시간을 기준으로 날짜 변경
const toTime = (nDayOfWeek, sTime) => {
	let dNowDate = moment().hours(0).minutes(0).seconds(0).milliseconds(0);
	let nTime = Number(moment(sTime, 'HH:mm').format('H'));
	let nCurrentDayOfWeek = Number(moment(dNowDate).format('e'));
	return dNowDate.subtract(nCurrentDayOfWeek, 'd').add(nDayOfWeek, 'd').add(nTime, 'h');
};

// 시간을 기준으로 N/N+1 교시로 변경
const convertByFcTime = (event, element) => {
	let oStartTime = moment(event.start);
	let timeFormat = Number(oStartTime.subtract(8, 'h').format('H'));
	element.find('.fc-time').html(`<span>${timeFormat}/${timeFormat + 1} 교시</span>`);
};