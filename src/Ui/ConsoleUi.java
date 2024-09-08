package Ui;

import java.util.Scanner;

public class ConsoleUi {

    Scanner prompt = new Scanner(System.in);


    public void startMenu(){



        while (true) {
            System.out.println("******************************");
            System.out.println("Choose an option:");
            System.out.println("1. Students menu");
            System.out.println("2. professor menu");
            System.out.println("3. exit");
            System.out.println("******************************");

            int choice = prompt.nextInt();

            switch (choice) {
                case 1:
                    StudentConsole.studentMenu();
                    break;
                case 2:
                    ProfessorConsole.professorMenu();
                    break;
                case 3:
                    System.out.println("exit");
                    System.exit(0);
                    break;
                case 420:
                    AdminConsole.admin();
                    break;
                default:
                    System.out.println("Invalid choice");

            }

        }
    }








    }


