package ie.gmit.dip;

import java.io.*;
public class Course implements Serializable{
    private String name;
    
    public Course(String name){
        this.name = name;
    }
    
    public String getName(){
        return this.name;
    }
}

