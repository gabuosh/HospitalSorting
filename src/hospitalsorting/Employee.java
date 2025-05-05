/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospitalsorting;

/**
 *
 * @author zzano
 */
public class Employee {
    private String name;
    private ManagerType managertype;
    private DepartmentType departmenttype;
    private EmployeeRole employeerole;
    //from RandomEmployee
    private int id;
    private String email;
    private String gender;
    
    //constructor
    public Employee (String name, ManagerType managertype, DepartmentType departmenttype, EmployeeRole employeerole, int id, String email, String gender){
        this.name = name;
        this.managertype = managertype;
        this.departmenttype = departmenttype;
        this.employeerole = employeerole;
        this.id = id;
        this.email = email;
        this.gender = gender;
    }
    
    //getters and setters
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public ManagerType getManagerType(){
        return managertype;
    }
    public void setManagerType(ManagerType managertype){
        this.managertype = managertype;
    }
    public DepartmentType getDepartment(){
        return departmenttype;
    }
    public void setDepartmentType(DepartmentType departmenttype){
        this.departmenttype = departmenttype;
    }
    public EmployeeRole getEmployeeRole(){
        return employeerole;
    }
    public void setEmployeeRole(EmployeeRole employeerole){
        this.employeerole = employeerole;
    }
    public int getid(){
        return id;
    }
    public void setid(int id){
        this.id = id;
    }
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getGender(){
        return gender;
    }
    public void setGender(String gender){
        this.gender = gender;
    }
    
    public String toString(){
        return name + " (" + employeerole + ") - " + departmenttype + " - Manager: " + managertype;
    }
        
}
