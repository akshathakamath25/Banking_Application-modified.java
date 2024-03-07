package bankingapplication;

import java.util.Scanner;
import java.io.*;

class BankDetails {

    String acc_no;
    String name;
    long balance;
    Scanner sc = new Scanner(System.in);

    public void createAccount() {
        System.out.print("Enter The Account No:");
        acc_no = sc.next();
        System.out.print("Enter The Name:");
        name = sc.next();
        System.out.println("Enter The Balance Amount:");
        balance = sc.nextLong();
    }

    public void account() {
        System.out.print("Enter The Account NO:\n");
        acc_no = sc.next();
        System.out.println("Name:\n" + name);
        System.out.println("Balance Amount:" + balance);
    }

    public void deposit() {
        long amount;
        System.out.print("Enter the amount you want to deposit:");
        amount = sc.nextLong();
        balance = balance + amount;
    }

    public void withdrawal() {
        long amount;
        System.out.println("Enter the withdrawal amount:");
        amount = sc.nextLong();
        if (balance >= amount) {
            System.out.println("transaction completed");
            balance = balance - amount;
        } else {
            System.out.println("Transaction not possible!!!");
        }
    }

    public static void saveToFile(BankDetails[] details, String filename) {
        try (PrintWriter writer = new PrintWriter(new FileWriter("Bankdetails.txt", true))) {
            for (BankDetails detail : details) {
                writer.write(detail.acc_no + ",");
                writer.write(detail.name + ",");
                writer.write(detail.balance + "\n");
        
            }
            writer.flush();
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}

public class BankingApplication {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, i;
        Fd f = new Fd();

        System.out.print("Enter the number of users:");
        n = sc.nextInt();
        BankDetails det[] = new BankDetails[n];
        for (i = 0; i < det.length; i++) {
            det[i] = new BankDetails();
            det[i].createAccount();
            det[i].saveToFile(det, "Bankdetails.txt");

            int ch;
            do {

                System.out.println("Banking Application");
                System.out.println("1.CREATE ACCOUNT\n2.FD\n3.DEPOSIT\n4.WITHDRAWAL\n5.DETAILS\n6.EXIT\n");
                System.out.println("Enter your choice:");
                ch = sc.nextInt();
                switch (ch) {
                    case 1:
                        for (i = 0; i < det.length; i++) {
                            det[i].createAccount();
                            det[i].saveToFile(det, "Bankdetails.txt");
                        }

                        break;
                    case 2:
                        f.invest();
                        break;
                    case 3:
                        System.out.println("Enter the account no:");
                        String acc_no = sc.next();
                        for (i = 0; i < det.length; i++) {
                            det[i].deposit();
                            det[i].saveToFile(det, "Bankdetails.txt");
                        }
                        break;
                    case 4:
                        System.out.print("Enter the account no:");
                        acc_no = sc.next();
                        for (i = 0; i < det.length; i++) {
                            det[i].withdrawal();
                            det[i].saveToFile(det, "Bankdetails.txt");
                        }
                        break;
                    case 5:
                        for (i = 0; i < det.length; i++) {
                            det[i].account();
                            det[i].saveToFile(det, "Bankdetails.txt");
                        }
                        break;
                    case 6:
                        System.out.print("Sorry we are not able to help you!!");
            
                        break;
                    default:
                        System.out.println("Invalid choice!");

                }
            } while (ch != 6);
        }
    }
}
