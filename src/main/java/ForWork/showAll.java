package ForWork;

import ForWork.forUsers.Users;
import ForWork.forUsers.usersDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/showAll")
public class showAll extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int count = usersDB.selectCount();
        int numbOfPage = count / 5;
        if (count % 5 != 0) {numbOfPage++;}
        req.setAttribute("numbOfPage", numbOfPage);
        req.getRequestDispatcher("showAll.jsp").forward(req, resp);
//        ArrayList<Users> users = usersDB.select();
//        req.setAttribute("users", users);
//        req.getRequestDispatcher("showAll.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int pag=0;
        int count = usersDB.selectCount();
        int numbOfPage = count / 5;
        if (count % 5 != 0) {numbOfPage++;}
        req.setAttribute("numbOfPage", numbOfPage);
        try {
            pag = Integer.parseInt(req.getParameter("pag"));
        }
        catch (Exception e)
        {
            pag = 0;
        }
        finally {
            ArrayList<Users> users = usersDB.select(pag);
            req.setAttribute("users", users);
            req.getRequestDispatcher("showAll.jsp").forward(req, resp);
        }
    }
}
