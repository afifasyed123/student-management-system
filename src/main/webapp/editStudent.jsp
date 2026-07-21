<%@ page import="model.Student" %>

<%
Student student = (Student) request.getAttribute("student");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Edit Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">


<div class="container mt-5">


<div class="card shadow mx-auto" style="max-width:500px;">


<div class="card-header bg-warning text-dark text-center">

<h2>Edit Student</h2>

</div>


<div class="card-body">


<form action="UpdateStudentServlet" method="post">


<input type="hidden" 
       name="id" 
       value="<%=student.getId()%>">



<div class="mb-3">

<label class="form-label">
Name
</label>

<input type="text"
       name="name"
       class="form-control"
       value="<%=student.getName()%>"
       required>

</div>



<div class="mb-3">

<label class="form-label">
Email
</label>

<input type="email"
       name="email"
       class="form-control"
       value="<%=student.getEmail()%>"
       required>

</div>



<div class="mb-3">

<label class="form-label">
Age
</label>

<input type="number"
       name="age"
       class="form-control"
       value="<%=student.getAge()%>"
       required>

</div>



<div class="mb-3">

<label class="form-label">
Course
</label>

<input type="text"
       name="course"
       class="form-control"
       value="<%=student.getCourse()%>"
       required>

</div>



<button type="submit" class="btn btn-primary w-100">

Update Student

</button>


</form>


</div>


</div>


</div>


</body>
</html>