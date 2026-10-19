package Controller;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.DbConnection;
import Model.Employeemodel;

public class Employeelogic{
    public String storeemployeelogic(Employeemodel employee){
        String result=null;
        String insert="insert into employees(employee_id,name,age,department,salary,email) values(?,?,?,?,?,?)";
        try{
            Connection conn=DbConnection.dbconnection();
            PreparedStatement ps=conn.prepareStatement(insert);
            ps.setInt(1,employee.getEmployeeid());
            ps.setString(2,employee.getName());
            ps.setInt(3,employee.getAge());
            ps.setString(4,employee.getDepartment());
            ps.setInt(5,employee.getSalary());
            ps.setString(6,employee.getEmail());
            int row=ps.executeUpdate();
            if(row==1){
                result="Employee inserted successfully";
            }
            ps.close();
            conn.close();
        }catch(SQLException e){
            result="Insert error: "+e.getMessage();
        }
        return result;
    }

    public ArrayList<Employeemodel> Alldisplay(){
        ArrayList<Employeemodel> transfer=new ArrayList<>();
        String display="select * from employees";
        try{
            Connection conn=DbConnection.dbconnection();
            PreparedStatement ps=conn.prepareStatement(display);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Employeemodel employee=new Employeemodel();
                employee.setEmployeeid(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getInt("salary"));
                employee.setEmail(rs.getString("email"));
                transfer.add(employee);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("Display error: "+e.getMessage());
        }
        return transfer;
    }

    public Employeemodel getEmployeeById(int employeeid){
        Employeemodel employee=null;
        String sql="select * from employees where employee_id=?";
        try{
            Connection conn=DbConnection.dbconnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,employeeid);
            ResultSet rs=ps.executeQuery();
            if(rs.next()){
                employee=new Employeemodel();
                employee.setEmployeeid(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getInt("salary"));
                employee.setEmail(rs.getString("email"));
            }
            rs.close();
            ps.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("Get employee error: "+e.getMessage());
        }
        return employee;
    }

    public String update(Employeemodel employee){
        String result=null;
        String sql="update employees set department=?,salary=? where employee_id=?";
        try{
            Connection conn=DbConnection.dbconnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,employee.getDepartment());
            ps.setInt(2,employee.getSalary());
            ps.setInt(3,employee.getEmployeeid());
            int row=ps.executeUpdate();
            if(row==1){
                result="Employee updated successfully";
            }else{
                result="Employee not found";
            }
            ps.close();
            conn.close();
        }catch(SQLException e){
            result="Update error: "+e.getMessage();
        }
        return result;
    }

    public String employeedelete(Employeemodel employee){
        String result=null;
        String sql="delete from employees where employee_id=?";
        try{
            Connection conn=DbConnection.dbconnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setInt(1,employee.getEmployeeid());
            int row=ps.executeUpdate();
            if(row==1){
                result="Employee deleted successfully";
            }else{
                result="Employee not found";
            }
            ps.close();
            conn.close();
        }catch(SQLException e){
            result="Delete error: "+e.getMessage();
        }
        return result;
    }

    public ArrayList<Employeemodel> searchByDepartment(String department){
        ArrayList<Employeemodel> transfer=new ArrayList<>();
        String sql="select * from employees where department=?";
        try{
            Connection conn=DbConnection.dbconnection();
            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,department);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){
                Employeemodel employee=new Employeemodel();
                employee.setEmployeeid(rs.getInt("employee_id"));
                employee.setName(rs.getString("name"));
                employee.setAge(rs.getInt("age"));
                employee.setDepartment(rs.getString("department"));
                employee.setSalary(rs.getInt("salary"));
                employee.setEmail(rs.getString("email"));
                transfer.add(employee);
            }
            rs.close();
            ps.close();
            conn.close();
        }catch(SQLException e){
            System.out.println("Search error: "+e.getMessage());
        }
        return transfer;
    }
}