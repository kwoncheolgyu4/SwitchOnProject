<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>스위치온 스케쥴베이스</title>
</head>

<body style="margin-top: 100px;">
  
  <!-- 메시지를 표시하는 알림 -->
  <c:if test="${not empty message}">
    <script>
      alert("${message}");
    </script>
  </c:if>
  
  <c:if test="${not empty errorMessage}">
    <script>
      alert("${errorMessage}");
    </script>
  </c:if>
  
  <c:if test="${sessionScope.login == null}">
  <jsp:include page="/WEB-INF/inc/top.jsp"></jsp:include>
  
  <!-- 상세페이지 -->
  <div class="container-fluid">
    <div class="row p-3" style="height: 90vh;">
      <div class="col col-1" >
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
          
        </div>
      </div>
      <div class="col col-11">
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
          <p class="text-center">로그인이 필요합니다.</p>
        </div>
      </div>
    </div>
  </div>
  <!-- 상세페이지 -->
  </c:if>
  
  <c:if test="${sessionScope.login != null}">
  <jsp:include page="/WEB-INF/inc/mypage.jsp"></jsp:include>
  
  <!-- 상세페이지 -->
  <div class="container-fluid">
    <div class="row p-3" style="height: 90vh;">
      <div class="col col-1" >
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
          <div class="mt-5 h2 text-center">일정<br>관리</div>
          <ul class="ps-0 d-flex flex-column justify-content-star flex-lg-grow-1">
          	<li class="mt-5 mb-5 text-center" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/scheduleView" style="text-decoration: none;">스위치온 생성</a></li>
            <li class="mb-5 text-center" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/schWeekOne" style="text-decoration: none;">1주차</a></li>
            <li class="mb-5 text-center" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/schWeekTwo" style="text-decoration: none;">2주차</a></li>
            <li class="mb-5 text-center" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/schWeekThree" style="text-decoration: none;">3주차</a></li>
            <li class="mb-5 text-center" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/schWeekFour" style="text-decoration: none;">4주차</a></li>
          </ul>
        </div>
      </div>
      <div class="col col-11">
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column align-items-center">
          
          <!-- 입력 폼 -->
          <h2 class="text-center mt-5">스케쥴 생성</h2>
          <form class="d-grid w-25" action="${pageContext.request.contextPath}/scheduleViewDo" method="post">
            <div class="mb-3">
              <label for="memId" class="form-label">사용자 ID</label>
              <input type="text" class="form-control" id="memId" name="memId" value="${sessionScope.login.memId}" readonly>
            </div>
            
            <div class="mb-3">
              <label for="createDt" class="form-label">생성 날짜</label>
              <input type="date" class="form-control" id="createDt" name="createDt" required>
            </div>
            
            <div class="mb-3">
              <label for="useYn" class="form-label">사용 여부</label>
              <select class="form-select" id="useYn" name="useYn" required>
                <option value="Y">사용</option>
                <option value="N">미사용</option>
              </select>
            </div>

            <button type="submit" class="btn btn-primary">스케쥴 생성</button>
          </form>
          <!-- 입력 폼 끝 -->
          
          <!-- 카카오 로그인 -->
          <form class="d-grid w-25 mt-3 g-2">
            <a class="btn btn-warning" href="https://kauth.kakao.com/oauth/authorize?client_id=d304b0d6951e3b4f130b2898ef0e1acd&redirect_uri=http://localhost:8080/kakaologin&response_type=code">카카오 로그인</a>
          </form>
          <form class="d-grid w-25 mt-3 g-2">
          	<a class="btn btn-warning" href="/logout">카카오 로그아웃</a>
          </form>
          <!-- 카카오 로그인 -->
          
          <!-- 알람 실행 -->
          <form class="d-grid w-25 mt-3 g-2" action="/startAlarm" method="post">
          	<button type="submit" class="btn btn-primary">알람 시작</button>
          </form>
          <form class="d-grid w-25 mt-3 g-2" action="/stopAlarm" method="post">
            <button type="submit" class="btn btn-primary">알람 중지</button>
          </form>
          <!-- 알람 실행 -->
          
        </div>
      </div>
    </div>
  </div>
  <!-- 상세페이지 -->
  </c:if>
  
  	<c:if test="${not empty alertMessage}">
	    <script>
	        alert("${alertMessage}");
	    </script>
	</c:if>
  
  <script>
  
	  document.getElementById('scheduleForm').onsubmit = function() {
		    const createDt = document.getElementById('createDt').value;
		    const useYn = document.getElementById('useYn').value;
		    
		    if (!createDt) {
		        alert('생성 날짜를 입력하세요.');
		        return false;
		    }
		    
		    if (!useYn) {
		        alert('사용 여부를 선택하세요.');
		        return false;
		    }
	
		    return true;
		};
  
		
		
  </script>
  
</body>
</html>