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

<style>

	.error{
		color:red; font-size:0.9em;
	}

</style>


<!-- 네비게이션 바 -->
<nav class="navbar navbar-light fixed-top bg-primary bg-opacity-10" style="height: 100px;">
  <div class="container-fluid">
    <a class="navbar-brand ms-3" href="${pageContext.request.contextPath}/"><span class="fs-2 fw-bold text-primary text-opacity-50">스위치온</span></a>
    <button class="navbar-toggler ms-auto rounded-pill text-bg-primary fw-bold bg-opacity-50" style="width: 120px; height: 60px;" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar1" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
    	로그인
    </button>

    <button class="navbar-toggler ms-3 me-3 rounded-pill text-bg-primary fw-bold bg-opacity-50" style="width: 120px; height: 60px;" type="button" data-bs-toggle="offcanvas" data-bs-target="#offcanvasNavbar2" aria-controls="offcanvasNavbar" aria-label="Toggle navigation">
		회원가입
    </button>

    <!-- 로그인 -->
    <div class="offcanvas offcanvas-end w-25" tabindex="-1" id="offcanvasNavbar1" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">로그인</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <form:form modelAttribute="member" class="offcanvas-body" action="/loginDo" method="post">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3">

          <li class="nav-item"> <!-- 아이디 -->
            <div class="form-floating">
              <form:input path="memId" type="text" name="memId" id="loginid" value="${cookie.rememberId.value}" class="form-control" placeholder=""></form:input>
              <form:errors path="memId" cssClass="error" />
              <label for="loginid">아이디</label>
            </div>
          </li>
          <li class="nav-item mt-3"> <!-- 비밀번호 -->
            <div class="form-floating">
              <form:input path="memPw" type="password" name="memPw" id="loginpw" class="form-control" placeholder=""/>
              <form:errors path="memPw" cssClass="error" />
              <label for="loginpw">비밀번호</label>
            </div>
          </li>
        </ul>

        <div class="d-flex mt-3" >
		<!-- 아이디 기억하기 -->
	        <div class="form-floating mb-3">
	        	<input ${cookie.rememberId.value == null ? "" : "checked" } type="checkbox" class="form-check-input" name="remember"> 아이디 기억하기
	        </div>
	        <button class="btn btn-primary ms-auto me-3" type="submit">확인</button>
	        <button class="btn btn-primary me-3" data-bs-dismiss="offcanvas" type="button">닫기</button>
        </div>
      </form:form>
    </div>
    <!-- 로그인 -->
    
    <!-- 회원가입 -->
    <div class="offcanvas offcanvas-end w-25" tabindex="-1" id="offcanvasNavbar2" aria-labelledby="offcanvasNavbarLabel">
      <div class="offcanvas-header">
        <h5 class="offcanvas-title" id="offcanvasNavbarLabel">회원가입</h5>
        <button type="button" class="btn-close" data-bs-dismiss="offcanvas" aria-label="Close"></button>
      </div>
      <form:form modelAttribute="member" class="offcanvas-body" action="/Do" method="post">
        <ul class="navbar-nav justify-content-end flex-grow-1 pe-3 gap-2">
          <li class="nav-item">
            <div class="form-floating"> <!-- 아이디 -->
              <form:input path="memId" type="text" id="memId" name="memId" class="form-control" placeholder="" />
              <form:errors path="memId" cssClass="error" />
              <label for="memId">아이디</label>
            </div>
          </li>
          <li class="nav-item">
            <div class="form-floating"> <!-- 비밀번호 -->
              <form:input path="memPw" type="password" id="memPw" name="memPw" class="form-control" placeholder="" />
              <form:errors path="memPw" cssClass="error" />
              <label for="memPw">비밀번호</label>
            </div>
          </li>
          <li class="nav-item">
            <div class="form-floating"> <!-- 이름 -->
              <form:input path="memNm" type="text" id="memNm" name="memNm" class="form-control" placeholder="" />
              <form:errors path="memNm" cssClass="error" />
              <label for="memNm">이름</label>
            </div>
          </li>
        </ul>
        <div class="d-flex mt-3">
          <button class="btn btn-primary ms-auto me-3" type="submit">가입</button>
          <button class="btn btn-primary me-3" data-bs-dismiss="offcanvas" type="button">돌아가기</button>
        </div>
      </form:form>
      
    </div>
    <!-- 회원가입 -->
  </div>
</nav>

		<!-- message Modal -->
		<div class="modal fade" id="messageModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
		  <div class="modal-dialog">
		    <div class="modal-content">
		      <div class="modal-header">
		        <h1 class="modal-title fs-5" id="exampleModalLabel">${messageVO.title}</h1>
		        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		      </div>
			      <div class="modal-body">
	                     <!-- message -->
	                     <div class="mb-3">
	                         <label for="title">${messageVO.message}</label>
	                     </div>
	                     <a href="<c:url value='${messageVO.url}' />" >
	                     	${messageVO.urlTitle}
	                     </a>
			      </div>
			      <div class="modal-footer">
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			      </div>
		    </div>
		  </div>
		</div>

	<script>
	
		$(document).ready(function(){
			var message = "${messageVO.message}";
			if(message != ''){
				$("#messageModal").modal('show');
			}
		});
		
		
	</script>