<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>스위치온 메인</title>
  <!-- 부트스트랩 -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
    integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
    integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<!-- 제이쿼리 -->
<script src="https://code.jquery.com/jquery-3.7.1.js"></script>
</head>

<body style="margin-top: 100px;">
  
  <!-- 메인 -->
  <div class="container-fluid">
    <div class="row p-3" style="height: 90vh;">
      <div class="col col-12" >
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
          <div class="mt-5 h2 ms-4 fs-2 fw-bold text-primary text-opacity-50">로그인</div>
          
          	<form action="/testloginDo" method="post">
			  <div class="mb-3">
			    <label for="exampleInputEmail1" class="form-label">이름</label>
			    <input type="text" class="form-control" id="exampleInputEmail1" name="testNm" value="${sessionScope.testlogin.testNm}" aria-describedby="emailHelp">
			  </div>
			  <button type="submit" class="btn btn-primary">Submit</button>
			</form>
          	
        </div>
      </div>
    </div>
  </div>
  <!-- 메인 -->
</body>
</html>