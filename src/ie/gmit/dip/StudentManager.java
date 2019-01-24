package ie.gmit.dip;

import java.io.*;
public class StudentManager implements Serializable{
    private static final int INITIAL_CAPACITY = 10;
    private Student[] students = null;
    
    public StudentManager(){
        students = new Student[INITIAL_CAPACITY];
    }
    
    public boolean add(Student s){
        for (int i = 0; i < students.length; i++){
            if (students[i] == null){
                students[i] = s;
                return true;
        }

    }
        if (students.length == Integer.MAX_VALUE){
            return false;    
        }
        
      expand();
      students[students.length - 1] = s;
        return true;
    }
    private void expand(){
        Student[] temp = new Student[students.length + 1]; //Inefficent
        for (int i = 0; i <students.length; i++){
            temp[i] = students [i];
        }
        students = temp;
        
    }
    
    public boolean delete(String sid){
        for (int i = 0; i < students.length; i++){
            if (students[i] != null && students[i].getSID().equals(sid)){
                students[i] = null;
                return true;
            }
        }
        
        return false;
    }
    
    public Student getStudentByID(String sid){
        for (int i = 0; i < students.length; i++){
            if (students[i] != null && students[i].getSID().equals(sid)){
                students[i] = null;
                return students[i];
            }
        }


        
        return null;
    }
    
    public Student[] getStudentsByFirstName(String fname){
        int total = 0;
        for (int i = 0; i < students.length; i++){
            if (students[i] != null && students[i] .getFirstName().equalsIgnoreCase(fname)){
                total++;
            }
        }
        if (total > 0){
            Student[] temp = new Student[total];
            int index = 0;
            
            for (int i = 0; i < students.length; i++){
                 if (students[i] != null && students[i] .getFirstName().equalsIgnoreCase(fname)){
                    temp[index] = students[i];
                    index++;    
                 }

        }
        
        return temp;
            
        }else{
            
    return null;
    }


}


    public int size(){
        int total = 0;
        for (int i = 0; i < students.length; i++){
            if(students[i] != null){
                total++;
            }
    }

        
        return total;
    }
}
