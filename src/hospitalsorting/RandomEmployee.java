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
public class RandomEmployee {
    int id;
    String firstName, lastName, email, gender;
    
    public RandomEmployee(int id, String firstName, String lastName, String email, String gender){
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }
    
    public String toCSV(){
        return id + "," + firstName + "," + lastName + "," + email + "," + gender;
    }
}
