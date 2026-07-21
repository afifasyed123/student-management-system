<%@ page import="java.util.List" %>
<%@ page import="model.Student" %>

<%
List<Student> students = (List<Student>) request.getAttribute("students");
%>

<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Student Management System</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">


<div class="container mt-5">


<div class="card shadow">

<div class="card-header bg-primary text-white text-center">

<h2>Student Management System</h2>

</div>


<div class="card-body">


<table class="table table-bordered table-hover text-center">


<tr class="table-dark">

<th>ID</th>
<th>Name</th>
<th>Email</th>
<th>Age</th>
<th>Course</th>
<th>Action</th>

</tr>


<%
for(Student s : students){
%>


<tr>

<td><%= s.getId() %></td>

<td><%= s.getName() %></td>

<td><%= s.getEmail() %></td>

<td><%= s.getAge() %></td>

<td><%= s.getCourse() %></td>


<td>


<form action="EditStudentServlet" method="get" style="display:inline;">

<input type="hidden" name="id" value="<%=s.getId()%>">

<button class="btn btn-success btn-sm">
Edit
</button>

</form>



<form action="DeleteStudentServlet" method="post" style="display:inline;">

<input type="hidden" name="id" value="<%=s.getId()%>">

<button class="btn btn-danger btn-sm">
Delete
</button>

</form>


</td>


</tr>


<%
}
%>


</table>


</div>

</div>


</div>


</body>
</html>