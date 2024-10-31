<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>스위치온 제품 추천</title>
  
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  
</head>

<body style="margin-top: 100px;">
  
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
      <div class="col col-2" >
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
          <div class="mt-5 h2 text-center">제품 추천</div>
          <ul class="ps-0 d-flex flex-column justify-content-star flex-lg-grow-1">
            <li class="mt-5 mb-5 text-center" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/boardproteinView" style="text-decoration: none;">보충제</a></li>
            <li class="mb-5 text-center" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/boardKetonView" style="text-decoration: none;">저탄수 도시락</a></li>
          </ul>
        </div>
      </div>
      <div class="col col-10">
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
			      
        </div>
      </div>
    </div>
  </div>
  <!-- 상세페이지 -->
  </c:if>
  
</body>
</html>