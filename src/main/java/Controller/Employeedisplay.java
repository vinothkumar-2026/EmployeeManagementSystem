package Controller;
import java.io.IOException;
import java.util.ArrayList;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import Model.Employeemodel;

@WebServlet("/Employeedisplay")
public class Employeedisplay extends HttpServlet{
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException{
        Employeelogic logic=new Employeelogic();
        ArrayList<Employeemodel> transfer=logic.Alldisplay();
        request.setAttribute("employeeList",transfer);
        request.getRequestDispatcher("Employeedisplay.jsp").forward(request,response);
    }
}