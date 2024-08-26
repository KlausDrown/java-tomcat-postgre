package ForWork.dao;

import ForWork.entity.Ticket;
import ForWork.exception.DaoException;
import ForWork.util.MyConnection;
import org.eclipse.tags.shaded.org.apache.xalan.lib.sql.ConnectionPoolManager;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class TicketDao {
    private final static TicketDao INSTANCE = new TicketDao();

    private final static String SAVE_SQL = """
                                            INSERT INTO users
                                            (name, login, password) values (?,?,?)
                                            
                                           """;
    private final static String DELETE_SQL = """
                                            DELETE FROM users 
                                            WHERE id = ?                                            
                                           """;




    public Ticket save(Ticket ticket){
        try(var connection = MyConnection.get();
        var statement = connection.prepareStatement(SAVE_SQL, Statement.RETURN_GENERATED_KEYS)){
            statement.setString(1, ticket.getName());
            statement.setString(2, ticket.getLogin());
            statement.setString(3, ticket.getPassword());

            statement.executeUpdate();
            var keys = statement.getGeneratedKeys();
            if(keys.next())
                ticket.setId(keys.getLong("id"));
            return  ticket;

        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
    public boolean deleted(Long id){
        try(var connection = MyConnection.get();
            var statement = connection.prepareStatement(DELETE_SQL)){
            statement.setLong(1, id);

            return statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }





    public static TicketDao getINSTANCE() {
        return INSTANCE;
    }

    private TicketDao() {
    }
}
