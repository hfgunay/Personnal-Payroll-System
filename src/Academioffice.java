
public class Academioffice extends Personnel {    // Academioffice class for keeping academicians and officers same informations.
                                                  // Subclass
    private int base;                             // Facultymember class, Assistant class and Officer classes superclass. 
    private double ssbenefits;
    private double severance;
   
    
    public Academioffice(String name, String surname, String registernumber,String personneltype, int startyear, int currentyear, int week1, int week2, int week3, int week4, double salary, int base, double ssbenefits, double severance) {
        
        super(name, surname, registernumber, personneltype, startyear, currentyear, week1, week2, week3, week4, salary);
        this.base = base;
        this.ssbenefits = ssbenefits;
        this.severance = severance;
        
    }
   

    public int getBase() {
        return base;
    }

    public void setBase(int base) {
        this.base = base;
    }

    public double getSsbenefits() {
        return ssbenefits;
    }

    public void setSsbenefits(int ssbenefits) {
        this.ssbenefits = ssbenefits;
    }

    public double getSeverance() {
        return severance;
    }

    public void setSeverance(int severance) {
        this.severance = severance;
    }

    
    
    
}
