<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>시간표 자동 생성</title>

	<!-- common css -->
	<link href="webjars/fullcalendar/2.7.3/fullcalendar.min.css" rel="stylesheet">
	<link href="webjars/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
	<link href="css/index.css?v=20171112" rel="stylesheet">
	<!-- //common css -->

	<!-- common javascript -->
	<script src="webjars/momentjs/2.5.0/min/moment.min.js"></script>
	<script src="webjars/jquery/1.11.1/jquery.min.js"></script>
	<script src="webjars/fullcalendar/2.7.3/fullcalendar.js"></script>
	<script src="webjars/fullcalendar/2.7.3/lang/ko.js"></script>
	<script src="webjars/bootstrap/3.3.5/js/bootstrap.min.js"></script>
	<script src="webjars/bootstrap-3-typeahead/4.0.0/bootstrap3-typeahead.min.js"></script>
	<!-- //common javascript -->
</head>
<body>
<div class="container">
	<!-- timetable -->
	<div class="timetable-area">
		<!-- timetable-header -->
		<div class="timetable-header">
			<div class="timetable-title">
				<p class="text-center"><b>시간표 자동 생성</b></p>
				<p class="text-right"><span id="position-of-size">0/0</span></p>
			</div>
		</div>
		<!-- //timetable-header -->

		<!-- timetable-body -->
		<div id="timetable" class="timetable-body"></div>
		<!-- //timetable-body -->

		<!-- timetable-footer -->
		<div class="timetable-footer">
			<form class="form row" id="form-timetable">
				<div class="col-md-3">
					<label for="input-department" class="sr-only">학과 선택</label>
					<input type="text" id="input-department" class="form-control" data-provide="typeahead" placeholder="학과를 입력하세요" autocomplete="off"/>
				</div>
				<div class="col-md-6">
					<label for="select-subject-list" class="sr-only">과목 선택</label>
					<select id="select-subject-list" class="form-control" multiple></select>

					<p class="text-right">(이수 가능 학점은 18학점 이상, 21학점 이하 입니다.)</p>
					<p class="text-right">과목 갯수:&nbsp;<span id="span-count-grades">0</span>개</p>
					<p class="text-right">이수 학점:&nbsp;<span id="span-sum-grades">0/21</span>점</p>
				</div>
				<div class="col-md-3">
					<input type="button" id="btn-reset" class="form-control btn btn-default" value="초기화">
					<p></p>
					<input type="button" id="btn-submit" class="form-control btn btn-primary disabled" disabled value="생성">
				</div>
			</form>
		</div>
		<!-- //timetable-footer -->
	</div>
	<!-- //timetable -->
</div>
</body>
<!-- custom javascript-->
<script src="js/welAjax.js?v=20171112"></script>
<script src="js/stringBuilder.js?v=20171112"></script>
<script src="js/timetable.js?v=20171112"></script>
<script src="js/index.js?v=20171112"></script>
<!-- //custom javascript -->
</html>