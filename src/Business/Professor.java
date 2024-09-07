package Business;

import javax.swing.*;

public class Professor extends User {

    private String department;

    public Professor(int id,String name, String email, String password, String department) {
        super(id, name, email, password);
        this.department = department;

    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
