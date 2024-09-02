package SimpleWebsiteForDepartmentControl.DAO;

import SimpleWebsiteForDepartmentControl.util.SimpleConnectionPool;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DepartmentDAO {

    public static int insert(Department department){

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = SimpleConnectionPool.get())
            {
                String sql = "INSERT INTO department (name) Values (?)";
                try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setString(1, department.getDeptName());
                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;

    }


    public static int selectCount() {
        int count = 0;
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = SimpleConnectionPool.get()){

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM department");
                if (resultSet.next());
                count = resultSet.getInt(1);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return count;
    }

    public static ArrayList<Department> select() {

        ArrayList<Department> departments = new ArrayList<Department>();

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = SimpleConnectionPool.get()){

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM department");
                while(resultSet.next()){
                    int deptID = resultSet.getInt(1);
                    String deptName =resultSet.getString(2);
                    Department department = new Department(deptID,deptName);
                    departments.add(department);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return departments;
    }
    public static int delete(int id) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = SimpleConnectionPool.get()){

                String sql = "DELETE FROM department WHERE id = ?";
                try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setInt(1, id);

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;
    }
}
