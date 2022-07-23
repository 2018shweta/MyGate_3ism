<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddHouse</title>
<link
	href="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	rel="stylesheet" id="bootstrap-css">
<script
	src="//maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
<script
	src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">
p {
	color: red;
}
</style>
</head>
<body>

<jsp:include page="MemberHeader.jsp"></jsp:include>

<%

String tasknameError =(String)request.getAttribute("tasknameError");
String descriptionError =(String)request.getAttribute("descriptionError");
String statusError =(String)request.getAttribute("statusError");
String priorityError =(String)request.getAttribute("priorityError");
String dateError =(String)request.getAttribute("dateError");
%>

<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card" >
					<header class="card-header">
						
						<h4 class="card-title mt-2">Add House</h4>
					</header>
					<article class="card-body">
						<form method="post" action="AddHouseController">
							
								<div class=" form-group">
									<label>House no </label> <input type="text" name="houseno"
											value="0" class="form-control" />
									<p>${housenoError}</p>
									
								</div>
								
								
								<%-- <div class=" form-group">
									<label>Block </label> <input type="text" name="block"
											 class="form-control" />
									<%=descriptionError== null? "":descriptionError %>
								</div> --%>
								<div class=" form-group">
									<label>House Flor </label> <input type="text" name="houseflor"
											value="0" class="form-control" />
								<p>${houseflorError}</p>
								</div>
								
								<div class="col-md-6 mb-4">

										<h6 class="mb-2 pb-1">House Block:</h6>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="block" id="femaleGender" value="A"
												checked /> <label class="form-check-label"
												name="gender">A</label>
										</div>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="block" id="maleGender" value="B" />
											<label class="form-check-label">B</label>
										</div>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="block" id="otherGender" value="C" />
											<label class="form-check-label" name="block">C</label>
										</div>

									</div>
								
								
								
								
								
								<!-- form-group end.// -->
								
								<!-- form-group end.// -->
							
							<!-- form-row end.// -->
							<%-- <div class="form-group">
								<label>Email address</label> <input type="email"
									class="form-control" name="email" value="${emailValue}" />
								<%=emailError == null ? "" : emailError%>
							</div> --%>
							<!-- form-group end.// -->
							
							
							<!-- form-group end.// -->

							
				<!-- form-row.// -->
				<div class="form-group">
					<button type="submit" class="btn btn-primary btn-block">
						Submit</button>
				</div>
				<!-- form-group// -->
				</form>
				</article>
				<!-- card-body end .// -->
				
			</div>
			<!-- card.// -->
		</div>
		<!-- col.//-->
	</div>
	<!-- row.//-->
	</div>
</body>
</html>




