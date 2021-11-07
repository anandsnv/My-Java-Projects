package com.company;

public class Main {

    public static void main(String[] args) {
        Employee janeJones= new Employee("Jane","John",123);
        Employee johnDoe= new Employee("John","Doe",123);
        Employee marySmith= new Employee("Mary","Smith",123);
        Employee mikeWilson= new Employee("Mike","Wilson",123);

        ArrayQueue queue=new ArrayQueue(10);
        queue.add(janeJones);
        queue.add(johnDoe);
        queue.add(marySmith);
        queue.add(mikeWilson);

        queue.remove();
        queue.remove();

        System.out.println(queue.peek());
        queue.printQueue();

    }
}
