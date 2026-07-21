package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Student;
import util.DBConnection;

public class StudentDAO {

	
	public boolean addStudent(Student student) {
		  // SQL
		String sql="insert into students(name,email,age,course) values(?,?,?,?)";
			      
		try (
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql);)
	            
		{
ps.setString(1,student.getName());
ps.setString(2,student.getEmail());
ps.setInt(3,student.getAge());
ps.setString(4,student.getCourse());

	        // executeUpdate()
int rows=ps.executeUpdate();
if(rows>0)
	return true;
else
	return false;

	    }catch(SQLException e){

	        e.printStackTrace();
	    }
return false;
	    
	    
	}
	
	public Student getStudentById(int id) {

	    Student student = null;

	    String sql = "SELECT * FROM students WHERE id=?";

	    try(Connection con = DBConnection.getConnection();
	        PreparedStatement ps = con.prepareStatement(sql)) {

	        ps.setInt(1,id);

	        ResultSet rs = ps.executeQuery();

	        if(rs.next()) {

	            student = new Student();

	            student.setId(rs.getInt("id"));
	            student.setName(rs.getString("name"));
	            student.setEmail(rs.getString("email"));
	            student.setAge(rs.getInt("age"));
	            student.setCourse(rs.getString("course"));
	        }

	    }catch(SQLException e){
	        e.printStackTrace();
	    }

	    return student;
	}
	public List<Student> getAllStudents() {

	   //create an empty list
		List<Student> students = new ArrayList<>();

	    String sql = "SELECT * FROM students";

	    try (
	            Connection con = DBConnection.getConnection();
	            PreparedStatement ps = con.prepareStatement(sql);
	            ResultSet rs = ps.executeQuery()
	    ) {
	    	while(rs.next()) {
	    		
	    		Student student=new Student();
	    		student.setId(rs.getInt("id"));
	    		student.setName(rs.getString("name"));
	    		student.setEmail(rs.getString("email"));
	    		student.setAge(rs.getInt("age"));
	    		student.setCourse(rs.getString("course"));
	    		students.add(student);
	    	}
	    		
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    return students;
	
	}
	public boolean updateStudent(Student student) {
		
		String sql="UPDATE students\r\n"
				+ "SET name = ?, email = ?, age = ?, course = ?\r\n"
				+ "WHERE id = ?; ";
		try(Connection con= DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			
			){
			ps.setString(1, student.getName());

			ps.setString(2, student.getEmail());
			ps.setInt(3, student.getAge());
			ps.setString(4, student.getCourse());
			ps.setInt(5, student.getId());
			
			int row=ps.executeUpdate();
			if(row>0) {
				
				return true;
			}else {
				return false;
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
			
		return false;
	}
	public boolean deleteStudent(int id) {
		
		String sql="delete from students where id = ?;";
		try(Connection con= DBConnection.getConnection();
			PreparedStatement ps=con.prepareStatement(sql);
			){
			ps.setInt(1,id);
			int row = ps.executeUpdate();
			if(row>0) {
				return true;
			}else {
				return false;
				}
			}catch(SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
}
