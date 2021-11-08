package com.company;

public class Main {

    public static void main(String[] args) {
    int[] intArray={20,35,-15,7,55,1,-22};

    System.out.println(linearSearch(intArray,-15));
        System.out.println(linearSearch(intArray,7));
        System.out.println(linearSearch(intArray,-22));
        System.out.println(linearSearch(intArray,8));
    }
    public static int linearSearch(int [] input,int value){
        for(int i=0;i<input.length;i++){
            if(input[i]==value){
                System.out.println("Value found in the position");
                return i ;
            }
        }
        System.out.println("Value not found in the position");
        return -1;
    }
}
