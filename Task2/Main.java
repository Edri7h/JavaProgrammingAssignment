package Task2;
// Main.java
// Author: Ehtesham Nawaz
// Description: Menu driven program to perform String and Number operations
// Date: 10 October 2025

import java.util.*;

public class Main {

    // main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Count Unique Palindromes");
            System.out.println("2. Fibonacci Sequence – Nth Number");
            System.out.println("3. Snake Case to Camel Case Conversion");
            System.out.println("4. Count Consonants in a String");
            System.out.println("5. Binary to Decimal Conversion");
            System.out.println("6. Expand Characters in a String");
            System.out.println("7. Character Frequency in a String");
            System.out.println("8. Prime Number Checker");
            System.out.println("9. Number to Words Converter");
            System.out.println("10. Longest Substring Without Repeating Characters");
            System.out.println("11. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    String str1 = sc.nextLine();
                    System.out.println("Unique Palindromes: " + countUniquePalindromes(str1));
                    break;

                case 2:
                    System.out.print("Enter N: ");
                    int n = sc.nextInt();
                    System.out.println("Nth Fibonacci Number: " + fibonacci(n));
                    break;

                case 3:
                    System.out.print("Enter snake_case string: ");
                    String snake = sc.nextLine();
                    System.out.println("Camel Case: " + snakeToCamel(snake));
                    break;

                case 4:
                    System.out.print("Enter a string: ");
                    String str4 = sc.nextLine();
                    System.out.println("Consonants Count: " + countConsonants(str4));
                    break;

                case 5:
                    System.out.print("Enter binary string: ");
                    String bin = sc.nextLine();
                    System.out.println("Decimal Value: " + binaryToDecimal(bin));
                    break;

                case 6:
                    System.out.print("Enter string (like a1b4c3): ");
                    String str6 = sc.nextLine();
                    System.out.println("Expanded String: " + expandCharacters(str6));
                    break;

                case 7:
                    System.out.print("Enter a string: ");
                    String str7 = sc.nextLine();
                    System.out.println("Character Frequency: " + charFrequency(str7));
                    break;

                case 8:
                    System.out.print("Enter number: ");
                    int num = sc.nextInt();
                    if (isPrime(num))
                        System.out.println("The given number is PRIME");
                    else
                        System.out.println("The given number is NOT prime");
                    break;

                case 9:
                    System.out.print("Enter number: ");
                    int num9 = sc.nextInt();
                    System.out.println("In Words: " + numberToWords(num9));
                    break;

                case 10:
                    System.out.print("Enter a string: ");
                    String str10 = sc.nextLine();
                    System.out.println("Length of Longest Substring Without Repeating Characters: " + longestUniqueSubstring(str10));
                    break;

                case 11:
                    System.out.println("Exiting the program. Thank you!");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // 1. Count Unique Palindromes
    static int countUniquePalindromes(String s) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String sub = s.substring(i, j);
                if (isPalindrome(sub))
                    set.add(sub);
            }
        }
        return set.size();
    }

    static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--))
                return false;
        }
        return true;
    }

    // 2. Fibonacci Sequence – Nth Number
    static int fibonacci(int n) {
        if (n <= 1) return n;
        int a = 0, b = 1, c = 0;
        for (int i = 2; i <= n; i++) {
            c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    // 3. Snake Case to Camel Case Conversion
    static String snakeToCamel(String str) {
        String[] parts = str.split("_");
        StringBuilder sb = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            sb.append(Character.toUpperCase(parts[i].charAt(0))).append(parts[i].substring(1));
        }
        return sb.toString();
    }

    // 4. Count Consonants in a String
    static int countConsonants(String s) {
        int count = 0;
        s = s.toLowerCase();
        for (char ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z' && "aeiou".indexOf(ch) == -1) {
                count++;
            }
        }
        return count;
    }

    // 5. Binary to Decimal Conversion
    static int binaryToDecimal(String bin) {
        int dec = 0;
        for (int i = 0; i < bin.length(); i++) {
            dec = dec * 2 + (bin.charAt(i) - '0');
        }
        return dec;
    }

    // 6. Expand Characters in a String
    static String expandCharacters(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i += 2) {
            char ch = s.charAt(i);
            int times = s.charAt(i + 1) - '0';
            for (int j = 0; j < times; j++)
                sb.append(ch);
        }
        return sb.toString();
    }

    // 7. Character Frequency in a String
    static String charFrequency(String s) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[256];
        for (char ch : s.toCharArray())
            freq[ch]++;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (freq[ch] != 0) {
                sb.append(ch).append(freq[ch]);
                freq[ch] = 0;
            }
        }
        return sb.toString();
    }

    // 8. Prime Number Checker
    static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // 9. Number to Words Converter
    static String numberToWords(int num) {
        if (num == 0) return "zero";

        String[] ones = {"", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten",
                "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

        StringBuilder sb = new StringBuilder();

        if (num >= 100) {
            sb.append(ones[num / 100]).append(" hundred ");
            num %= 100;
        }

        if (num >= 20) {
            sb.append(tens[num / 10]).append(" ");
            num %= 10;
        }

        if (num > 0) {
            sb.append(ones[num]).append(" ");
        }

        return sb.toString().trim();
    }

    // 10. Longest Substring Without Repeating Characters
    static int longestUniqueSubstring(String s) {
        int max = 0;
        Set<Character> set = new HashSet<>();
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left++));
            }
            set.add(s.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
