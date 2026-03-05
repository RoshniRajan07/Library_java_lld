package com.kce.main;

import java.util.Scanner;
import com.kce.service.Service;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Service service = new Service();

        while(true){

            System.out.println("\n1 Add Book");
            System.out.println("2 Register Member");
            System.out.println("3 Borrow Book");
            System.out.println("4 Return Book");
            System.out.println("5 Search Book");
            System.out.println("6 Member Report");
            System.out.println("7 Book Report");
            System.out.println("8 Top Borrowers");
            System.out.println("9 Exit");

            int choice = sc.nextInt();

            switch(choice){

                case 1:
                    System.out.println("Enter Book ID Title Author Copies");
                    service.addBook(sc.nextInt(), sc.next(), sc.next(), sc.nextInt());
                    break;

                case 2:
                    System.out.println("Enter Member ID and Name");
                    service.registerMember(sc.nextInt(), sc.next());
                    break;

                case 3:
                    System.out.println("Enter MemberID BookID BorrowDay");
                    service.borrowBook(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;

                case 4:
                    System.out.println("Enter MemberID BookID ReturnDay");
                    service.returnBook(sc.nextInt(), sc.nextInt(), sc.nextInt());
                    break;

                case 5:
                    System.out.println("Enter Title or Author");
                    service.searchBook(sc.next());
                    break;

                case 6:
                    System.out.println("Enter MemberID");
                    service.memberReport(sc.nextInt());
                    break;

                case 7:
                    System.out.println("Enter BookID");
                    service.bookReport(sc.nextInt());
                    break;

                case 8:
                    service.topBorrowers();
                    break;

                default:
                    System.exit(0);
            }
        }
    }
}