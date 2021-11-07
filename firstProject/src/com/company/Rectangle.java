package com.company;

public class Rectangle {
    private int length;
    private int breadth;

    public Rectangle(int length, int breadth) {             //constructor
        this.length = length;
        this.breadth = breadth;
    }

    public int getLength() {                                //getters and setters
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public int area(){                              //finding area and perimeter
        return length*breadth;
    }

    public int perimeter(){

        return 2 * (length + breadth);
    }

    public String toString(){
    return String.format("length-%d,width-%d,area=%d,perimeter=%d",length,breadth,area(),perimeter());

    }



}
