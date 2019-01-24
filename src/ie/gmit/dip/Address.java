package ie.gmit.dip;

import java.io.*;
public class Address implements Serializable{
    private String street;
    
    public Address(String street){
        this.street = street;
    }
    public String getStreet(){
        return this.street;
    }
}
