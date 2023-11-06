package Demo;

import java.util.*;

public class JdbcDemo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select option mode: ");
        System.out.println(" 1.Add Product. \n 2.Delete Product. \n 3.Display Product. ");
        int choice = sc.nextInt();
        JdbcDemo10Operation operation = new JdbcDemo10Operation();
        boolean status=true;
        while (status){
            if (choice==1){
                System.out.println("Enter Product Id:");
                int id= sc.nextInt();
                System.out.println("Enter Product Name:");
                String name= sc.next();
                System.out.println("Enter the product category:");
                String category= sc.next();
                System.out.println("Enter the product Price:");
                double price= sc.nextDouble();
                operation.addProduct(id,name,category,price);
            } else if (choice==2) {
                System.out.println("Enter product id: ");
                int id = sc.nextInt();
                operation.deleteProduct(id);
            } else if (choice==3) {
                operation.displayProduct();
            }else {
                status=false;
                return;
            }
            choice= sc.nextInt();
        }
    }
}
