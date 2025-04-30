package hospitalsorting;
import java.util.ArrayList;
import java.util.Scanner;
//@author zzanoni

public class HospitalSorting {
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter employee name: ");
        String name = sc.nextLine();
        
        //select type of manager
        System.out.println("Select a manager type: ");
        for (int i = 0; i < ManagerType.values().length; i++){
            System.out.println((i + 1) + ". " + ManagerType.values()[i]);
        }
        int managerChoice = sc.nextInt();
        sc.nextLine();
        ManagerType managertype = ManagerType.values()[managerChoice - 1];
        
        //select department
        System.out.println("Select a department: ");
        for (int i = 0; i < DepartmentType.values().length; i++){
            System.out.println((i + 1) + ". " + DepartmentType.values()[i]);
        }
        int departmentChoice = sc.nextInt();
        sc.nextLine();
        DepartmentType departmenttype = DepartmentType.values()[departmentChoice -1];
        
        //select employee role
        System.out.println("Select a role for the employee: ");
        for (int i = 0; i < EmployeeRole.values().length; i++){
            System.out.println((i + 1) + ". " + EmployeeRole.values()[i]);
        }
        int roleChoice = sc.nextInt();
        sc.nextLine();
        EmployeeRole employeerole = EmployeeRole.values()[roleChoice - 1];
        
        //create and store new employee
        Employee newEmployee = new Employee(name, managertype, departmenttype, employeerole);
        employees.add(newEmployee);
        
        System.out.println("Employee added successfully: " + newEmployee + "\n");
    }
    
}
