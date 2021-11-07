package com.company;

public class RectangleRunner {

    public static void main(String[] args) {
	// write your code here
       Rectangle rectangle=new Rectangle(5,6);          //instantiation
       System.out.println(rectangle);
       rectangle.setBreadth(10);                                       //Changing the breadth
       System.out.println(rectangle);
       rectangle.setLength(10);
       System.out.println(rectangle);
        }
    }

