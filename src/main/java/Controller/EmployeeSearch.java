package Controller;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Employeemodel;

@WebServlet("/EmployeeSearch")
public class EmployeeSearch extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        String department=request.getParameter("department");
        if(department==null||department.trim().isEmpty()){
            request.getRequestDispatcher("EmployeeSearch.jsp").forward(request,response);
            return;
        }
        Employeelogic logic=new Employeelogic();
        ArrayList<Employeemodel> transfer=logic.searchByDepartment(department.trim());
        request.setAttribute("employeeList",transfer);
        request.setAttribute("department",department.trim());
        request.getRequestDispatcher("EmployeeSearch.jsp").forward(request,response);
    }
}