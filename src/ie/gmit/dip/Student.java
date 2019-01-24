package ie.gmit.dip;

import java.util.*;
import java.io.*;
public class Student implements Serializable{
    private String sid;
    private String firstName;
    private String surname;
    private Date dob;
    private Address address;
    private Course course;
    
   public Student(String sid){
       this.sid = sid;
   } 
   
   public Student(String sid, String fname, String sname, Date dob){
       this(sid);
       this.firstName = fname;
       this.surname = sname;
       this.dob = dob;
       
   }
    
    public void setAddress(Address a){
        this.address = a;    
    }   
    public Address getAddress(){
        return this.address;
    }
    
    public void setCourse(Course c){
        this.course = c;
    }
    public Course getCourse(){
        return this.course;
    }
    
    public void setFirstName(String fname){
        this.firstName = fname;
    }
    public String getSID(){
        return this.sid;
    }
    public String getFirstName(){
        return this.firstName;
    }
    public void setSurname(String sname){
        this.surname = sname;
    }
    public String getSurname(){
        return this.surname;
    }
    
    public void setDoB(Date d){
        this.dob = d;
    }
    public Date getDoB(){
        return this.dob;
    }
    
    public String toString(){
        return new String(this.sid + "-" + this.firstName + "-" + this.surname + "-" + this.dob);
    }
}
