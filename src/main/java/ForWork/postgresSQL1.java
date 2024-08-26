package ForWork;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Scanner;
import java.util.logging.*;

public class postgresSQL1 {
    public static void main(String[] args) {
        Connection connection = null;
        try {
            System.out.println("enter name: ");
            Scanner console = new Scanner(System.in);
            String name = console.nextLine();
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/myproject","postgres","hello");
            if(connection != null)
            {
                System.out.println("connection on");
            }
            else{
                System.out.println("connection off");
            }
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM customers WHERE firstname = ?");
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println("Номер в базе #" + resultSet.getInt("id")  + "\t" + resultSet.getString("firstname"));
            }
            connection.close();
            System.out.println("connection off");

        }
        catch (Exception e)
        {
            System.out.println(e);
        }
        finally{
            try{
                connection.close();
                System.out.println("connection off");
            }
            catch (Exception ef)
            {
                System.out.println(ef);
            }
        }
    }
}
