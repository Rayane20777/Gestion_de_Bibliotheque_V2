package Business;

import DAO.Interfaces.StudentDAO;
import DAO.StudentDAOImpl;


public class Student extends User {
    private String faculty;
    private String grade;
    private static final StudentDAO studentDAO = new StudentDAOImpl();

    public Student(int id,String name, String email, String faculty, String grade) {
        super(id, name, email);
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




    public static void addStudent(int id, String name, String email, String faculty, String grade) {
        Student newStudent = new Student(id, name, email, faculty, grade);
        studentDAO.save(newStudent);
        System.out.println("Student added successfully");
    }

    public static void removeStudent(int id) {
        studentDAO.delete(id);
        System.out.println("Student deleted successfully");
    }

    public static void updateStudent(int id, String name, String email, String faculty, String grade) {

        Student student = studentDAO.findById(id);
        if (student == null) {
            System.out.println("Student not found");
            return;
        }
        student.setName(name);
        student.setEmail(email);
        student.setFaculty(faculty);
        student.setGrade(grade);
        studentDAO.update(student);
        System.out.println("Student updated successfully");
    }

    public static void displayStudents() {
        studentDAO.findAll().forEach(student -> {
            System.out.println("ID: " + student.getId() + " Name: " + student.getName() + " Email: " + student.getEmail() + " Faculty: " + student.getFaculty() + " Grade: " + student.getGrade());
        });
    }





}
