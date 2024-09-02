package ForWork;


import ForWork.forUsers2.departmentDB;
import ForWork.forUsers2.Department;
import ForWork.forUsers2.Employee;
import ForWork.forUsers2.employeeDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.ArrayList;

//employeePage
//departmentPage
@WebServlet("/newVersion")
public class newVersion extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("currentEmployeePage", req.getParameter("employeePage"));
        req.setAttribute("currentDepartmentPage", req.getParameter("departmentPage"));
            int employeePage = 0;
            int employeeCount = employeeDB.selectCount();
            int employeePageNumber = employeeCount / 5;
            if (employeeCount % 5 != 0) {
                employeePageNumber++;
            }
            int[] selectPageEmployee = new int[employeePageNumber];
            for (int i = 1; i < (employeePageNumber + 1); i++) {
                selectPageEmployee[i - 1] = i;
            }


        int departmentPage = 0;
        int departmentCount = departmentDB.selectCount();
        int departmentPageNumber = departmentCount / 5;
        if (departmentCount % 5 != 0) {
            departmentPageNumber++;
        }
        int[] selectPageDepartment = new int[departmentPageNumber];
        for (int i = 1; i < (departmentPageNumber + 1); i++) {
            selectPageDepartment[i - 1] = i;
        }

        req.setAttribute("employeePageNumber", employeePageNumber);
        req.setAttribute("departmentPageNumber", departmentPageNumber);

        ArrayList<Department> departments = departmentDB.select();
        ArrayList<Employee> employees = employeeDB.select();

        req.setAttribute("employees", employees);
        req.setAttribute("departments", departments);

            req.getRequestDispatcher("newVersion.jsp").forward(req,resp);


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("Send user data".equals(req.getParameter("sender"))) {

            String path = req.getContextPath() + "?employeePage="+1+"&&departmentPage"+1;
            try {
                String name = req.getParameter("name");
                String login = req.getParameter("email");
                String password = req.getParameter("password");
                int department_id = Integer.parseInt(req.getParameter("selection"));
                Employee employee = new Employee(name, login, password, department_id);
                employeeDB.insert(employee);
            }catch (Exception e){

            }finally {
                resp.sendRedirect(path);
            }

        }
        if("Send the department name".equals(req.getParameter("sender")))
        {
            String path = req.getContextPath() + "?employeePage="+1+"&&departmentPage"+1;
            try {
                String name = req.getParameter("companyName");
                Department department = new Department(name);
                departmentDB.insert(department);
            }catch (Exception e){

            }finally {
                resp.sendRedirect(path);
            }

        }
        if("Delete an employee by id".equals(req.getParameter("sender"))){
            String path = req.getContextPath() + "?employeePage="+1+"&&departmentPage"+1;
            try {
                resp.getWriter().write(req.getParameter("employeeDelete"));
                employeeDB.delete(Integer.parseInt(req.getParameter("employeeDelete")));
            }catch (Exception e){

            }
            finally {
                resp.sendRedirect(path);
            }

        }
        if("Delete a department by id".equals(req.getParameter("sender"))){
            String path = req.getContextPath() + "?employeePage="+1+"&&departmentPage"+1;
            try {
                resp.getWriter().write(req.getParameter("departmentDelete"));
                departmentDB.delete(Integer.parseInt(req.getParameter("departmentDelete")));
            }catch (Exception e){

            }
            finally {
                resp.sendRedirect(path);
            }
        }
    }
}
