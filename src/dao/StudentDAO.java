package dao;

import model.Student;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    private Connection conn;

    public StudentDAO() {
        conn = DBConnection.getConnection();
    }

    // Add student
    public boolean addStudent(Student student) {

        String sql = "INSERT INTO students (name, age, course, email) VALUES (?, ?, ?, ?)";

        try (Connection con = DBConnection.getConnection();
            PreparedStatement pst = con.prepareStatement(sql)) {
                
            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getCourse());
            pst.setString(4, student.getEmail());

            return pst.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error while adding student");
            System.out.println("Reason: " + e.getMessage());
            return false;
        }
    }

    // View all students
    public List<Student> viewAllStudents() {
        List<Student> students = new ArrayList<>();

        String sql = "SELECT * FROM students";
        
        try (Connection con = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery()) {
                
                while (rs.next()) {
                    Student s = new Student(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("course"),
                        rs.getString("email")
                    );
                    students.add(s);
                }

        } catch (SQLException e) {
            System.out.println("Error while fetching students");
            System.out.println("Reason: " + e.getMessage());
        }

        return students;
    }

    // Update student
    public boolean updateStudent(Student student) {

        String sql = "UPDATE students SET name = ?, age = ?, course = ?, email = ? WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.setString(3, student.getCourse());
            pst.setString(4, student.getEmail());
            pst.setInt(5, student.getId());

            int row = pst.executeUpdate();
            return row > 0;
        } catch (SQLException e) {
            System.out.println("Error while updating student");
            System.out.println("Reason: " + e.getMessage());
            return false;
        }
    }

    // Delete student
    public boolean deleteStudent(int id) {

        String sql = "DELETE FROM students WHERE id = ?";

        try (Connection con = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id);
            int row = pst.executeUpdate();
            return row > 0;
            
        } catch (SQLException e) {
            System.out.println("Error while deleting student");
            System.out.println("Reason: " + e.getMessage());
            return false;
        }
    }

    // Search student by id
    public Student searchStudentById(int id) {

        String sql = "SELECT * FROM students WHERE id = ?";
        
        try (Connection con = DBConnection.getConnection();
            PreparedStatement pst = conn.prepareStatement(sql)) {
            
            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            if (rs.next()) {
                return new Student(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getInt("age"),
                    rs.getString("course"),
                    rs.getString("email")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error while searching student");
            System.out.println("Reason: " + e.getMessage());
        }

        return null; // student not found
    }

}
