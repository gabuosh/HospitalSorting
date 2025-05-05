package hospitalsorting;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 *
 * @author zzano
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
    
    //random values
    ManagerType manager = ManagerType.values()[random.nextInt(ManagerType.values().length)];
    DepartmentType department = DepartmentType.values()[random.nextInt(DepartmentType.values().length)];
    EmployeeRole role = EmployeeRole.values()[random.nextInt(EmployeeRole.values().length)];
        
    return new Employee(fullName, manager, department, role, rand.getId(), rand.getEmail(), rand.getGender());
    }
}
