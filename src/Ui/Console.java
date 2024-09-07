package Ui;

import java.util.Scanner;

public class Console {



    public void start(){
        while (true) {
            System.out.println("******************************");
            System.out.println("1. add docs");
            System.out.println("2. borrow docs");
            System.out.println("3. return docs");
            System.out.println("4. display doc");
            System.out.println("5. search docs");
            System.out.println("6. exit");
            System.out.println("******************************");

            Scanner prompt = new Scanner(System.in);
            int choice = prompt.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("add docs");
                    break;
                case 2:
                    System.out.println("borrow docs");
                    break;
                case 3:
                    System.out.println("return docs");
                    break;
                case 4:
                    System.out.println("display doc");
                    break;
                case 5:
                    System.out.println("search docs");
                    break;
                case 6:
                    System.out.println("exit");
                    break;
                default:
                    System.out.println("Invalid choice");



            }





        }
    }


    }


