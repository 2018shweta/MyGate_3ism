
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up Page</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">

<style>
.gradient-custom {
	/* fallback for old browsers */
	background: #f093fb;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to bottom right, rgba(240, 147, 251, 1),
		rgba(245, 87, 108, 1));
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to bottom right, rgba(240, 147, 251, 1),
		rgba(245, 87, 108, 1))
}

.card-registration .select-input.form-control[readonly]:not([disabled])
	{
	font-size: 1rem;
	line-height: 2.15;
	padding-left: .75em;
	padding-right: .75em;
}

.card-registration .select-arrow {
	top: 13px;
}
</style>
</head>
<body>
	<section class="vh-100 gradient-custom">
		<div class="container py-5 h-100">
			<div class="row justify-content-center align-items-center h-100">
				<div class="col-12 col-lg-9 col-xl-7">
					<div class="card shadow-2-strong card-registration"
						style="border-radius: 15px;">
						<div class="card-body p-4 p-md-5">
							<h3 class="mb-4 pb-2 pb-md-0 mb-md-5">Registration Form</h3>
							<form action="SignUpController" method="post">

								<div class="row">
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<input type="text" id="firstName"
												class="form-control form-control-lg" name="firstname"/> 
												<label class="form-label" >First Name</label>
												${firstnameError}
										</div>

									</div>
									<div class="col-md-6 mb-4">

										<div class="form-outline">
											<input type="text" id="lastName"
												class="form-control form-control-lg" name="lastname"/> <label
												class="form-label" >Last Name</label>
										</div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 d-flex align-items-center">

										<div class="form-outline datepicker w-100">
											<input type="email" class="form-control form-control-lg" name="email"
												id="birthdayDate" /> <label 
												class="form-label">Email</label>
												${ emailError}
										</div>

									</div>
									<div class="col-md-6 mb-4">

										<h6 class="mb-2 pb-1">Gender:</h6>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="gender" id="femaleGender" value="female"
												checked /> <label class="form-check-label"
												name="gender">Female</label>
										</div>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="gender" id="maleGender" value="male" />
											<label class="form-check-label">Male</label>
										</div>

										<div class="form-check form-check-inline">
											<input class="form-check-input" type="radio"
												name="inlineRadioOptions" id="otherGender" value="option3" />
											<label class="form-check-label" name="gender">Other</label>
										</div>

									</div>
								</div>

								<div class="row">
									<div class="col-md-6 mb-4 pb-2">

										<div class="form-outline">
											<input type="text" 
												class="form-control form-control-lg" name="contactnumber"/> <label
												class="form-label" >Contact Number</label>
										</div>

									</div>
									<div class="col-md-6 mb-4 pb-2">
										<div class="form-outline">
											<input type="password" id="phoneNumber"
												class="form-control form-control-lg"  name="password"/> <label
												class="form-label">Password</label>
												${ passwordError}
										</div>

									</div>
								</div>

								

								<div class="mt-4 pt-2">
									<input class="btn btn-primary btn-lg" type="submit"
										value="Register" />
										<p class="text-center text-muted mt-5 mb-0">Have already an account? <a href="Login.jsp"
                    class="fw-bold text-body"><u>Login here</u></a></p>
								</div>
								
								
								
								

							</form>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
</body>
</html>