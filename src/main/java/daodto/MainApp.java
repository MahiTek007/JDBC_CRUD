package daodto;

import java.util.ArrayList;
import java.util.Scanner;

public class MainApp {
    //utilization class
    static Scanner sc= new Scanner(System.in);
    static BookDAO d1=new BookDAO();
    public static void main(String[] args) {
        System.out.println("Select mode of operations:\n 1. Add Book\n 2. Delete Book\n 3.Display Book");
        int choice= sc.nextInt();
        if (choice==1){
            insertBook();
        } else if (choice==2) {
            removeBook();
        } else if (choice==3) {
            showBook();
        }
    }
    static void insertBook() {
        //Accept name,price
        System.out.println("Enter Book Name: ");
        String name= sc.next();
        System.out.println("Enter Book price: ");
        double price= sc.nextDouble();
        //add info to DTO class object
        Book b1 = new Book();
        b1.setBookName(name);
        b1.setBookPrice(price);
        //call add book method from DAO
        int count= d1.addBook(b1);

        System.out.println(count+"BOOK INSERTED SUCCESSFULLY...");

    }
    static void removeBook() {
        //Accept id
        System.out.println("Enter Book id: ");
        int id = sc.nextInt();
        //add info to DTO class object
        Book b1= new Book();
        b1.setBookId(id);
        //call DeleteBook method
        int count = d1.deleteBook(b1);
        System.out.println(count+"BOOK DELETED SUCCESSFULLY...");
    }
    static void showBook() {

        //call display book method from DAO
        ArrayList<Book> data=d1.displayBooks();
        for (Book b:data) {
            System.out.println(b);
        }
    }



}
