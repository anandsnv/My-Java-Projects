package com.company;

public class Customer {
    //state
    private String name;
    private Address homeAddress;
    private Address workAddress;

    //creation
    public Customer(String name, Address homeAddress) {
        this.name = name;
        this.homeAddress = homeAddress;
    }

        //operations
    public Address getHomeAddress() {

        return homeAddress;
    }

    public void setHomeAddress(Address homeAddress) {

        this.homeAddress = homeAddress;
    }

    public Address getWorkAddress() {

        return workAddress;
    }

    public void setWorkAddress(Address workAddress) {

        this.workAddress = workAddress;
    }
    public String toString(){
        return String.format(("name-[%s],homeAddress[%s]-,workAddress-[%s]"),name,homeAddress,workAddress);
    }
}
