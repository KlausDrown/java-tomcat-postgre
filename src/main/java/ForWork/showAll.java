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

        ArrayList<Users> users = usersDB.select();
        req.setAttribute("users", users);
        req.getRequestDispatcher("showAll.jsp").forward(req, resp);
    }
}
