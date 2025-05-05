package hospitalsorting;
import java.util.ArrayList;
import java.util.Scanner;
//@author zzanoni

public class HospitalSorting {
    static ArrayList<Employee> employees = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        
        //add a loop for menu, so the user can interact multiple times
        while (running){
            System.out.println("\n Choose an option:");
            for (int i = 0; i < MenuOption.values().length; i++){
                System.out.println((i + 1) + ". " + MenuOption.values()[i]);
            }
            int choice = sc.nextInt();
            sc.nextLine();
            
            switch(MenuOption.values()[choice - 1]){
                
                case Add_Record:
                    System.out.println("\n Enter employee name: ");
                    String name = sc.nextLine();
                    
                    //select employee role
                    System.out.println("Select a role for the employee: ");
                    for (int i = 0; i < EmployeeRole.values().length; i++){
                        System.out.println((i + 1) + ". " + EmployeeRole.values()[i]);
                    }
                    int roleChoice = sc.nextInt();
                    sc.nextLine();
                    EmployeeRole employeerole = EmployeeRole.values()[roleChoice - 1];
        
                    //select department
                    System.out.println("Select the employee department: ");
                    for (int i = 0; i < DepartmentType.values().length; i++){
                        System.out.println((i + 1) + ". " + DepartmentType.values()[i]);
                    }
                    int departmentChoice = sc.nextInt();
                    sc.nextLine();
                    DepartmentType departmenttype = DepartmentType.values()[departmentChoice -1];
                    
                    //select type of manager
                    System.out.println("Select a manager for the employee: ");
                    for (int i = 0; i < ManagerType.values().length; i++){
                        System.out.println((i + 1) + ". " + ManagerType.values()[i]);
                    }
                    int managerChoice = sc.nextInt();
                    sc.nextLine();
                    ManagerType managertype = ManagerType.values()[managerChoice - 1];
        
                    //create and store new employee
                    Employee newEmployee = new Employee(name, managertype, departmenttype, employeerole);
                    employees.add(newEmployee);
        
                    System.out.println("Employee added successfully: " + newEmployee + "\n");
                    break;
                    
                case Sort:
                    if (employees.isEmpty()){
                        System.out.println("No employees to be sorted.");
                    } else {
                        Sorter.sort(employees, employees.size());
                        System.out.println("Employees sorted aphabetically by name: \n");
                        for (int i = 0; i < Math.min(20, employees.size()); i++){
                            System.out.println(employees.get(i));
                        }
                    }
                    break;
                    
                case Search:
                    System.out.println("Sort not implemented yet...");
                    break;
                    
                case Exit:
                    running = false;
                    System.out.println("Exiting program... ");
                    break;
            }
        }
        

    }
    
}
