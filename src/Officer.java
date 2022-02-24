
public class Officer extends Academioffice {            // Officer class for keeping officers informations.
                                                        // Subclass
    private int overworkpay;
    
    
    public Officer(String name, String surname, String registernumber,String personneltype, int startyear, int currentyear, int week1, int week2, int week3, int week4, double salary ,int base, double ssbenefits, double severance, int overworkpay) {
        
        super(name, surname, registernumber, personneltype, startyear, currentyear, week1, week2, week3, week4, salary, base, ssbenefits, severance);
        
        this.overworkpay = overworkpay;
      
        
    }
    
    public int overwork(int week1, int week2, int week3, int week4) {   // Function for calculating over work fee
        
        int total = 0;
        
        if (week1 >= 50) {
            total += this.overworkpay * 10;
        }
        else {
            total += this.overworkpay * (week1 - 40);
        }
        if (week2 >= 50) {
            total += this.overworkpay * 10;
        }
        else {
            total += this.overworkpay * (week2 - 40);
        }
        if (week3 >= 50) {
            total += this.overworkpay * 10;
        }
        else {
            total += this.overworkpay * (week3 - 40);
        }
        if (week4 >= 50) {
            total += this.overworkpay * 10;
        }
        else {
            total += this.overworkpay * (week4 - 40);
        }
        return total;        
    }

    public int getOverwork() {
        return overworkpay;
    }

    public void setOverwork(int overwork) {
        this.overworkpay = overwork;
    }

    
    
    
}
