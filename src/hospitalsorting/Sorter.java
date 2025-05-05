package hospitalsorting;
import java.util.List;
/**
 *
 * @author zzano
 */
public class Sorter {
    public static void sort (List<Employee> employees, int n){
        if (n==1){
            return;
        }
        for (int i = 0; i < n-1; i++){
            if (employees.get(i).getName().compareToIgnoreCase(employees.get(i+1).getName())>0){
                Employee temp = employees.get(i);
                employees.set(i, employees.get(i+1));
                employees.set(i+1, temp);
            }
        }
        sort (employees, n-1);
    }
}
