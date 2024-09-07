package Business;

public class Student extends User {
    private String faculty;

    public Student(int id,String name, String email, String password, String department, String faculty) {
        super(id, name, email, password);
        this.faculty = faculty;
    }


    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }


}
