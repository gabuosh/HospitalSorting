package hospitalsorting;
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
    
    public String getFirstName(){
        return firstName;
    }
    public String getLastName(){
        return lastName;
    }
    public int getId(){
        return id;
    }
    public String getEmail(){
        return email;
    }
    public String getGender(){
        return gender;
    }
    
    public String toCSV(){
        return id + "," + firstName + "," + lastName + "," + email + "," + gender;
    }
}
