package hospitalsorting;
import java.util.List;
/**
 *
 * @author zzano
 */
public class BinarySearch {
    public static Employee searchByName (List<Employee> employees, String target, int low, int high){
        if (low > high){
            return null; 
        }
        
        int mid = (low+high)/2;
        Employee current = employees.get(mid);
        int comparison = current.getName().compareToIgnoreCase(target);
        
        if (comparison == 0){
            return current;
        } else if (comparison > 0) {
            return searchByName(employees, target, low, mid-1);
        } else {
            return searchByName(employees, target, mid+1, high);
        }
    }
}
