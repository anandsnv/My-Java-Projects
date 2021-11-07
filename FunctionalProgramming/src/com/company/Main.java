package com.company;

import java.util.List;

public class Main {

    public static void main(String[] args) {
    List<String> list= List.of("Apple","Cat","Dog","Banana");
    printWithFP(list);

    }



    private static void printBasic(List<String> list){
        for (String string:list){
            System.out.println(string);
        }
    }
    private static void printWithFP(List<String> list) {
        list.stream().forEach(
                element-> System.out.println("elememt -"+ element)
        );
    }
}
