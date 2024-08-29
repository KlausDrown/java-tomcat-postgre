package ForWork;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/newVersion")
public class newVersion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("newVersion.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("Send user data".equals(req.getParameter("sender"))) {
            resp.getWriter().write("first");
        }
        if("Send the company name".equals(req.getParameter("sender")))
        {
            resp.getWriter().write("Second");
        }
    }
}
