package hometask.jdbc;

import hometask.jdbc.db.DBView;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    DBView dbView = new DBView();
    private Scanner scanner = new Scanner(System.in);

    public void run() {
        int typed = -1;
        displayMenu();
        while (true) {
            System.out.println("\n Select an option number from menu:");
            try {
                typed = scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.next();
            }
            if (typed == 0) {
                System.out.println("program completed");
                return;
            } else {
                readUserInput(typed);
            }
        }
    }

    private void readUserInput(int typed) {
        switch (typed) {
            case 1:
                dbView.addPerson(new Person(readPersonFirstName(), readPersonLastName(), readPersonAge()));
                break;
            case 2:
                dbView.getAllPersons();
                break;
            case 3:
                dbView.getPersonOlderByAge(readPersonAge());
                break;
            case 4:
                dbView.deletePersonById(readPersonId());
                break;
            case 5:
                dbView.updatePerson(new Person(readPersonId(), readPersonFirstName(), readPersonLastName(), readPersonAge()));
                break;
            case 6:
                dbView.getPersonById(readPersonId());
                break;
            case 7:
                dbView.getPersonByFirstName(readPersonFirstName());
                break;
            default:
                System.out.println("Incorrect date. Try again");
        }
    }

    private int readPersonAge() {
        System.out.println("Enter person's age");
        return scanner.nextInt();
    }

    private String readPersonFirstName() {
        System.out.println("Enter person's first name");
        return new Scanner(System.in).nextLine();
    }

    private String readPersonLastName() {
        System.out.println("Enter person's last name");
        return new Scanner(System.in).nextLine();
    }

    private int readPersonId() {
        System.out.println("Enter person's id");
        return scanner.nextInt();
    }

    private void displayMenu() {
        System.out.println("1 - Add person \n" +
                           "2 - Display all person\n" +
                           "3 - Display all person who are older than the specified age\n" +
                           "4 - Delete person\n" +
                           "5 - Update person data\n" +
                           "6 - Get person by ID\n" +
                           "7 - Get person by firstName\n" +
                           "0 - FINISH PROGRAM\n");
    }
}
