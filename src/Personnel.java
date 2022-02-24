                                                             
public class Personnel {                                     // Personnel class for keeping personells same informations and methods.
                                                             // Super class
    private String name;
    private String surname;
    private String registernumber;
    private String personneltype;
    private int startyear;
    private int currentyear;
    private int week1;
    private int week2;
    private int week3;
    private int week4;
    private double salary;
    
    public Personnel(String name, String surname, String registernumber,String personneltype, int startyear, int currentyear, int week1, int week2, int week3, int week4, double salary) {
        this.name = name;
        this.surname = surname;
        this.registernumber = registernumber;
        this.personneltype = personneltype;
        this.startyear = startyear;
        this.currentyear = currentyear;
        this.week1 = week1;
        this.week2 = week2;
        this.week3 = week3;
        this.week4 = week4;
        this.salary = salary;
    }
    
    public double calcseverance(int current, int start) {  // Function for calculating severance.
        
        double severancepay;
        
        severancepay = (current - start) * 20 * 0.8 ;
        
        return severancepay;
        
        
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getRegisternumber() {
        return registernumber;
    }

    public void setRegisternumber(String registernumber) {
        this.registernumber = registernumber;
    }
    
    public void setPersonneltype(String personneltype) {
        this.personneltype = personneltype;
    }
    
    public String getPersonneltype() {
        return personneltype;
    }

    public int getStartyear() {
        return startyear;
    }

    public void setStartyear(int startyear) {
        this.startyear = startyear;
    }
    
    public int getCurrentyear() {
        return currentyear;
    }
    
    public void setCurrentyear(int currentyear) {
        this.currentyear = currentyear;
    }
    

    public int getWeek1() {
        return week1;
    }

    public void setWeek1(int week1) {
        this.week1 = week1;
    }

    public int getWeek2() {
        return week2;
    }

    public void setWeek2(int week2) {
        this.week2 = week2;
    }

    public int getWeek3() {
        return week3;
    }

    public void setWeek3(int week3) {
        this.week3 = week3;
    }

    public int getWeek4() {
        return week4;
    }

    public void setWeek4(int week4) {
        this.week4 = week4;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    
    
}
