package Business;


public class Professor extends User {

    private String department;

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
}
