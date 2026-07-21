package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Student;

import java.io.IOException;
import java.util.List;

import dao.StudentDAO;

@WebServlet("/viewStudents")
public class ViewStudentsServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		StudentDAO dao = new StudentDAO();
		List<Student> students=dao.getAllStudents();
		
		request.setAttribute("students", students);
		
		RequestDispatcher rd= request.getRequestDispatcher("viewStudents.jsp");
		rd.forward(request, response);
		
	}

}
