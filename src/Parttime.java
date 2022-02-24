
public class Parttime extends Personnel {        // Parttime class for keeping part-time employees informations.
                                                 // Subclass
    
    
    public Parttime(String name, String surname, String registernumber,String personneltype, int startyear, int currentyear, int week1, int week2, int week3, int week4, double salary) {
        
        super(name, surname, registernumber, personneltype, startyear, currentyear, week1, week2, week3, week4, salary);
        
        
    }
    
    public double calcsalary(int week1, int week2, int week3, int week4, int currentyear, int startyear) { // Function for calculating salary.
        
        double totalsalary = 0;
        
        double totalhour = 0;
        
        if(week1 > 9 && week1 < 21 ) {
            
            totalhour += week1;
        }
        else if (week1 > 20) {
            totalhour += 20;
        }
        
        if(week2 > 9 && week2 < 21 ) {
            
            totalhour += week2;
        }
        else if (week2 > 20) {
            totalhour += 20;
        }
         
        if(week3 > 9 && week3 < 21 ) {
            
            totalhour += week3;
        }
        else if (week3 > 20) {
            totalhour += 20;
        }
         
        if(week4 > 9 && week4 < 21 ) {
            
            totalhour += week4;
        }
        else if (week4 > 20) {
            totalhour += 20;
        }
         
        totalsalary += (currentyear - startyear) * 20 * 0.8 + (totalhour * 18) ;
        
        
        return totalsalary;
    }

  
    
    
}
