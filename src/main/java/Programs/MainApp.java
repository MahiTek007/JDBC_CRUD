package Programs;

import java.util.Scanner;

public class MainApp {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        boolean exit =true;
        System.out.println("Welcome to Electronics Shop");
        System.out.println("===================================================================");

        System.out.println("Select Any option:");
        System.out.println("1.Display All Product\t\n2.Add to the Cart\t\n3.Display All Cart Item.\t\n4.Display Bill\t\n5.Exit");
        int option=sc.nextInt();
        switch (option){
            case 1:{
                viewProduct();
                break;
            }
            case 2:{
                insertToCart();
                break;
            }
            case 3:{
                vierwCart();
                break;
            }
            case 4:{
                viewBill();
                break;
            }
            case 5:{
                exit=false;
                break;
            }
            default:{
                System.out.println("Enter Valid Option");
            }
        }
    }

    static OperationProduct op= new OperationProduct();
    static void viewProduct() {
        op.displayAllProduct();

    }

    static void insertToCart() {
        System.out.println("Enter Id To Add Cart");
        int id=sc.nextInt();
        op.addToCart(id);
    }

    static void vierwCart() {
        op.displayCart();
    }

    static void viewBill() {
        op.displayBill();
    }
}


