package com.company;
class Task1 extends Thread{
    public void run(){
        System.out.println( "\n Task 1 Started");

        for(int i=101;i<=199;i++)
            System.out.print(i+" ");
        System.out.println( "\n Task 1 is done");


    }
        }
class Task2 implements Runnable{
    public void run(){
        System.out.println( "\n Task 2 Started");
        System.out.println( "\n Task 2 is kicked off ");

        //task 2
        for(int i=201;i<=299;i++)
            System.out.print(i+" ");
        System.out.println( "\n Task 2 is done");


    }
}

public class ThreadBasicsRunner {

    public static void main(String[] args) {

        //task 1
        System.out.println( "\n Task 1 is kicked off ");
        Task1 task1=new Task1();
        task1.setPriority(10);
        task1.start();

        System.out.println( "\n Task 2 is kicked off ");

        Task2 task2=new Task2();
        Thread thread= new Thread(task2);
        thread.start();

        System.out.println( "\n Task 3 is kicked off ");
        //task 3
        for (int i=300;i<=399;i++)
            System.out.print(i +" ");


        System.out.println( "\n Task 3 is done");
        System.out.println( "\n Main done");

    }
}
