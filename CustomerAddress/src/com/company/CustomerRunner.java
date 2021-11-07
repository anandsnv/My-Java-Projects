package com.company;

public class CustomerRunner {

    public static void main(String[] args) {
	Address homeAddress= new Address("line 1","Kottayam","626710");

        Customer customer= new Customer("Anand", homeAddress);
        System.out.println(customer);

        Address workAddress =new Address("lime2","Kochi","675855");
        customer.setWorkAddress(workAddress);
        System.out.println(customer);







    }
}
