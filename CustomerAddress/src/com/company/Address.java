package com.company;

public class Address {
    //state
    private String line1;
    private String city;
    public String zip;

    //creation
    public Address(String line1, String city, String zip) {
        super();
        this.line1 = line1;
        this.city = city;
        this.zip = zip;
    }
    public String toString(){
        return line1 +" "+ city+" "+zip;
    }
}
