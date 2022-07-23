<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Resetpassword</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
<style type="text/css">
.gradient-custom {
/* fallback for old browsers */
background: #6a11cb;

/* Chrome 10-25, Safari 5.1-6 */
background: -webkit-linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1));

/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
background: linear-gradient(to right, rgba(106, 17, 203, 1), rgba(37, 117, 252, 1))
}
p{

color:red;}
</style>
</head>
<body>
<section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">
<form action="ResetPasswordController" method="post">
            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">ResetPassword</h2>
              <p class="text-white-50 mb-5">Please enter your NewPassword and ConfirmPassword!</p>
             
             <div class="form-outline form-white mb-4">
                <input type="email" id="typePasswordX" class="form-control form-control-lg" name="email" />
                <label class="form-label" for="typePasswordX">Email</label>
               <p> ${emailError}</p>
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" id="typeEmailX" class="form-control form-control-lg" name="newpassword" />
                <label class="form-label" for="typeEmailX">New Password</label>
               <p>  ${newpasswordError}</p>
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" id="typePasswordX" class="form-control form-control-lg" name="confirmpassword" />
                <label class="form-label" for="typePasswordX">Confirm Password</label>
               <p> ${confirmpasswordError}</p>
              </div>
             <div>${msg}</div>
             
               <button class="btn btn-outline-light btn-lg px-5" type="submit">Submit</button>

              
            </div>

            <div>
              <p class="mb-0">Don't have an account? <a href="SignUp.jsp" class="text-white-50 fw-bold">SignUp</a>
              </p>
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