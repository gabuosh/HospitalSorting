package hospitalsorting;
import java.util.Scanner;
/**
 *
 * @author zzano
 */
public class Validator {
    /**in this method it will check if input was not empty,
     * if the name has one space between, so that we confirm it's a full name,
     * and if it has only alphabetic characters.
    */
    public static String getValidatedName(Scanner sc){
        String name;
        while(true){
            System.out.println("Enter employee full name (at least first and last name):");
            name = sc.nextLine().trim();
            
            if (name.isEmpty()){ //check if its empty
                System.out.println("Name cannot be empty. Input valid name.");
            } else if(!name.contains(" ")){ //check if full name was entered
                System.out.println("Please include at least first and last name with a space between.");
            } else if(!name.matches("[a-zA-Z ]+")){ //check if its only alphabetic characters
                System.out.println("Name must contain only letters and spaces.");
            } else {
                return name;
            }
        }
    }
    
    //method to validate email
    public static String getValidatedEmail(Scanner sc){
        String email;
        while(true){
            System.out.println("Enter employee email (in format zxc@domain.com)");
            email = sc.nextLine().trim();
            
            if(email.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$")){ //this validades local part of email and domain.
                return email;
                
            }else{
                System.out.println("Invalid email format. Please try again.");
            }
        }
    }
    
    //method to validade gender
    public static String getValidatedGender(Scanner sc){
        String gender;
        while (true){
            System.out.println("Enter employee gender (Male/Female): ");
            gender = sc.nextLine().trim();
            
            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female")){
                return gender;
                
            } else {
                System.out.println("Gender must be 'Male' or 'Female'. Try again.");
            }
        }
    }
}
