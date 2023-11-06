package Demo;

import java.util.Scanner;

public class JdbcDemo14 {
    public static void main(String[] args) {
        Scanner sc =new Scanner(System.in);
        System.out.println("Enter Your choices: \n 1.Login \n 2.Sign Up");
        int choice =sc.nextInt();
        JdbcDemo14Operation operation = new JdbcDemo14Operation();
        if (choice==1){
            System.out.println("Enter Your UserName: ");
            String user= sc.next();
            System.out.println("Enter your Password: ");
            String password = sc.next();
            String success= operation.login();
            if (success==null){
                System.out.println();
                System.out.println("Select option mode: ");
                System.out.println(" 1.Add Product. \n 2.Delete Product. \n 3.Display Product. ");
                int choice1 = sc.nextInt();
                boolean status=true;
                while (status){
                    if (choice1==1){
                        System.out.println("Enter Product Id:");
                        int id= sc.nextInt();
                        System.out.println("Enter Product Name:");
                        String name= sc.next();
                        System.out.println("Enter the product category:");
                        String category= sc.next();
                        System.out.println("Enter the product Price:");
                        double price= sc.nextDouble();
                        operation.addProduct(id,name,category,price);
                    } else if (choice1==2) {
                        System.out.println("Enter product id: ");
                        int id = sc.nextInt();
                        operation.deleteProduct(id);
                    } else if (choice1==3) {
                        operation.displayProduct();
                    }else {
                        status = false;
                        return;
                    }
                }
            }
        }
        else if (choice==2){
            System.out.println("Enter New User Name: ");
            String user = sc.next();
            System.out.println("Enter Password");

        }

    }
}
