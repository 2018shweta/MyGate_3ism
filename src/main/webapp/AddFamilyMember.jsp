<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import="com.bean.HouseBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Family Member</title>
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
<%
	ArrayList<HouseBean> houses = (ArrayList<HouseBean>) request.getAttribute("houses");
	%>

<div class="container">

		<div class="row justify-content-center">
			<div class="col-md-6">
				<div class="card" >
					<header class="card-header">
						
						<h4 class="card-title mt-2">Add Family member</h4>
					</header>
					<article class="card-body">
						<form method="post" action="AddFamilyMemberController">
							
								<div class=" form-group">
									<label>Name </label> <input type="text" name="name"
											 class="form-control" />
									<p>${nameError}</p>
									
								</div>
								
								
								<%-- <div class=" form-group">
									<label>Block </label> <input type="text" name="block"
											 class="form-control" />
									<%=descriptionError== null? "":descriptionError %>
								</div> --%>
								<div class=" form-group">
									<label>Contact no </label> <input type="text" name="contactnumber"
											 class="form-control" />
								<p>${contactnumberError}</p>
								</div>
								<div class=" form-group">
									<label>Age </label> <input type="text" name="age"
										value="0"	 class="form-control" />
								<p>${ageError}</p>
								</div>
								<div class=" form-group">
									<label>Email </label> <input type="email" name="email"
											 class="form-control" />
								<p>${emailError}</p>
								</div>
								
								
								
								
								<div class="col-md-6 mb-4">

										<h6 class="mb-2 pb-1">Gender:</h6>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="gender" id="femaleGender" value="Female"
												checked /> <label class="form-check-label"
												name="gender">Female</label>
										</div>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="gender" id="maleGender" value="male" />
											<label class="form-check-label">Male</label>
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


