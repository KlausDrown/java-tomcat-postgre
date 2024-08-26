package ForWork;

import ForWork.util.MyConnection;

import java.sql.*;


public class postgresSQL1 {
    public static void main(String[] args) throws SQLException{

        String sql = """ 
                
                Select * From users
                
                """;

        try (var connection = MyConnection.get();
        var statement = connection.createStatement()){
            var result = statement.executeQuery(sql);
            while(result.next())
            {
                System.out.println(result.getString("name"));
            }
        }

    }
}
