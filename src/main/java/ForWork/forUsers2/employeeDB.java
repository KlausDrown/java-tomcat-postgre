package ForWork.forUsers2;

import ForWork.forUsers.Users;
import ForWork.util.MyConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class employeeDB {

    public static int delete(int id) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = MyConnection.get()){

                String sql = "DELETE FROM employee WHERE id = ?";
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


    public static int insert(Employee employee){

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = MyConnection.get())
            {
                String sql = "INSERT INTO employee (name, login, password, department_id) Values (?, ?, ?,?)";
                try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setString(1, employee.getName());
                    preparedStatement.setString(2, employee.getLogin());
                    preparedStatement.setString(3, employee.getPassword());
                    preparedStatement.setInt(4, employee.getDepartment_id());

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
            try (Connection connection = MyConnection.get()){

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM employee");
                if (resultSet.next());
                count = resultSet.getInt(1);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return count;
    }

    public static ArrayList<Employee> select() {

        ArrayList<Employee> employees = new ArrayList<Employee>();

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = MyConnection.get()){

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT e.id,e.name, login, password ,d.name  FROM employee e, department d where e.department_id = d.id;");
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name =resultSet.getString(2);
                    String login = resultSet.getString(3);
                    String password = resultSet.getString(4);
                    String department_name = resultSet.getString(5);
                    Employee employee = new Employee(id,name,login, password, department_name);
                    employees.add(employee);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return employees;
    }
}
