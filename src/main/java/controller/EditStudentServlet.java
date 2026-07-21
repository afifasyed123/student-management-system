package controller;

import java.io.IOException;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Student;

@WebServlet("/EditStudentServlet")
public class EditStudentServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        int id = Integer.parseInt(request.getParameter("id"));

        StudentDAO dao = new StudentDAO();

        Student student = dao.getStudentById(id);


        request.setAttribute("student", student);


        request.getRequestDispatcher("editStudent.jsp")
               .forward(request, response);
    }
}