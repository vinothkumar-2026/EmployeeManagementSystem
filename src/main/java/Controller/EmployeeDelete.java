package Controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Employeemodel;

@WebServlet("/EmployeeDelete")
public class EmployeeDelete extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        int employeeid=Integer.parseInt(request.getParameter("employeeid"));
        Employeelogic logic=new Employeelogic();
        Employeemodel employee=logic.getEmployeeById(employeeid);
        if(employee!=null){
            request.setAttribute("employee",employee);
            request.getRequestDispatcher("EmployeeDelete.jsp").forward(request,response);
        }else{
            response.getWriter().println("Employee not found");
        }
    }

    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        int employeeid=Integer.parseInt(request.getParameter("employeeid"));
        Employeemodel employee=new Employeemodel();
        employee.setEmployeeid(employeeid);
        Employeelogic logic=new Employeelogic();
        String result=logic.employeedelete(employee);
        if("Employee deleted successfully".equals(result)){
            response.sendRedirect("Employeedisplay");
        }else{
            response.setContentType("text/html");
            response.getWriter().println(result);
            response.getWriter().println("<br><a href='Employeedisplay'>Back</a>");
        }
    }
}