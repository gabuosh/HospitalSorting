package hospitalsorting;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author zzano
 * Class will generate random user data, convert that into object RandomEmployee and then to Employee,
 * export to a CSV file and use them in main app
 */
public class UserDataGenerator {
    
    static String[] firstNames = {"Monica", "Sarah", "Charles", "Amanda", "Peter", "Joseph", "Tom", "Natalie", "Helga", "Philip", "Oscar", "Conor", "Demi", "Emma", "Claire", "Stephen", "Richard", "Eliott"};
    static String[] lastNames = {"Friedrich", "Moore", "Jagger", "Ciccone", "Sarkisian", "Holt", "Allman", "Waters", "Fenty", "Brown", "Jones", "Smith", "Kuster", "Miller", "Davis", "Garcia", "Johnson", "Jones"};
    static String[] domains = {"gmail.com", "yahoo.com", "outlook.com", "hotmail.com", "icloud.com", "aol.com", "live.com"};
    
    static Random random = new Random();
    
    //Generate single random user - adapted from given code
    public static RandomEmployee RandomEmployee(){
        int id = 100 + random.nextInt(900); //random id between 100 and 999
        String firstName = firstNames[random.nextInt(firstNames.length)];
        String lastName = lastNames[random.nextInt(lastNames.length)];
        String email = (firstName.charAt(0) + lastName + random.nextInt(100) + "@" + domains[random.nextInt(domains.length)]).toLowerCase();
        String gender = random.nextBoolean() ? "Male" : "Female";
        return new RandomEmployee(id, firstName, lastName, email, gender);
    }
    
    //method to generate a list of Users - adapted from given code
    public static List<RandomEmployee> generateUserList(int numberOfUsers){
        List<RandomEmployee> userList = new ArrayList<>();
        for (int i=0; i<numberOfUsers; i++){
            userList.add(RandomEmployee());
        }
        return userList;
    }
    
    //method to write users to CSV file - adapted from given code
    public static void writeUsersToCSV(List<RandomEmployee> users, String filename){
        try (FileWriter writer = new FileWriter(filename)){
            //write header
            writer.write("ID, First Name, Last Name, Email, Gender\n");
            //write each user's data
            for (RandomEmployee user : users){
                writer.write(user.toCSV() + "\n");
            }
            System.out.println("Data successfully written to " + filename);
        } catch (IOException e){
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args){
        List<RandomEmployee> users = generateUserList(20); //generate 20 users
        writeUsersToCSV(users, "random_users.csv"); //Save to CSV file
    }
    
    public static Employee convertToEmployee(RandomEmployee rand){
    String fullName = rand.getFirstName() + " " + rand.getLastName();
    //assign random values for role
    EmployeeRole role = EmployeeRole.values()[random.nextInt(EmployeeRole.values().length)];
    
    //assign random manager depending on employee role
    ManagerType manager;
    switch (role){
        case Doctor:
            manager = random.nextBoolean() ? ManagerType.Director : ManagerType.Senior_Medical_Officer;
            break;
        case Nurse:
        case Nursing_Sisters:
        case Midwives:
            manager = random.nextBoolean() ? ManagerType.Matron : ManagerType.Chief_Pharmacist;
            break;
        case Clerical_Staff:
        case Simple_Support_Staff:
            manager = ManagerType.Administrative_Officer;
            break;
        case Clerks:
            manager = ManagerType.Accountant;
            break;
        case Paramedical_Staff:
        case Support_Staff_Paramedical:
            manager = random.nextBoolean() ? ManagerType.Senior_Medical_Officer : ManagerType.Matron;
            break;
        default:
            manager = ManagerType.Director; //if it fails it will report to director
            break;
    }
    //assign DepartmentType based on role
    DepartmentType department;
    switch (role){
        case Clerical_Staff:
        case Simple_Support_Staff:
        case Clerks:
            department = DepartmentType.General;
            break;
        default:
            department = DepartmentType.values()[random.nextInt(DepartmentType.values().length)];
            break;
    }
    
    return new Employee(fullName, manager, department, role, rand.getId(), rand.getEmail(), rand.getGender());
    }
    
    /** method to take the filename (CSV file path),
    *   parse line by line, builds object employee from each valid row,
    *   returns a list<Employee> containing all created employees
    */
    public static List<Employee> loadFromApplicantsFile(String filename){
        List<Employee> loadedEmployees = new ArrayList<>(); //loadedEmployees holds created employees
        Random rand = new Random(); //rand generates random id and role
        
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))){
            String line = reader.readLine(); //skips reading the header/column names
            
            while ((line = reader.readLine()) != null){
                List<String> parts = parseCSVLine(line); //uses parseCSVline() to split lines into fields
                if (parts.size() < 9) continue; //skips malformed on loading CSV file
                
                //puts in columns
                String firstName = parts.get(0);
                String lastName = parts.get(1);
                String gender = parts.get(2);
                String email = parts.get(3);
                String departmentRaw = parts.get(4);
                String positionRaw = parts.get(5);
                
                String fullName = firstName + " " + lastName; //constructs full name, class employee has only one name variable
                int id = 100 + rand.nextInt(900);
                
                //Try to map DepartmentType and ManagerType
                DepartmentType department;
                try{
                    department = DepartmentType.valueOf(departmentRaw.replace(" ", "_").toUpperCase()); //convert string to enum
                }catch(Exception e){
                    department = DepartmentType.General; //if it fails, just put in general department
                }
                
                ManagerType manager;
                try{
                   manager = ManagerType.valueOf(positionRaw.replace("-", "_").toUpperCase()); //convert string to enum
                }catch (Exception e){
                    manager = ManagerType.Director; //if it fails, just reports to Director
                }
                
                //Pick random role for employee based on employeerole enum
                EmployeeRole role = EmployeeRole.values()[rand.nextInt(EmployeeRole.values().length)];
                
                Employee emp = new Employee(fullName, manager, department, role, id, email, gender); //constructs object employee with generated info
                loadedEmployees.add(emp); //adds to the list loadedEmployees
            }
        } catch(IOException e){
            System.out.println("Error reading aplicants file");
            e.printStackTrace();
        }
        return loadedEmployees;
    }
    //CSV line parser
    public static List<String> parseCSVLine(String line){
        List<String> result = new ArrayList<>(); //result stores parsed values from the line
        StringBuilder sb = new StringBuilder(); //sb builds characters for the current field
        boolean insideQuotes = false; //insideQuotes tracks whether we're inside "quoted" CSV sections
        
        for (int i = 0; i<line.length(); i++){
            char c = line.charAt(i);
            
            if (c == '"'){
                insideQuotes = !insideQuotes; //toggle quoted section
            } else if (c == ',' && !insideQuotes){
                result.add(sb.toString().trim());
                sb.setLength(0);
            } else {
                sb.append(c);
            }
        }
        result.add(sb.toString().trim()); //add last field
        return result;
    }
}


