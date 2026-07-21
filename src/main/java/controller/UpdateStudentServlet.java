package controller;

import java.io.IOException;

import dao.StudentDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import model.Student;

@WebServlet("/UpdateStudentServlet")
public class UpdateStudentServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {


        // get data from form
        int id = Integer.parseInt(request.getParameter("id"));

        String name = request.getParameter("name");

        String email = request.getParameter("email");

        int age = Integer.parseInt(request.getParameter("age"));

        String course = request.getParameter("course");


        // create Student object
        Student student = new Student();

        student.setId(id);
        student.setName(name);
        student.setEmail(email);
        student.setAge(age);
        student.setCourse(course);


        // call DAO
        StudentDAO dao = new StudentDAO();

        boolean result = dao.updateStudent(student);


        if(result) {

            // go back to student list
            response.sendRedirect("viewStudents");

        } else {

            response.getWriter().println("Update failed");

        }

    }
}