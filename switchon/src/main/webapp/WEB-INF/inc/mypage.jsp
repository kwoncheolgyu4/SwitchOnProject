<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>

<!-- 네비게이션 바 -->
<nav class="navbar navbar-light nav-pills fixed-top bg-primary bg-opacity-10" style="height: 100px;">
  <div class="container-fluid">
    <a class="navbar-brand ms-3" href="${pageContext.request.contextPath}/"><span class="fs-2 fw-bold text-primary text-opacity-50">스위치온</span></a>
    
    <ul class="nav ms-auto justify-content-between" style="width: 40rem;">
      <li class="nav-item">
        <a href="${pageContext.request.contextPath}/scheduleView" class="nav-link fs-3">일정 관리</a>
      </li>
      <li class="nav-item">
        <a href="${pageContext.request.contextPath}/weightView" class="nav-link fs-3">체중 관리</a>
      </li>
      <li class="nav-item">
        <a href="${pageContext.request.contextPath}/boardView" class="nav-link fs-3">제품 추천</a>
      </li>
    </ul>
    
    <button class="navbar-toggler ms-auto rounded-pill text-bg-primary fw-bold bg-opacity-50" style="height: 60px;" type="button">
		${sessionScope.login.memNm}님
    </button>
    
    <button class="navbar-toggler ms-3 me-3 rounded-pill text-bg-primary fw-bold bg-opacity-50" style="width: 140px; height: 60px;" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar3" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
		마이페이지
    </button>

      <!-- 마이페이지 -->
    <div class="offcanvas offcanvas-end w-25" tabindex="-1" id="offcanvasNavbar3" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">마이페이지</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <form class="offcanvas-body" action="<c:url value="/updateMember" />" method="post">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">

          <li class="nav-item"> <!-- 아이디 -->
            <div class="form-floating">
              <input type="text" id="mypageId" name="memId" class="form-control" value="${sessionScope.login.memId}" placeholder="" disabled>
              <label for="mypageid">아이디</label>
            </div>
          </li>

          <li class="nav-item mt-3"> <!-- 이름 -->
            <div class="form-floating">
              <input type="text" id="mypageNm" name="memNm" class="form-control"  value="${sessionScope.login.memNm}" placeholder="">
              <label for="mypageNm">이름</label>
            </div>
          </li>

        </ul>
        <div class="d-flex mt-3" >
        	<button class="btn btn-primary ms-auto me-3" type="submit">수정</button>
         	<button class="btn btn-primary me-3" data-bs-dismiss="offcanvas" type="button">확인</button>
           	<button class="btn btn-primary me-3" type="button" onclick="location.href='${pageContext.request.contextPath}/logoutDo'">로그아웃</button>
        </div>
      </form>
    </div>
    <!-- 마이페이지 -->
  </div>
</nav>

