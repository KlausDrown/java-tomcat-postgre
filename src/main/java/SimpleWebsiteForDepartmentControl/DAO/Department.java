package SimpleWebsiteForDepartmentControl.DAO;

import java.io.Serializable;

public class Department implements Serializable {
    private int deptID;
    private String deptName;

    public Department(int deptID, String deptName) {
        this.deptID = deptID;
        this.deptName = deptName;
    }

    public Department(String deptName) {
        this.deptName = deptName;
    }

    public Department() {
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public int getDeptID() {
        return deptID;
    }
}
