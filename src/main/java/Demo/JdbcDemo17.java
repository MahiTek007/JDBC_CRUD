package Demo;

import java.util.Scanner;

public class JdbcDemo17 {
    public static void main(String[] args) {
        Scanner sc1= new Scanner(System.in);
        JdbcDemo17Operation operation= new JdbcDemo17Operation();
        System.out.println(" Enter your Choice:\n1.Add student \n2.Search Student");
        int choice = sc1.nextInt();
        if (choice==1){

            System.out.println("Enter the Student Name: ");
            String name = sc1.next();
            System.out.println("Enter your Stream: ");
            String stream= sc1.next();
            System.out.println("Enter percentage: ");
            String percent = sc1.next();
            operation.addStudent(name,stream,percent);
        } else if (choice==2) {
            System.out.println("Enter your choice Search Student By: \n 1.Search By ID \n 2.Search By Name \n 3.Search by Stream");
            int choice2= sc1.nextInt();
            if (choice2==1){
                System.out.println("Enter Your Id: ");
                int id= sc1.nextInt();
                operation.byId(id);
            } else if (choice2==2) {
                System.out.println("Enter Name: ");
                String name= sc1.next();
                operation.byName(name);
            } else if (choice2==3) {
                System.out.println("Enter Stream");
                String stream= sc1.next();
                operation.byStream(stream);
            }
        }
    }
}
