
public class Fulltime extends Personnel{                       // Fulltime class for keeping full-time employees same informations.
                                                               // Subclass
    private int max;                                           // Worker class and Chief classes super class.
    
    private int overwork;
    
    private int dailypay;
    
    private double severance;
    
    public Fulltime(String name, String surname, String registernumber,String personneltype, int startyear, int currentyear, int week1, int week2, int week3, int week4, double salary, int max, int overwork, int dailypay, double severance) {
        
        super(name, surname, registernumber, personneltype, startyear, currentyear, week1, week2, week3, week4, salary);
        
        this.max = max;
        this.overwork = overwork;
        this.dailypay = dailypay;
        this.severance = severance;
        
    }
    
    public double calcsalary(int max, int dailypay, int overworkpay, int week1, int week2, int week3, int week4) {  // Function for calculating salary except severance
        
        double total = 0 ;
        
        if (week1 >= 40 && week1 <= 40 + max ) {
            total += ((week1 - 40) * overworkpay) + (5 * dailypay);
        }
        else if (week1 > 40 + max) {
            total += (max * overworkpay) + (5 * dailypay);
        }
        if (week2 >= 40 && week2 <= 40 + max ) {
            total += ((week2 - 40) * overworkpay) + (5 * dailypay);
        }
        else if (week2 > 40 + max) {
            total += (max * overworkpay) + (5 * dailypay);
        }
        if (week3 >= 40 && week3 <= 40 + max ) {
            total += ((week3 - 40) * overworkpay) + (5 * dailypay);
        }
        else if (week3 > 40 + max) {
            total += (max * overworkpay) + (5 * dailypay);
        }
        if (week4 >= 40 && week4 <= 40 + max ) {
            total += ((week4 - 40) * overworkpay) + (5 * dailypay);
        }
        else if (week4 > 40 + max) {
            total += (max * overworkpay) + (5 * dailypay);
        }
        
        return total;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getOverwork() {
        return overwork;
    }

    public void setOverwork(int overwork) {
        this.overwork = overwork;
    }

    public int getDailypay() {
        return dailypay;
    }

    public void setDailypay(int dailypay) {
        this.dailypay = dailypay;
    }
    
    
   
    public double getSeverance() {
        return severance;
    }

    public void setSeverance(int severance) {
        this.severance = severance;
    }
    
    
}
