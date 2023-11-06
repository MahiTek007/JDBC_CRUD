package daodto;

import java.util.*;

public class ProductMainApp {
    static Scanner sc1=new Scanner(System.in);
    static ProductDAO pd1= new ProductDAO();
    public static void main(String[] args) {
        System.out.println("Enter your choice to select operation:\n 1.Add Product\n 2.Remove Product\n 3.Display Product ");
        int choice= sc1.nextInt();
        if (choice==1){
            insertProduct();
        } else if (choice==2) {
            removeProduct();
        } else if (choice==3) {
            showProduct();
        }else {
            System.out.println("Invalid choice...");
        }
    }

    static void insertProduct() {
        //Accept the data from user
        System.out.println("Enter the Product Name: ");
        String productName= sc1.next();
        System.out.println("Enter th Product category: ");
        String category = sc1.next();
        System.out.println("Enter the price of an product: ");
        double price= sc1.nextDouble();
        //add info of DTO class object
        Product p1= new Product();
        p1.setProductName(productName);
        p1.setProductCategory(category);
        p1.setPrice(price);
        //call add product method from DAO
        int count= pd1.addProduct(p1);
        System.out.println(count+"PRODUCT INSERTED SUCCESSFULLY...");
    }

    static void removeProduct() {
        //Accept the product id from user
        System.out.println("Enter Product id To remove product: ");
        int id = sc1.nextInt();
        //add info of DTO class object
        Product p1 =new Product();
        p1.setProductId(id);
        //call delete product method from DAo class
        int count=pd1.deleteProduct(p1);
        System.out.println(count+"PRODUCT REMOVED SUCCESSFULLY...");
    }

    static void showProduct() {
       ArrayList<Product> data = pd1.displayProduct();
       int count=0;
        for (Product p:data) {
            System.out.println(p);
            System.out.println("=====================================================");
            count++;
        }
        System.out.println(count+" product are available......");
    }
}
