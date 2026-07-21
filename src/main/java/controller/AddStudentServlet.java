package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;

import dao.StudentDAO;


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet 
{

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name=request.getParameter("name");
		String email=request.getParameter("email");
		int age=Integer.parseInt(request.getParameter("age"));
		String course=request.getParameter("course");
		
		//create student obj
		Student student=new Student();
		//set values
		student.setName(name);
		student.setAge(age);
		student.setCourse(course);
		student.setEmail(email);
		
		//call dao
		StudentDAO dao=new StudentDAO();
		
		boolean result=dao.addStudent(student);
		if(result) {
			response.sendRedirect("viewStudents");
		}
		else {
			response.getWriter().println("Failed to add student");
		}
		
		
	}

}
