package Task2;
// Main.java
// Author: Ehtesham Nawaz
// Description: Menu-driven program that demonstrates operations using MyOperations class
// Date: 10 October 2025

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("""
                \n--- MENU ---
                1. Count Unique Palindromes
                2. Fibonacci Sequence – Nth Number
                3. Snake Case to Camel Case Conversion
                4. Count Consonants in a String
                5. Binary to Decimal Conversion
                6. Expand Characters in a String
                7. Character Frequency in a String
                8. Prime Number Checker
                9. Number to Words Converter
                10. Longest Substring Without Repeating Characters
                11. Exit
                """);

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter a string: ");
                    MyOperations op = new MyOperations(scanner.nextLine());
                    System.out.println("Unique Palindromes: " + op.countUniquePalindromes());
                }

                case 2 -> {
                    System.out.print("Enter N: ");
                    MyOperations op = new MyOperations(scanner.nextInt());
                    System.out.println("Nth Fibonacci Number: " + op.fibonacci());
                }

                case 3 -> {
                    System.out.print("Enter snake_case string: ");
                    MyOperations op = new MyOperations(scanner.nextLine());
                    System.out.println("Camel Case: " + op.snakeToCamel());
                }

                case 4 -> {
                    System.out.print("Enter a string: ");
                    MyOperations op = new MyOperations(scanner.nextLine());
                    System.out.println("Consonants Count: " + op.countConsonants());
                }

                case 5 -> {
                    System.out.print("Enter binary string: ");
                    MyOperations op = new MyOperations(scanner.nextLine());
                    System.out.println("Decimal Value: " + op.binaryToDecimal());
                }

                case 6 -> {
                    System.out.print("Enter string (like a1b4c3): ");
                    MyOperations op = new MyOperations(scanner.nextLine());
                    System.out.println("Expanded String: " + op.expandCharacters());
                }

                case 7 -> {
                    System.out.print("Enter a string: ");
                    MyOperations op = new MyOperations(scanner.nextLine());
                    System.out.println("Character Frequency: " + op.charFrequency());
                }

                case 8 -> {
                    System.out.print("Enter number: ");
                    MyOperations op = new MyOperations(scanner.nextInt());
                    System.out.println(op.isPrime() ? "The given number is PRIME" : "The given number is NOT prime");
                }

                case 9 -> {
                    System.out.print("Enter number: ");
                    MyOperations op = new MyOperations(scanner.nextInt());
                    System.out.println("In Words: " + op.numberToWords());
                }

                case 10 -> {
                    System.out.print("Enter a string: ");
                    MyOperations op = new MyOperations(scanner.nextLine());
                    System.out.println("Length of Longest Substring Without Repeating Characters: " + op.longestUniqueSubstring());
                }

                case 11 -> {
                    System.out.println("Exiting the program. Thank you!");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Invalid choice! Try again.");
            }
        }
    }
}
