public class Student {
    private int id;
    private String name;
    private int roll;
    private String grade;
    public Student(String name, int roll, String grade){
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }
    public Student(int id, String name, int roll, String grade){
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.grade = grade;
    }
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getRoll(){
        return roll;
    }
    public String getGrade(){
        return grade;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setRoll(int roll){
        this.roll = roll;
    }
    public void setGrade(String grade){
        this.grade = grade;
    }
    public void display(){
        System.out.println(id+" - "+name+" - "+roll+" - "+grade);
    }
}
