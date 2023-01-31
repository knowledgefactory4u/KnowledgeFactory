<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
<meta charset="utf-8">
<meta http-equiv="x-ua-compatible" content="ie=edge">
<title>Student Management</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
 href="https://use.fontawesome.com/releases/v5.4.1/css/all.css">
<link rel="stylesheet"
 href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
 src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js">

</script>
<script
 src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js">
</script>
</head>
<body >
<div class="container my-5">
<h2>Student <c:out value="${student.id != null ? 'Update' : 'Registration' }" /></h2>
<div class="card">
            <div class="card-body">
                <div class="col-md-10">
<form:form method="POST" modelAttribute="student" action="/home" name="student">
		<form:hidden path="id"/>

    <div class="row">
       <div class="form-group col-md-8">
       <label for="name" class="col-form-label"> First Name
                                                        </label>
        <form:input path="firstName" id="fname" class="form-control" />
      </div>

         <div class="form-group col-md-8">
         <label for="name" class="col-form-label"> Last Name
                                                     </label>
        <form:input path="lastName" id="lname" class="form-control"/>
         </div>

        <div class="form-group col-md-8">
        <label for="email" class="col-form-label" > Email
                                                       </label>
        <form:input path="emailId" id="emailId" class="form-control"/>
        </div>
       </div>

        <div class="col-md-6">
        <input type="submit" class="btn btn-success"
           value="<c:out value="${student.id != null ? 'Update' : 'Register' }" />">&nbsp;&nbsp;
         <a href="/list">Student List</a>&nbsp;
         <c:if test="${student.id ne null}"><b>|</b>&nbsp;<a href="/registration">Registration</a></c:if>
         </div>

       </form:form>
              </div>
            </div>
        </div>
    </div>
</body>
</html>