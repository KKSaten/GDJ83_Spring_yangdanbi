<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!-- c태그 사용 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="/WEB-INF/views/sample/bootHeader.jsp"></c:import>
</head>
<body>
	<c:import url="/WEB-INF/views/sample/header.jsp"></c:import>
	
	
<div class="container-fluid mt-5">
	<div class="row justify-content-center">
	<c:if test="${not empty member}"> <!-- 서버를 껐다키지 않는 이상 창을 닫아도 로그인 유지  -->
	<div>
		<h5 style="text-align: center; margin-bottom: 30px;">${member.member_name}님 환영합니다!</h5>
	</div>
	</c:if>
		<div id="carouselExampleAutoplaying" class="carousel slide col-md-5" data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img src="./resources/images/index/f1.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="./resources/images/index/f2.jpg" class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="./resources/images/index/f3.jpg" class="d-block w-100" alt="...">
				</div>
			</div>
			<button class="carousel-control-prev" type="button"	data-bs-target="#carouselExampleAutoplaying" data-bs-slide="prev">
				<span class="carousel-control-prev-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Previous</span>
			</button>
			<button class="carousel-control-next" type="button"
				data-bs-target="#carouselExampleAutoplaying" data-bs-slide="next">
				<span class="carousel-control-next-icon" aria-hidden="true"></span>
				<span class="visually-hidden">Next</span>
			</button>
		</div>
	</div>
	
</div>

<c:import url="/WEB-INF/views/sample/bootFooter.jsp"></c:import>
</body>
</html>