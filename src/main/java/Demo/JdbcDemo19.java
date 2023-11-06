package Demo;

import java.util.Scanner;

//
public class JdbcDemo19 {
    public static void main(String[] args) {
        JdbcDemoOperation19 operation =new JdbcDemoOperation19();
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter your choice:");
        System.out.println("1.Login\n2.SignUp");
        int choice = sc1.nextInt();
        if (choice==1){
            //login
            System.out.println("Enter your username:");
            String username= sc1.next();
            System.out.println("Enter your password:");
            String password= sc1.next();
            boolean success= operation.login(username,password);
            if (success){
                System.out.println("Enter your choice: "+"\n1.Add Product\n2.Display Product");
                int choice1= sc1.nextInt();
                if (choice1==1){
                    System.out.println("Enter your Product Name:");
                    String productName= sc1.next();
                    System.out.println("Enter your product category:");
                    String category = sc1.next();
                    System.out.println("Enter your product price:");
                    double price= sc1.nextDouble();
                    operation.addProduct(productName,category,price);
                } else if (choice1==2) {
                    System.out.println("Enter your product id:");
                    String name = sc1.next();
                    operation.displayProduct(name);
                }
                else {
                    System.out.println("Invalid choice...");
                }
            }else {
                System.out.println("Sign Up please..."+"\n1.Yes\n2.NO");
                int status= sc1.nextInt();
                if (status==1) {
                    operation.signUp(username, password);
                } else if (status==2) {
                    System.out.println("Your Wish...."+"\n Thanks......");
                }
            }
        } else if (choice==2) {
            //Sign Up
            System.out.println("Create Your new Account: ");
            System.out.println("Enter your username:");
            String username= sc1.next();
            System.out.println("Enter your password:");
            String password= sc1.next();
            boolean success= operation.signUp(username,password);
            if (success==true){
                System.out.println("Sign up Successful...");
            }
            else {
                System.out.println("SignUp Failed...");
            }
        }
        else {
            System.out.println("Invalid choice...");
        }
    }
}
