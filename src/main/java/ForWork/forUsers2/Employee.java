package ForWork.forUsers2;

import java.io.Serializable;

public class Employee implements Serializable {
    private int id;
    private String name;
    private String login;
    private String password;
    private int department_id;
    private String department_name;

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public Employee() {
    }

    public Employee(String name, String login, String password, int department_id) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.department_id = department_id;
    }

    public Employee(String name, String login, String password, String department_name) {
        this.name = name;
        this.login = login;
        this.password = password;
        this.department_name = department_name;
    }

    public Employee(int id, String name, String login, String password, String department_name) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.department_name = department_name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }
}
