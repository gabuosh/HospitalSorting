package hospitalsorting;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;
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
                    int id = 100 + new Random().nextInt(900);
                    
                    System.out.println("\n Enter employee name: ");
                    String name = sc.nextLine();
                    
                    System.out.println("\n Enter employee email: - in format abc@domain.com");
                    String email = sc.nextLine();
                    
                    System.out.println("\n Enter employee gender: - Male/Female");
                    String gender = sc.nextLine();
                    
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
                    Employee newEmployee = new Employee(name, managertype, departmenttype, employeerole, id, email, gender);
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
                    if (employees.isEmpty()){
                        System.out.println("Employee list is empty. Please add or generate employees first.");
                        break;
                    }
                    
                    System.out.println("Enter the employee's name to search for: ");
                    String searchName = sc.nextLine();
                    
                    //Binary search - list must be sorted first
                    Employee found = BinarySearch.searchByName(employees, searchName, 0, employees.size()-1);
                    
                    if (found != null){
                        System.out.println("Employee found:\n" + found);
                    } else {
                        System.out.println("No employee records with name: " + searchName);
                    }
                    break;
                    
                case Random_Generate_Records:
                    List<RandomEmployee> randoms = UserDataGenerator.generateUserList(20);
                    for(RandomEmployee r : randoms){
                        employees.add(UserDataGenerator.convertToEmployee(r));
                    }
                    
                    System.out.println("20 random employees generated and added successfully. \n");
                    break;
                    
                case Load_From_File:
                    System.out.println("Loading employees from Applicants_Form.txt");
                    List<Employee> loaded = UserDataGenerator.loadFromApplicantsFile("Applicants_Form.txt");
                    employees.addAll(loaded);
                    System.out.println(loaded.size() + " employees loaded from applicants file. \n");
                    break;
                    
                case Exit:
                    running = false;
                    System.out.println("Exiting program... ");
                    break;
            }
        }

    }
    
}
