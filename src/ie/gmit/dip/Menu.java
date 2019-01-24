package ie.gmit.dip;

import java.util.*;
import java.io.*;
public class Menu {
    private Scanner in;
    private StudentManager sm;
    private boolean keepRunning = true;
    private static final String FILE_NAME = "students.ser";
    
    
    public void start(){
       in = new Scanner(System.in);
       
       load();
       if (sm == null){
       sm = new StudentManager(); 
   }

       
       while (keepRunning){
           showOptions();
                     
           int selection = Integer.parseInt(in.next());
           
           if(selection == 1){ //Add
                addMenu();  
        }else if (selection == 2){//Delete
            deleteMenu();
        }else if (selection == 3){//Search by ID
            searchByID();       
        }else if (selection == 4){//Search by Name
            searchByName();
        }else if (selection == 5){//Output total
            totalMenu();
        }else if (selection == 77){ //Test
            testExpand();
        }else if (selection == 6){//Save
            save();
       }else if (selection == 7){//Quit
            keepRunning = false;
            
               
           }else{ //Invalid input
              System.out.println("Invalid choice!"); 
           }
       }
        
    }
    
    private void showOptions(){
            System.out.println("####################################");
           System.out.println("##      Student Manager v 1.0      #");
           System.out.println("####################################");
           System.out.println("(1) Add a Student. ");
           System.out.println("(2) Delete a Student. ");
           System.out.println("(3) Search for a Student by ID. ");
           System.out.println("(4) Search for a Student by Name. ");
           System.out.println("(5) Total Number of Students. ");
           System.out.println("(6) Save Database. ");
           System.out.println("(7) Quit. ");
           System.out.println("Select an option [1-5] >");
        
    }
    
    private void testExpand(){
       long start = System.currentTimeMillis();
       
       for (int i = 0; i < 1000000; i++){
           sm.add(new Student("S-" + i));
       }
       System.out.println("Time:  " + (System.currentTimeMillis() - start));
       System.out.println(sm.size() + " Students found");
    }
    
    private void load(){
        try{
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            
            sm = (StudentManager) in. readObject();
            in.close();
        }catch(Exception e){
            System.out.println("[Error] Cannot read database. Cause: ");
            e.printStackTrace();
        }
        
    }
    
    private void save(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(sm);
            out.flush();
            out.close();
        }catch(Exception e){
            System.out.println("[Error] Cannot save database. Cause: ");
            e.printStackTrace();
        }
        
        
    }
    
    private void addMenu(){
        System.out.println("Enter Student ID>");
        String sid = in.next();
        
        System.out.println("Enter Student First Name>");
        String fname = in.next();
        
        System.out.println("Enter Student Surname>");
        String sname = in.next();
        
        Date dob = new Date();
        
        Student next = new Student(sid, fname, sname, dob);
        boolean result = sm.add(next);
        
        if (result){
            System.out.println("Student" + sid + " Added okay.");
        }
        System.out.println(sm.size() + " Students found");

    }
    private void deleteMenu(){
        System.out.println(" Enter Student ID>");
        String sid = in.next();
        
        boolean result = sm.delete(sid);
        
        if (result){
            System.out.println("Student" + sid + " deleted okay.");
             System.out.println(sm.size() + " Students found");
        }else{
            System.out.println("No Student found with an ID of " + sid);
        }
        
    }
    private void searchByID(){
        System.out.println(" Enter Student ID>");
        String sid = in.next();
        
        Student s = sm.getStudentByID(sid);
        System.out.println(s);
        
    }
    private void searchByName(){
        System.out.println(" Enter Student First Name>");
        String name = in.next();
        
        Student[] results = sm.getStudentsByFirstName(name);
        for (int i = 0; i < results.length; i++){
            System.out.println(results [i]);
        }
        
    }
    private void totalMenu(){
        int totalStudents = sm.size();
        System.out.println(totalStudents + " found.");
        
    }
}
