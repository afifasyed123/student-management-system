<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<title>Add Student</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">

</head>

<body class="bg-light">


<div class="container mt-5">


<div class="card shadow mx-auto" style="max-width:500px;">


<div class="card-header bg-primary text-white text-center">

<h2>Add Student</h2>

</div>


<div class="card-body">


<form action="AddStudentServlet" method="post">


<div class="mb-3">

<label class="form-label">
Name
</label>

<input type="text" 
       name="name" 
       class="form-control"
       placeholder="Enter name"
       required>

</div>



<div class="mb-3">

<label class="form-label">
Email
</label>

<input type="email" 
       name="email" 
       class="form-control"
       placeholder="Enter email"
       required>

</div>



<div class="mb-3">

<label class="form-label">
Age
</label>

<input type="number" 
       name="age" 
       class="form-control"
       placeholder="Enter age"
       required>

</div>



<div class="mb-3">

<label class="form-label">
Course
</label>

<input type="text" 
       name="course" 
       class="form-control"
       placeholder="Enter course"
       required>

</div>



<button type="submit" class="btn btn-success w-100">

Add Student

</button>


</form>


</div>

</div>


</div>


</body>
</html>