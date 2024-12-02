package dev.ofiucoder.jpkatadni.view;

import java.util.Scanner;

public class DniView {

    private final Scanner scanner = new Scanner(System.in);

    public int getDniInput() {
        System.out.print("\nEnter your eight (8) DNI's digits (0-99999999): ");
        String input = scanner.nextLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please enter a valid numeric value.");
            return getDniInput();
        }
    }
    public void displayNumberVL(int dniNumber, char verifyLetter) {
        System.out.println("-----------------------------------");
        System.out.println("Your DNI is: " + dniNumber + "-" + verifyLetter + "\n");
    }

    public void displayError(String message) {
        System.out.println("Error: " + message);
    }
}
