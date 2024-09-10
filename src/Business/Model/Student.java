package Business.Model;

public class Student extends User {
    private String faculty;
    private String grade;

    public Student(int id,String name, String email, String password, String department, String faculty, String grade) {
        super(id, name, email, password);
        this.faculty = faculty;
        this.grade = grade;
    }

    // setters - getters

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getGrade(){
        return grade;
    }

    public void setGrade(String grade){
        this.grade = grade;
    }


}
