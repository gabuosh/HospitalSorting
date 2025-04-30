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
    
    //constructor
    public Employee (String name, ManagerType managertype, DepartmentType departmenttype, EmployeeRole employeerole){
        this.name = name;
        this.managertype = managertype;
        this.departmenttype = departmenttype;
        this.employeerole = employeerole;
    }
    
    //getters and setters
    public String getName(){
        return name;
    }
    public ManagerType getManagerType(){
        return managertype;
    }
    public DepartmentType getDepartment(){
        return departmenttype;
    }
    public EmployeeRole getEmployeeRole(){
        return employeerole;
    }
    
    public String toString(){
        return name + " (" + employeerole + ") - " + departmenttype + " - Manager: " + managertype;
    }
        
}
