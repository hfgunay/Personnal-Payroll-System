
import java.io.BufferedWriter;                      // Calculate class for file reading, file writing and operations.
import java.io.File;                       
import java.io.FileWriter;
import java.io.IOException;                
import java.nio.charset.StandardCharsets;  
import java.util.ArrayList;
import java.util.Scanner;



public class Calculate {
    
    
    
    public static void readandcalculate(String filename1, String filename2) throws IOException {          // Function for calculating and reading files.

        File file1 = new File(filename1);         // Reading informations from files.                                     
        File file2 = new File(filename2);         //  
        
        ArrayList<Personnel> personnelslist = new ArrayList<Personnel>();         // Personnels informations will be kept in this arraylist.
        
        ArrayList<Personnel> personnelslist2 = new ArrayList<Personnel>();        // Modified Personnels informations will be kept in this arraylist. 
        
        ArrayList<String[]> monitorarlist = new ArrayList<String[]>();            // Monitoring.txt arrays will be kept in this arraylist.
        
        ArrayList<Facultymember> facultylist = new ArrayList<Facultymember>();    // Faculty members informations will be kept in this arraylist.
        
        ArrayList<Assistant> assistantlist = new ArrayList<Assistant>();          // Research assistants informaations will be kept in this arraylist.
        
        ArrayList<Officer> officerlist = new ArrayList<Officer>();                // Officers informations will be kept in this arraylist.
        
        ArrayList<Security> securitylist = new ArrayList<Security>();             // Securitys informations will be kept in this arraylist.
        
        ArrayList<Worker> workerlist = new ArrayList<Worker>();                   // Workers informations will be kept in this arraylist.
        
        ArrayList<Chief> chieflist = new ArrayList<Chief>();                      // Chiefs informations will be kept in this arraylist.
        
        ArrayList<Parttime> parttimelist = new ArrayList<Parttime>();             // Parttime informations will be kept in this arraylist.
        
        
        
        try {
            Scanner sc = new Scanner(file1, StandardCharsets.UTF_8.name());
            
            Scanner sc2 = new Scanner(file2, StandardCharsets.UTF_8.name());
            while (sc.hasNextLine()) {
                String personnel = sc.nextLine();                                 // Personnel.txt  informations seperated and saved in this string array.
                
                String[] personnelarray = personnel.split("\\s+");                //
                
                int startyear = Integer.valueOf(personnelarray[4]);
                
                Personnel personnel1 = new Personnel(personnelarray[0],personnelarray[1],personnelarray[2],personnelarray[3], startyear, 2020, 0, 0, 0, 0,0);
                
                personnelslist.add(personnel1);                                   // Personnels objects will be kept in this arraylist.
                
            } 
                while (sc2.hasNextLine()) {
                
                    String monitoring = sc2.nextLine();                           // Monitoring.txt informations seperated and saced in this string array.
                
                    String[] monitoringarray = monitoring.split("\\s+");          //
                    
                    monitorarlist.add(monitoringarray);                           // 
                    
                  
                }
            
                for (String[] i: monitorarlist) {                                 // for loop, for converting week1, week2, week3, week4  string to integer.
                    for (Personnel p: personnelslist) {
                        if (i[0].equalsIgnoreCase(p.getRegisternumber())){
                            int week1 = Integer.valueOf(i[1]);
                            int week2 = Integer.valueOf(i[2]);
                            int week3 = Integer.valueOf(i[3]);
                            int week4 = Integer.valueOf(i[4]);
                            
                            p.setWeek1(week1);
                            p.setWeek2(week2);
                            p.setWeek3(week3);
                            p.setWeek4(week4);
                            
                            personnelslist2.add(p);
                            
                        }
                    }
                }
                
                for (Personnel p: personnelslist2) {                              // for loop to seperate Personnels attributes by class and calculate salaries.  
                    
                    
                    if(p.getPersonneltype().equals("FACULTY_MEMBER")) {
                        
                        double severance = p.calcseverance(p.getCurrentyear(), p.getStartyear());
                        double ssbenefits = 2600 * 135/100;
                        
                        Facultymember facultymember = new Facultymember(p.getName(), p.getSurname() , p.getRegisternumber(), p.getPersonneltype(), p.getStartyear(), p.getCurrentyear(), p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4(),0, 2600, ssbenefits , severance, 20);
                        
                        double salary = facultymember.getBase() + facultymember.getSeverance() + facultymember.getSsbenefits() + facultymember.additionalcourse(p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4());
                        
                       
                        
                        facultymember.setSalary(salary);
                        facultylist.add(facultymember);
                    }
                     
                    if(p.getPersonneltype().equals("RESEARCH_ASSISTANT")) {
                        
                        double severance = p.calcseverance(p.getCurrentyear(), p.getStartyear());
                        double ssbenefits = 2600 * 105/100;
                        Assistant assistant = new Assistant(p.getName(), p.getSurname() , p.getRegisternumber(), p.getPersonneltype(), p.getStartyear(), p.getCurrentyear(), p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4(), 0, 2600, ssbenefits, severance);
                        
                        double salary = assistant.getBase() + assistant.getSeverance() + assistant.getSsbenefits();
                        
                        assistant.setSalary(salary);
                        
                        assistantlist.add(assistant);
                    }

                    if(p.getPersonneltype().equals("OFFICER")) {
                        
                        double severance = p.calcseverance(p.getCurrentyear(), p.getStartyear());
                        double ssbenefits = 2600 * 65/100;
                        Officer officer = new Officer(p.getName(), p.getSurname() , p.getRegisternumber(), p.getPersonneltype(), p.getStartyear(), p.getCurrentyear(), p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4(), 0, 2600, ssbenefits, severance, 20 );
                        
                        double salary = officer.getBase() + officer.getSeverance() + officer.getSsbenefits() + officer.overwork(p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4());
                        officer.setSalary(salary);
                        
                        officerlist.add(officer);
                        
                    }
                    
                    if(p.getPersonneltype().equals("SECURITY")) {
                        
                        double severance = p.calcseverance(p.getCurrentyear(), p.getStartyear());
                        
                        Security security = new Security(p.getName(), p.getSurname() , p.getRegisternumber(), p.getPersonneltype(), p.getStartyear(), p.getCurrentyear(), p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4(), 0, 10, 15, 0, severance);
                        
                        security.setHoursalary(security.calchoursalary(p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4()));
                        
                        double salary = security.getHoursalary() + security.getSeverance();
                        
                        security.setSalary(salary);
                        
                        securitylist.add(security);
                    }
                    
                    if(p.getPersonneltype().equals("WORKER")) {
                        
                        double severance = p.calcseverance(p.getCurrentyear(), p.getStartyear());
                        
                        Worker worker = new Worker(p.getName(), p.getSurname() , p.getRegisternumber(), p.getPersonneltype(), p.getStartyear(), p.getCurrentyear(), p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4(),0, 10, 11, 105, severance);
                        
                        double salary = worker.getSeverance() + worker.calcsalary(worker.getMax(), worker.getDailypay(), worker.getOverwork(),p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4());
                        
                        worker.setSalary(salary);
                        
                        workerlist.add(worker);
                        
                    }
                    
                    if(p.getPersonneltype().equals("CHIEF")) {
                        
                        double severance = p.calcseverance(p.getCurrentyear(), p.getStartyear());
                        
                        Chief chief = new Chief(p.getName(), p.getSurname() , p.getRegisternumber(), p.getPersonneltype(), p.getStartyear(), p.getCurrentyear(), p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4(),0, 8, 15, 125, severance);
                        
                        double salary = chief.getSeverance() + chief.calcsalary(chief.getMax(), chief.getDailypay(), chief.getOverwork(),p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4());
                        
                        chief.setSalary(salary);
                        
                        chieflist.add(chief);
                        
                        
                    }
                    
                    if(p.getPersonneltype().equals("PARTTIME_EMPLOYEE")) {
                        
                        
                        
                        Parttime parttime = new Parttime(p.getName(), p.getSurname() , p.getRegisternumber(), p.getPersonneltype(), p.getStartyear(), p.getCurrentyear(), p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4(), 0);
                        
                        double salary = parttime.calcsalary(p.getWeek1(), p.getWeek2(), p.getWeek3(), p.getWeek4(), p.getCurrentyear() , p.getStartyear());
                        
                        parttime.setSalary(salary);
                        
                        parttimelist.add(parttime);
                        
                    }
                }
            
            
            
            
       
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        
        // for loops, to write informations by class
        
        for (Facultymember facultymember: facultylist) {
            
                                                                                      // Assign part
            String registernumber = facultymember.getRegisternumber();                // Converting part, to converting yearofstart, salary to string. 
            String name = facultymember.getName();
            String surname = facultymember.getSurname();
            String position = facultymember.getPersonneltype();
            String yearofstart = String.valueOf(facultymember.getStartyear());
            
            
            String salary = String.format("%.2f", facultymember.getSalary());
            
            writefiles(registernumber, name, surname, position, yearofstart, salary);
            
        }
        
        for (Assistant assistant: assistantlist) {                                                  
            
            String registernumber = assistant.getRegisternumber();                    //
            String name = assistant.getName();
            String surname = assistant.getSurname();
            String position = assistant.getPersonneltype();
            String yearofstart = String.valueOf(assistant.getStartyear());
           
            
            String salary = String.format("%.2f", assistant.getSalary());
            
            writefiles(registernumber, name, surname, position, yearofstart, salary);
        }
        
        for (Officer officer: officerlist) {                                         //
            
            String registernumber = officer.getRegisternumber();
            String name = officer.getName();
            String surname = officer.getSurname();
            String position = officer.getPersonneltype();
            String yearofstart = String.valueOf(officer.getStartyear());
            
            String salary = String.format("%.2f", officer.getSalary());
            
            writefiles(registernumber, name, surname, position, yearofstart, salary);
        }
        
        for (Security security: securitylist){                                       //
            
            String registernumber = security.getRegisternumber();
            String name = security.getName();
            String surname = security.getSurname();
            String position = security.getPersonneltype();
            String yearofstart = String.valueOf(security.getStartyear());
            
            
            String salary = String.format("%.2f", security.getSalary());
            
            writefiles(registernumber, name, surname, position, yearofstart, salary);
        }
        
        for (Worker worker: workerlist) {                                           //
            
            String registernumber = worker.getRegisternumber();
            String name = worker.getName();
            String surname = worker.getSurname();
            String position = worker.getPersonneltype();
            String yearofstart = String.valueOf(worker.getStartyear());
          
            String salary = String.format("%.2f", worker.getSalary());
            
            writefiles(registernumber, name, surname, position, yearofstart, salary);
        }
        
        for (Chief chief: chieflist) {
                                                                                    //
            String registernumber = chief.getRegisternumber();
            String name = chief.getName();
            String surname = chief.getSurname();
            String position = chief.getPersonneltype();
            String yearofstart = String.valueOf(chief.getStartyear());
            
            String salary = String.format("%.2f", chief.getSalary());
            
            writefiles(registernumber, name, surname, position, yearofstart, salary);
        }
        
        for (Parttime parttime: parttimelist) {
                                                                                    //
            String registernumber = parttime.getRegisternumber();
            String name = parttime.getName();
            String surname = parttime.getSurname();
            String position = parttime.getPersonneltype();
            String yearofstart = String.valueOf(parttime.getStartyear());
            
            String salary = String.format("%.2f", parttime.getSalary());
            
            writefiles(registernumber, name, surname, position, yearofstart, salary);
        }
    }
    
    // Funciton for creating and writing files.
    
    public static void writefiles(String registernumber, String Name, String Surname, String Position, String Yearofstart, String Salary) throws IOException {
        
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(registernumber + ".txt",true))) {
            
           
            
            String writing = "Name : " + Name + "\n" +
                    "Surname : " + Surname + "\n" +
                    "Registiration Number : " + registernumber + "\n" +
                    "Position : " + Position + "\n" +
                    "Year of Start : " + Yearofstart + "\n" +
                    "Total Salary : " + Salary + " TL";
            
            String[] file = writing.split("\n");
            
            for (String words: file) {
                
                writer.write(words);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            
            System.out.println("An error occured.");
            e.printStackTrace();
        }
        
    }
    
    
}    
    
    

