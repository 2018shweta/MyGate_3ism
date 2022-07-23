<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.bean.MemberBean"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List FamilyMember</title>
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
	ArrayList<MemberBean> members = (ArrayList<MemberBean>) request.getAttribute("members");
	%>


	<div class="container-fluide">
		<div class="row"></div>
		<div class="row">
			<div class="col-md-2"></div>

			<div class="col-md-8">
				<table class="display" id="users">
					<thead class="thead-dark">
						<tr>
							<th scope="col">Member name</th>
							<th scope="col">Age</th>
							<th scope="col">Gender</th>
							<th scope="col">Contact Number</th>
							<th scope="col">Email</th>
							<th scope="col">Action</th>
						</tr>
					</thead>
					<tbody>
						<%
						for (MemberBean member : members) {
						%>
						<tr>
							<td><%=member.getName()%></td>
							<td><%=member.getAge()%></td>
							<td><%=member.getGender()%></td>
							<td><%=member.getContactnumber()%></td>
							<td><%=member.getEmail()%></td>

							<td><a
								href="DeleteFamilyMemberController?memberid=<%=member.getMemberid()%>">Delete</a>
							</td>

						</tr>
						<%
						}
						%>
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