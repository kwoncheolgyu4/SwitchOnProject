<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>스위치온 체중관리</title>
  
  <script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  
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
          <div class="mt-5 h2 text-center">체중 관리</div>
          <ul class="ps-0 d-flex flex-column justify-content-star flex-lg-grow-1">
            <li class="mt-5 mb-5 text-center" style="list-style: none;"><a class="h3" href="${pageContext.request.contextPath}/weightschedule" style="text-decoration: none;">체중 기록</a></li>
          </ul>
        </div>
      </div>
      <div class="col col-10">
        <div class="border bg-primary bg-opacity-10 h-100 rounded-5 d-flex flex-column">
          <div class="row mt-5 h2 ms-4">체중 관리</div>
          <div class="row-cols-auto d-flex flex-column justify-content-between h-100 pt-1 pb-1 px-2"> 
            <div class="col-2 border d-flex flex-column gap-3 justify-content-center align-items-center flex-grow-1 w-100 rounded-5 mb-2 bg-success bg-opacity-50">
              <div class="row h-100 my-3" style="height: 100%; width: 100%;">
                <div class="col-10">
                  <div class="card h-100 rounded-5">
                    <div class="card-body">
                      <canvas id="myChart"></canvas>
                    </div>
                  </div>
                </div>
                <div class="col-2">
                  <div class="card h-100 rounded-5">
                    <div class="card-body">
                      <form action="/weightDo" method="post">
                      	
                      	<p class="fs-4 text-center"> 체중 입력 </p>
                      	<div class="input-group mb-3">
						  <span class="input-group-text" id="weight1">체중</span>
						  <input type="text" class="form-control" name="weightNum" placeholder="체중 입력" >
						</div>
						<div class="d-grid">
                          <button class="btn btn-primary" id="btn" type="submit">입력</button>
                        </div>
                        <input type="hidden" name="memId" value="${sessionScope.login.memId}">
                      
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <!-- 상세페이지 -->
  
  <script>
  $(document).ready(function() {
	    $.ajax({
	      url: '/getWeightData',
	      method: 'GET',
	      data: { memId: '${sessionScope.login.memId}' }, // 세션에 있는 사용자 ID를 보냄
	      success: function(data) {
	        let labels_list = [];
	        let weight_list = [];
	        
	        // 서버에서 받은 데이터를 처리
	        data.forEach(function(item) {
	          labels_list.push(new Date(item.createDt).toLocaleDateString()); // 날짜 포맷팅
	          weight_list.push(item.weightNum); // 체중 데이터
	        });

	        // 차트 구성
	        let ctx = document.getElementById('myChart').getContext('2d');
	        let configs = {
	          type: 'line',
	          data: {
	            labels: labels_list,
	            datasets: [{
	              label: '체중',
	              data: weight_list,
	              borderColor: 'blue',
	              fill: false
	            }]
	          },
	          options: {
	        	    scales: {
	        	      y: {
	        	        beginAtZero: true // y축을 0부터 시작
	        	      }
	        	    },
	        	    elements: {
	        	      line: {
	        	        tension: 0.1 // 곡선의 부드러움 정도
	        	      }
	        	    }
	        	  }
	        	};

	        // 차트 그리기
	        new Chart(ctx, configs);
	      },
	      error: function(err) {
	        console.log("Error:", err);
	      }
	    });
	  });

  </script>
  </c:if>
  
</body>
</html>