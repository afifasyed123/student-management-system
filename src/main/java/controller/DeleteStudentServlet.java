package controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import dao.StudentDAO;

@WebServlet("/DeleteStudentServlet")
public class DeleteStudentServlet extends HttpServlet {


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	int id=Integer.parseInt(request.getParameter("id"));
	
	StudentDAO dao=new StudentDAO();
	boolean result=dao.deleteStudent(id);
	if(result) {
		response.sendRedirect("viewStudents");
	}
	else {
		response.getWriter().println("Delete failed");
	}
	}

}
