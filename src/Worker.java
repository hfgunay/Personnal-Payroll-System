
public class Worker extends Fulltime {                                     // Worker class for keeping workers informations.
                                                                           // Subclass
    public Worker(String name, String surname, String registernumber,String personneltype, int startyear, int currentyear, int week1, int week2, int week3, int week4, double salary, int max, int overwork, int dailypay, double severance) {
        
        super(name, surname, registernumber, personneltype, startyear, currentyear, week1, week2, week3, week4, salary, max, overwork, dailypay, severance);
    }
    
    
}
