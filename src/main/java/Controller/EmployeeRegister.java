package Controller;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Employeemodel;

@WebServlet("/EmployeeRegister")
public class EmployeeRegister extends HttpServlet{
    protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        int employeeid=Integer.parseInt(request.getParameter("employeeid"));
        String name=request.getParameter("name");
        int age=Integer.parseInt(request.getParameter("age"));
        String department=request.getParameter("department");
        int salary=Integer.parseInt(request.getParameter("salary"));
        String email=request.getParameter("email");

        Employeemodel employee=new Employeemodel(employeeid,name,age,department,salary,email);
        Employeelogic logic=new Employeelogic();
        String result=logic.storeemployeelogic(employee);

        if("Employee inserted successfully".equals(result)){
            response.sendRedirect("Employeedisplay");
        }else{
            response.setContentType("text/html");
            response.getWriter().println("<h3>"+result+"</h3>");
            response.getWriter().println("<a href='EmployeeRegister.jsp'>Go Back</a>");
        }
    }
}