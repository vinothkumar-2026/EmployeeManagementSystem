package Model;

public class Employeemodel{
    private int employeeid;
    private String name;
    private int age;
    private String department;
    private int salary;
    private String email;

    public int getEmployeeid(){
        return employeeid;
    }

    public void setEmployeeid(int employeeid){
        this.employeeid=employeeid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age=age;
    }

    public String getDepartment(){
        return department;
    }

    public void setDepartment(String department){
        this.department=department;
    }

    public int getSalary(){
        return salary;
    }

    public void setSalary(int salary){
        this.salary=salary;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email=email;
    }

    public Employeemodel(int employeeid,String name,int age,String department,int salary,String email){
        this.employeeid=employeeid;
        this.name=name;
        this.age=age;
        this.department=department;
        this.salary=salary;
        this.email=email;
    }

    public Employeemodel(){
    }
}