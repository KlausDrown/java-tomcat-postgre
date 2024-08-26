package ForWork;

import ForWork.dao.TicketDao;
import ForWork.entity.Ticket;
import ForWork.util.MyConnection;

import java.sql.*;


public class postgresSQL1 {
    public static void main(String[] args) throws SQLException{
        var ticetDao = TicketDao.getINSTANCE();

        Ticket ticket = new Ticket();
        ticket.setPassword("samPSW");
        ticket.setLogin("sam@gmail.com");
        ticket.setName("Sam");

        System.out.println(ticetDao.save(ticket));
        ticetDao.deleted(1L);

        //https://www.youtube.com/watch?v=S6tQJk6CH38&list=PLt91xr-Pp57QEnGJPuI4R_VqEXikn2a76&index=12 || stop in 17:05;

    }
}
