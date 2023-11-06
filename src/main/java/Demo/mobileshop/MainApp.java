package Demo.mobileshop;

import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MobileOperation operation= new MobileOperation();

        operation.getCompanyNames();
        System.out.println("Enter Company Name:");
        System.out.println("======================================================");
        String company= sc.next();
        operation.getDisplayModels(company);
        System.out.println("Enter Model Name:");
        String model= sc.next();
        System.out.println("======================================================");
        System.out.println("Enter the number of units: ");
        int units=sc.nextInt();
        operation.getPurches(model,units);
    }
}

