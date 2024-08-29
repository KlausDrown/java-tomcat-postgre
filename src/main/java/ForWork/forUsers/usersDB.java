package ForWork.forUsers;

import ForWork.util.MyConnection;

import java.sql.*;
import java.util.ArrayList;

public class usersDB {
    public static int selectCount() {
        int count = 0;
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = MyConnection.get()){

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT count(*) FROM users");
                if (resultSet.next());
                count = resultSet.getInt(1);
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return count;
    }

    public static int insert(Users users){

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = MyConnection.get())
            {
                String sql = "INSERT INTO users (name, login, password) Values (?, ?, ?)";
                try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
                    preparedStatement.setString(1, users.getName());
                    preparedStatement.setString(2, users.getEmail());
                    preparedStatement.setString(3, users.getPassword());

                    return  preparedStatement.executeUpdate();
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return 0;

    }

    public static ArrayList<Users> select(int page) {

        ArrayList<Users> users = new ArrayList<Users>();
        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = MyConnection.get()){

                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM users ORDER BY name " + "limit "+(5)+" offset "+((page-1)*5));
                while(resultSet.next()){
                    int id = resultSet.getInt(1);
                    String name =resultSet.getString(2);
                    String login = resultSet.getString(3);
                    String password = resultSet.getString(4);
                    Users user = new Users(id,name,login, password);
                    users.add(user);
                }
            }
        }
        catch(Exception ex){
            System.out.println(ex);
        }
        return users;
    }

    public static int delete(int id) {

        try{
            Class.forName("org.postgresql.Driver");
            try (Connection connection = MyConnection.get()){

                String sql = "DELETE FROM users WHERE id = ?";
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



