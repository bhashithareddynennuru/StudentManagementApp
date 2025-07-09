import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    private Connection conn;
    public StudentDAO(Connection conn){
        this.conn = conn;
    }

    public void insertStudent(Student stObj){
        String sql = "INSERT INTO students (name, roll, grade) VALUES (?, ?, ?)";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, stObj.getName());
            stmt.setInt(2, stObj.getRoll());
            stmt.setString(3, stObj.getGrade());
            stmt.executeUpdate();
            System.out.println("Student Inserted");
        } catch(SQLException e){
            System.out.println("Failed to insert Student");
            e.printStackTrace();
        }
    }

    public List<Student> getAllStudents(){
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";

        try{
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            while(rs.next()){
                int id = rs.getInt("Id");
                String name = rs.getString("name");
                int roll = rs.getInt("roll");
                String grade = rs.getString("grade");
                Student student = new Student(id, name, roll, grade);
                students.add(student);
            }
        }catch(SQLException e){
            System.out.println("Failed to fetch students");
            e.printStackTrace();
        }
        return students;
    }

    public void deleteStudentById(int id){
        String sql = "DELETE FROM students WHERE id = ?";

        try{
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            int rowsAffected = stmt.executeUpdate();
            if(rowsAffected > 0){
                System.out.println("Student with id: "+id+" deleted successfully");
            }
            else{
                System.out.println("No student with this id found");
            }
        }catch(SQLException e){
            System.out.println("Failed to delete student");
            e.printStackTrace();
        }

    }
}
