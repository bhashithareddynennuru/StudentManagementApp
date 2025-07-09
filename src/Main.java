import java.sql.*;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/student_db";
        String user = "root"; // Your MySQL username
        String password = "SonySunny@2005"; // 🔁 Replace with your root password

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            StudentDAO dao = new StudentDAO(conn);

            while (true) {

                System.out.println("STUDENT MANAGEMENT APP");
                System.out.println("1. Add student");
                System.out.println("2. View All Students");
                System.out.println("3. Delete a student");
                System.out.println("4. Exit");
                System.out.println("Enter your choice");
                int choice = sc.nextInt();
                sc.nextLine();
                if (choice == 1) {
                    System.out.println("Enter the name of the student: ");
                    String name = sc.nextLine();
                    System.out.println("Enter the roll number: ");
                    int roll = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter Grade: ");
                    String grade = sc.nextLine();

                    Student s = new Student(name, roll, grade);
                    dao.insertStudent(s);
                }
                else if (choice == 2) {
                    List<Student> students = dao.getAllStudents();
                    System.out.println("Student Details");
                    for (Student s : students) {
                        System.out.println("ID: " + s.getId());
                        System.out.println("NAME: " + s.getName());
                        System.out.println("ROLL: " + s.getRoll());
                        System.out.println("GRADE: " + s.getGrade());
                        System.out.println("------------------------------------------");
                    }
                }
                else if(choice == 3){
                    System.out.println("Enter the id of student u want to delete: ");
                    int idToDelete = sc.nextInt();
                    sc.nextLine();
                    dao.deleteStudentById(idToDelete);
                }
                else if(choice == 4){
                    System.out.println("Exiting.. Bye!");
                    break;
                }
                else {
                    System.out.println("Invalid Choice");
                }

            }
            conn.close();

        }catch(Exception e){
            System.out.println("Error connecting to database");
            e.printStackTrace();
        }
        sc.close();
    }
}
