
public class Security extends Personnel {                    // Security class for keeping securitys informations.
                                                             // Subclass 
    private int hourpay;
    
    private int ftmoney;
    
    private int hoursalary;
  
    private double severance;
    
    public Security(String name, String surname, String registernumber,String personneltype, int startyear, int currentyear, int week1, int week2, int week3, int week4, double salary, int hourpay, int ftmoney, int hoursalary, double severance) {
        
        super(name, surname, registernumber, personneltype, startyear, currentyear, week1, week2, week3, week4, salary);
        
        this.hourpay = hourpay;
        this.ftmoney = ftmoney;
        this.hoursalary = hoursalary;
        this.severance = severance;
        
        
    }
    
    public int calchoursalary(int week1, int week2, int week3, int week4) {   // Function for calculating salary except severance
        
       int total = 0;
       
       if (week1 >= 30 && week1 <= 54) {
           total += (week1 * this.hourpay) + (6 * this.ftmoney);
           
       }
       else if (week1 > 54) {
           total += (54 * this.hourpay) * (6 * this.ftmoney);
       }
       if (week2 >= 30 && week2 <= 54) {
           total += (week2 * this.hourpay) + (6 * this.ftmoney);
           
       }
       else if (week2 > 54) {
           total += (54 * this.hourpay) * (6 * this.ftmoney);
       }
       if (week3 >= 30 && week3 <= 54) {
           total += (week3 * this.hourpay) + (6 * this.ftmoney);
           
       }
       else if (week3 > 54) {
           total += (54 * this.hourpay) * (6 * this.ftmoney);
       }
       if (week4 >= 30 && week4 <= 54) {
           total += (week4 * this.hourpay) + (6 * this.ftmoney);
           
       }
       else if (week4 > 54) {
           total += (54 * this.hourpay) * (6 * this.ftmoney);
       }
       
       return total;
    }

    public int getHourpay() {
        return hourpay;
    }

    public void setHourpay(int hourpay) {
        this.hourpay = hourpay;
    }

    public int getFtmoney() {
        return ftmoney;
    }

    public void setFtmoney(int ftmoney) {
        this.ftmoney = ftmoney;
    }

    
    

    public int getHoursalary() {
        return hoursalary;
    }

    public void setHoursalary(int hoursalary) {
        this.hoursalary = hoursalary;
    }

    public double getSeverance() {
        return severance;
    }

    public void setSeverance(int severance) {
        this.severance = severance;
    }
    
    
}
