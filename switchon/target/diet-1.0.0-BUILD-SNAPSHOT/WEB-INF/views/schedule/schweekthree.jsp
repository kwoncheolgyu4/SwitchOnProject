<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>스위치온 스케쥴</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body style="margin-top: 100px;">

	<!-- 로그인 정보가 없을 때  -->
	<c:if test="${sessionScope.login == null}">
		<jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
		<!-- 상세페이지 -->
		<div class="container-fluid">
			<div class="row p-3" style="height: 90vh;">
				<div class="col col-1">
					<div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
					</div>
				</div>
				<div class="col col-11">
					<div
						class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
						<p class="text-center">로그인이 필요합니다.</p>
					</div>
				</div>
			</div>
		</div>
		<!-- 상세페이지 -->
	</c:if>
	<!-- 로그인 정보가 없을 때  -->

	<!-- 로그인 정보가 있을 때  -->
	<c:if test="${sessionScope.login != null}">
		<jsp:include page="/WEB-INF/inc/mypage.jsp"></jsp:include>

		<!-- 상세페이지 -->
		<form action="/saveScheduleOne" method="post">

			<div class="container-fluid">
				<div class="row p-3" style="height: 90vh;">
					<div class="col col-1">
						<div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
							<div class="mt-5 h2 text-center"> 일정 <br> 관리 </div>
							<ul class="ps-0 d-flex flex-column justify-content-star flex-lg-grow-1">
								<li class="mt-5 mb-5 text-center active" style="list-style: none;">
								<a class="h3" href="${pageContext.request.contextPath}/scheduleView" style="text-decoration: none;">
								스위치온 생성</a></li>
								<li class="mb-5 text-center active" style="list-style: none;">
								<a class="h3" href="${pageContext.request.contextPath}/schWeekOne" style="text-decoration: none;">
								1주차</a></li>
								<li class="mb-5 text-center" style="list-style: none;">
								<a class="h3" href="${pageContext.request.contextPath}/schWeekTwo" style="text-decoration: none;">
								2주차</a></li>
								<li class="mb-5 text-center" style="list-style: none;">
								<a class="h3" href="${pageContext.request.contextPath}/schWeekThree" style="text-decoration: none;">
								3주차</a></li>
								<li class="mb-5 text-center" style="list-style: none;">
								<a class="h3" href="${pageContext.request.contextPath}/schWeekFour" style="text-decoration: none;">
								4주차</a></li>
							</ul>
						</div>
					</div>
					<div class="col col-11">
						<div
							class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
							<div class="row mt-5 h2 ms-4"> ${week3.scheWeek}주차 일정 관리
								<!-- <button type="submit" class="btn btn-primary ms-auto me-4" style="width: 100px">저장하기</button> -->
								<input type="hidden" name="scheWeek" value="${week3.scheWeek}">
								<input type="hidden" name="scheduleId" value="${week3.scheduleId}">
							</div>
							<div class="row-cols-auto d-flex flex-column justify-content-between h-100 pt-1 pb-1 px-2">
								<!-- 카드로??? -->
								<!-- 각 일차별 일정 관리 -->
								<div class="col-2 border d-flex flex-column gap-3 justify-content-center align-items-center flex-grow-1 w-100 rounded-5 mb-2 bg-success bg-opacity-50">
									<div class="row h-100 mt-3" style="height: 100%; width: 100%;">
										<!-- 상단 -->
										<c:forEach var="day" items="${week3.days}" varStatus="status">
										
											<!-- DayVO의 scheDay와 schedDate 전송 -->
									        <input type="hidden" name="days[${status.index}].scheDay" value="${day.scheDay}">
									        <input type="hidden" name="days[${status.index}].schedDate" value="${day.schedDate}">
																				
											<!-- 1일차 -->
											<div class="col-3 mb-3">
												<div class="card h-100 rounded-5">
													<div class="card-header text-center fw-bold h5">${day.scheDay}일차 (${day.schedDate})</div>
													<div class="card-body">
														<!-- 단식과 식사 선택 옵션 -->
														<div class="input-group mb-3">
															<label class="input-group-text" for="inputMethod">방법</label>
															<select name="days[${status.index}].scheMethod"  class="form-select" id="inputMethod" data-schedDate="${day.schedDate}">
																<option>선택하세요</option>
																<option value="MEAL" ${day.scheMethod eq "MEAL" ? "selected='selected'": ""}>
																	식사
																</option>
																<option value="FAST" ${day.scheMethod eq "FAST" ? "selected='selected'": ""}>
																	단식
																</option>
															</select>
														</div>
														<!-- 단식과 식사 선택 옵션 -->
														<c:if test="${day.scheMethod eq 'MEAL'}">
															<div id="schedTime">
																<c:forEach var="time" items="${day.times}" varStatus="timeStatus">
																    <!-- 첫 번째 그룹: 1번째, 2번째, 3번째 옵션 -->
																    <c:if test="${timeStatus.index == 0}">
																        <div class="input-group mb-2">
																        	<input type="hidden" name="days[${status.index}].times[${timeStatus.index}].scheSeq" value="${time.scheSeq}">
																            <label class="input-group-text" for="schedTime${status.index}">시간</label> 
																            <select class="form-select schedTimeClass" id="schedTime${status.index}" name="days[${status.index}].times[${timeStatus.index}].schedTime" data-scheSeq="${time.scheSeq}">
																                <option value="06:00:00" ${time.schedTime eq "06:00:00" ? "selected='selected'" : ""}>06:00</option>
																                <option value="07:00:00" ${time.schedTime eq "07:00:00" ? "selected='selected'" : ""}>07:00</option>
																                <option value="08:00:00" ${time.schedTime eq "08:00:00" ? "selected='selected'" : ""}>08:00</option>
																            </select>
																        </div>
																    </c:if>
																    
																    <!-- 두 번째 그룹: 4번째, 5번째, 6번째 옵션 -->
																    <c:if test="${timeStatus.index == 1}">
																        <div class="input-group mb-2">
																        	<input type="hidden" name="days[${status.index}].times[${timeStatus.index}].scheSeq" value="${time.scheSeq}">
																            <label class="input-group-text" for="schedTime${status.index}">시간</label> 
																            <select class="form-select schedTimeClass" id="schedTime${status.index}" name="days[${status.index}].times[${timeStatus.index}].schedTime" data-scheSeq="${time.scheSeq}">
																                <option value="11:00:00" ${time.schedTime eq "11:00:00" ? "selected='selected'" : ""}>11:00</option>
																                <option value="12:00:00" ${time.schedTime eq "12:00:00" ? "selected='selected'" : ""}>12:00</option>
																                <option value="13:00:00" ${time.schedTime eq "13:00:00" ? "selected='selected'" : ""}>13:00</option>
																            </select>
																        </div>
																    </c:if>
																
																    <!-- 세 번째 그룹: 7번째, 8번째, 9번째 옵션 -->
																    <c:if test="${timeStatus.index == 2}">
																        <div class="input-group mb-2">
																        	<input type="hidden" name="days[${status.index}].times[${timeStatus.index}].scheSeq" value="${time.scheSeq}">
																            <label class="input-group-text" for="schedTime${status.index}">시간</label> 
																            <select class="form-select schedTimeClass" id="schedTime${status.index}" name="days[${status.index}].times[${timeStatus.index}].schedTime" data-scheSeq="${time.scheSeq}">
																                <option value="16:00:00" ${time.schedTime eq "16:00:00" ? "selected='selected'" : ""}>16:00</option>
																                <option value="17:00:00" ${time.schedTime eq "17:00:00" ? "selected='selected'" : ""}>17:00</option>
																                <option value="18:00:00" ${time.schedTime eq "18:00:00" ? "selected='selected'" : ""}>18:00</option>
																            </select>
																        </div>
																    </c:if>
																
																    <!-- 네 번째 그룹: 10번째, 11번째, 12번째 옵션 -->
																    <c:if test="${timeStatus.index == 3}">
																        <div class="input-group mb-2">
																        	<input type="hidden" name="days[${status.index}].times[${timeStatus.index}].scheSeq" value="${time.scheSeq}">
																            <label class="input-group-text" for="schedTime${status.index}">시간</label> 
																            <select class="form-select schedTimeClass" id="schedTime${status.index}" name="days[${status.index}].times[${timeStatus.index}].schedTime" data-scheSeq="${time.scheSeq}">
																                <option value="20:00:00" ${time.schedTime eq "20:00:00" ? "selected='selected'" : ""}>20:00</option>
																                <option value="21:00:00" ${time.schedTime eq "21:00:00" ? "selected='selected'" : ""}>21:00</option>
																                <option value="22:00:00" ${time.schedTime eq "22:00:00" ? "selected='selected'" : ""}>22:00</option>
																            </select>
																        </div>
																    </c:if>
																</c:forEach>
															</div>
														</c:if>
														<c:if test="${day.scheMethod ne 'MEAL'}">
															<div id="">
																<ul class="list-group">
																	<li class="list-group-item list-group-item-secondary text-center">
																		24시간 단식
																	</li>
																	<li class="list-group-item list-group-item-success">
																		1. 물을 많이 드세요
																	</li>
																	<li class="list-group-item list-group-item-success">
																		2. 가벼운 산책은 지방연소에 도움이 됩니다
																	</li>
																	<li class="list-group-item list-group-item-success">
																		3. 오늘은 저녁만 먹는 날입니다
																	</li>
																</ul>
															</div>
														</c:if>
													</div>
												</div>
											</div>
										</c:forEach>

									</div>
									<!-- 상단 -->

								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</form>
		<!-- 상세페이지 -->
	</c:if>
	<!-- 로그인 정보가 있을 때  -->
	<script>
	
		$(document).ready(function(){
			
			 // 식사/단식 변경 시
	        $(document).on("change", "#inputMethod", function() {
	            var scheduleId = '${week3.scheduleId}';  // scheduleId 값을 가져옴
	            var selectedMethod = $(this).val();      // 선택된 방법 (식사 or 단식)
	            var schedDate = $(this).attr("data-schedDate"); // data-schedDate 속성에서 스케줄 날짜를 가져옴
	            
	            console.log(scheduleId);
	            console.log(selectedMethod);
	            console.log(schedDate);
	            
	            // AJAX 요청으로 업데이트
	            $.ajax({
	                url: '/updateScheduleMethod',   // 서버에서 처리할 경로
	                type: 'POST',                   // 전송 방식
	                contentType: 'application/json; charset=UTF-8',
	                data: JSON.stringify({
	                    scheduleId: scheduleId,
	                    schedDate: schedDate,
	                    scheMethod: selectedMethod
	                }),
	                success: function(response) {
	                    console.log('Method updated successfully');
	                 	// 성공 시 경고창을 띄우고 페이지를 새로고침
	                    alert('변경하였습니다.');
	                    location.reload(); // 페이지 새로고침
	                },
	                error: function(xhr, status, error) {
	                    console.error('Error updating method:', error);
	                }
	            });
	        });
			 
	     	// "schedTimeClass" 클래스를 가진 select 태그에 대해 이벤트 바인딩
	        $(document).on("change", ".schedTimeClass", function() {
	            var scheduleId = '${week3.scheduleId}';  // scheduleId 값
	            var scheSeq = $(this).attr("data-scheSeq"); // data-scheSeq에서 순번 가져옴
	            var schedTime = $(this).val();             // 선택된 시간 값

	            console.log(scheduleId);
	            console.log(scheSeq);
	            console.log(schedTime);
	            
	            
	            // AJAX 요청으로 업데이트
	            $.ajax({
	                url: '/updateScheduleTime',   // 서버에서 처리할 경로
	                type: 'POST',
	                contentType: 'application/json; charset=UTF-8',
	                data: JSON.stringify({
	                    scheduleId: scheduleId,
	                    scheSeq: scheSeq,
	                    schedTime: schedTime
	                }),
	                success: function(response) {
	                    console.log('Time updated successfully');
	                 	// 성공 시 경고창을 띄우고 페이지를 새로고침
	                    alert('변경하였습니다.');
	                    location.reload(); // 페이지 새로고침
	                 
	                },
	                error: function(xhr, status, error) {
	                    console.error('Error updating time:', error);
	                }
	            });
	        });
			 
		
		});
		
	
	</script>

</body>
</html>