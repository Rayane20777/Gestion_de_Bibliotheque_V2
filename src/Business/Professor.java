package Business;

import DAO.Interfaces.ProfessorDAO;
import DAO.ProfessorDAOImpl;




public class Professor extends User {

    private String department;
    private static final ProfessorDAO professorDAO = new ProfessorDAOImpl();


    public Professor(int id,String name, String email, String department) {
        super(id, name, email);
        this.department = department;

    }

    // setters - getters

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    // methods ****************************************************

    public static void addProfessor(int id, String name, String email, String department) {
        Professor newProfessor = new Professor(id, name, email, department);
        professorDAO.save(newProfessor);
        System.out.println("Professor added successfully");
    }

    public static void removeProfessor(int id) {
        professorDAO.delete(id);
        System.out.println("Professor deleted successfully");
    }

    public static void updateProfessor(int id, String name, String email, String department) {
        Professor professor = professorDAO.findById(id);
        if (professor == null) {
            System.out.println("Professor not found");
            return;
        }
        professor.setName(name);
        professor.setEmail(email);
        professor.setDepartment(department);
        professorDAO.update(professor);
        System.out.println("Professor updated successfully");
    }

    public static void displayProfessors() {
        professorDAO.findAll().forEach(professor -> {
            System.out.println("ID: " + professor.getId() + " Name: " + professor.getName() + " Email: " + professor.getEmail() + " Department: " + professor.getDepartment());
        });
    }

    public void displayDetails() {
        System.out.println("ID: " + this.getId() + " Name: " + this.getName() + " Email: " + this.getEmail() + " Department: " + this.getDepartment());
    }

}
