<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>스위치온 메인</title>
</head>

<body style="margin-top: 100px;">
  
  <c:if test="${sessionScope.login == null}">
  <jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
  </c:if>
  
  <c:if test="${sessionScope.login != null}">
  <jsp:include page="/WEB-INF/inc/mypage.jsp"></jsp:include>
  </c:if>
  
  <!-- 메인 -->
  <div class="container-fluid">
    <div class="row p-3" id="body_id" style="height: 90vh;">
      <div class="col col-4" >
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
          <div class="mt-5 h2 ms-4 fs-2 fw-bold text-primary text-opacity-50">일정 관리</div>
          <ul class="d-flex flex-column justify-content-start flex-lg-grow-1">
          	<li class="mt-5 mb-5 fs-2 fw-bold text-success text-opacity-50" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/scheduleView" style="text-decoration: none;">스위치온 생성</a></li>
            <li class="mb-5 fs-2 fw-bold text-success text-opacity-50" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/schWeekOne" style="text-decoration: none;">1주차</a></li>
            <li class="mb-5 fs-2 fw-bold text-success text-opacity-50" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/schWeekTwo" style="text-decoration: none;">2주차</a></li>
            <li class="mb-5 fs-2 fw-bold text-success text-opacity-50" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/schWeekThree" style="text-decoration: none;">3주차</a></li>
            <li class="mb-5 fs-2 fw-bold text-success text-opacity-50" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/schWeekFour" style="text-decoration: none;">4주차</a></li>
          </ul>
        </div>
      </div>
      <div class="col col-4">
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
          <div class="mt-5 h2 ms-4 fs-2 fw-bold text-primary text-opacity-50">체중 관리</div>
          <ul class="d-flex flex-column justify-content-start flex-lg-grow-1">
            <li class="mt-5 mb-5 fs-2 fw-bold text-success text-opacity-50" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/weightschedule" style="text-decoration: none;">체중기록</a></li>
          </ul>
        </div>
      </div>
      <div class="col col-4">
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
          <div class="mt-5 h2 ms-4 fs-2 fw-bold text-primary text-opacity-50">제품 추천</div>
          <ul class="d-flex flex-column justify-content-start flex-lg-grow-1">
            <li class="mt-5 mb-5 fs-2 fw-bold text-success text-opacity-50" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/boardproteinView" style="text-decoration: none;">보충제</a></li>
            <li class="mb-5 fs-2 fw-bold text-success text-opacity-50" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/boardKetonView" style="text-decoration: none;">저탄수 도시락</a></li>
          </ul>
        </div>
      </div>
    </div>
  </div>
  <!-- 메인 -->
  <script>
	 $(document).ready(function(){
			 
			$("#body_id").on("click","a", function(e){
				e.preventDefault();
				var memId = '${sessionScope.login.memId}';
				console.log($(this));
				console.log(memId);
				if(memId == ''){
					alert("로그인 해주세요");
					return;
				}else{
					location.href ='${pageContext.request.contextPath}' + $(this).attr('href');
				}
			});
	 });
  
  </script>
</body>
</html>