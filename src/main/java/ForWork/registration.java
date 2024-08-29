package ForWork;

import ForWork.forUsers.Users;
import ForWork.forUsers.usersDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/registration")
public class registration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        {

            try {
                String name = req.getParameter("name");
                String login = req.getParameter("email");
                String password = req.getParameter("password");
                Users users = new Users(name, login, password);
                usersDB.insert(users);
                req.getRequestDispatcher("index.jsp").forward(req,resp);
            } catch (Exception ex) {

                getServletContext().getRequestDispatcher("registration.jsp").forward(req, resp);
            }
        }
    }
}