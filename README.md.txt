# 🎓 Student Management App

A basic Java console application that uses MySQL to:
- ✅ Add students
- ✅ View all students
- ✅ Delete students by ID

## 💻 Technologies Used
- Java (OOPS)
- MySQL (with JDBC)
- IntelliJ IDEA

## ⚙️ How to Run

1. Clone the repository
2. Import project into IntelliJ
3. Set up MySQL DB using `student_db_schema.sql`
4. Add JDBC connector `.jar` to your project
5. Run `Main.java`

## 📂 DB Schema

```sql
CREATE DATABASE IF NOT EXISTS student_db;
USE student_db;

CREATE TABLE IF NOT EXISTS students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50),
    roll INT,
    grade VARCHAR(5)
);
