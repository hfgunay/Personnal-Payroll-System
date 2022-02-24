



public class Facultymember extends Academioffice {   // Faculty member class for keeping faculty members informations.
                                                     // Subclass
    private int addcoursefee;
    
    
    public Facultymember(String name, String surname, String registernumber,String personneltype, int startyear, int currentyear, int week1, int week2, int week3, int week4, double salary, int base, double ssbenefits, double severance, int addcoursefee) {
        
        super(name, surname, registernumber, personneltype, startyear, currentyear, week1, week2, week3, week4, salary, base ,ssbenefits, severance);
        
        this.addcoursefee = addcoursefee;
        
    }
    
    public int additionalcourse(int week1, int week2, int week3, int week4) {  // Function for calculating additional course fee.
        
        int total = 0;
        
        if (week1 >= 48) {
            total += this.addcoursefee * 8;
            
        }
        else {
            total += this.addcoursefee * (week1 - 40);
            
        }
        if (week2 >= 48) {
            total += this.addcoursefee * 8;
           
        }
        else {
            total += this.addcoursefee * (week2 - 40);
            
        }
        if (week3 >= 48) {
            total += this.addcoursefee * 8;
        }
        else {
            total += this.addcoursefee * (week3 - 40);
        }
        if (week4 >= 48) {
            total += this.addcoursefee * 8;
        }
        else {
            total += this.addcoursefee * (week4 - 40);
        }
        return total;
        
        
    }

    public int getAddcoursefee() {
        return addcoursefee;
    }

    public void setAddcoursefee(int addcoursefee) {
        this.addcoursefee = addcoursefee;
    }

    
    
    
}
