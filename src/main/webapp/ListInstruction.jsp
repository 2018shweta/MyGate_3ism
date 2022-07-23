<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="com.bean.InstructionBean"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List instructions</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">


</head>
<body>
	<jsp:include page="MemberHeader.jsp"></jsp:include>

	<%
	ArrayList<InstructionBean> instructions = (ArrayList<InstructionBean>) request.getAttribute("instructions");
	%>


	<div class="container-fluide">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<table class="display" id="users">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Name</th>
							<th scope="col">Type</th>
							<th scope="col">Description</th>
							<th scope="col">Allow</th>
							<th scope="col">Disable</th>
							<th scope="col">Delete</th>

						</tr>
					</thead>
					<tbody>
						
						<c:forEach items="${instructions}" var="it">
						<tr>
							<%-- <td><%=instruction.getName()%></td>
							<td><%=instruction.getType()%></td>
							<td><%=instruction.getDescription()%></td>
							<td><%=instruction.getAllow() %></td> --%>
							<td>${it.name}</td>
							<td>${it.type}</td>
							<td>${it.description}</td>
							<td>
							<c:if test="${(it.allow==1)}">
							
							yes</c:if>
								<c:if test="${(it.allow==0)}">
							
							No</c:if>
							</td>
						
							<td><a href="AllowDisableController?instructionid=${it.instructionid}">Disable</a>
							</td>
							<td><a href="DeleteInstructionController?instructionid=${it.instructionid}">Delete</a>
							</td>

						</tr>
						</c:forEach>
						
					</tbody>

				</table>
				<br>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript">
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>
</body>
</html>