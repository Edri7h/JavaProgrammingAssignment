package Task1;

import java.util.ArrayList;
import java.util.Scanner;

// @class MyString
// @filename- Main.java
// @description - this will perform string operations
// @author-Ehtesham nawaz 

class MyString {
    StringBuilder text = new StringBuilder();

    // Append
    public void append(String newString) {

        text.insert(text.length(), newString);

    }

    // Count words
    public int countWords() {
        int count = 0;
        boolean wordFound = false;

        for (int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            if (currChar != ' ') {
                wordFound = true;
            } else {
                if (wordFound) {
                    count++;
                    wordFound = false;
                }
            }
        }
        if (wordFound) {
            count++; // extra +1 for last word
        }
        return count;
    }

    // replace substring
    public void replace(char oldChar, char newChar) {

        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == oldChar) {
                text.setCharAt(i, newChar);
            }
        }
    }

    // palindrome
    public boolean isPalindrome() {
        int left = 0, right = text.length() - 1;
        while (left < right) {
            if (text.charAt(left) != text.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }

    // Splice the string starting from startInd to startInd+len

    public void splice(int startInd, int len) {
        StringBuilder temp = new StringBuilder();
        // edge cases
        if (startInd < 0 || len < 0 || startInd + len > text.length()) {
            System.out.println("invalid inputs");
            return;
        }

        for (int i = 0; i < text.length(); i++) {
            if (i < startInd || i >= startInd + len) {
                temp.insert(temp.length(), text.charAt(i));
            }
        }
        text = temp;
    }

    // Split the string based on a pattern
    public ArrayList<String> split(char pattern) {

        ArrayList<String> words = new ArrayList<>();
        StringBuilder current = new StringBuilder();

        int lastInd = 0;
        for (int i = 0; i < text.length(); i++) {
            char currChar = text.charAt(i);
            if (currChar != pattern) {
                current.insert(lastInd, currChar);
                lastInd += 1;
            } else if (lastInd > 0) {
                words.add(current.toString());
                current = new StringBuilder();
                lastInd = 0;
            }
        }
        if (current.length() > 0)
            words.add(current.toString());
        return words;
    }

    // gives the character which has max freq
    public char maxRepeat() {
        int maxCount = 0;
        char maxChar = ' ';
        for (int i = 0; i < text.length(); i++) {
            int count = 0;
            for (int j = 0; j < text.length(); j++) {
                if (text.charAt(i) == text.charAt(j))
                    count++;
            }
            if (count > maxCount) {
                maxCount = count;
                maxChar = text.charAt(i);
            }
        }
        return maxChar;
    }

    // sorting
    public void sort() {
        for (int i = 0; i < text.length() - 1; i++) {
            for (int j = 0; j < text.length() - i - 1; j++) {
                if (text.charAt(j) > text.charAt(j + 1)) {
                    char temp = text.charAt(j);
                    text.setCharAt(j, text.charAt(j + 1));
                    text.setCharAt(j + 1, temp);
                }
            }
        }
    }

    // Shifting first n characters to end
    public void shift(int n) {
        if (n <= 0 || n >= text.length())
            return;
        StringBuilder temp = new StringBuilder();
        for (int i = n; i < text.length(); i++)
            temp.insert(temp.length(), text.charAt(i));
        for (int i = 0; i < n; i++)
            temp.insert(temp.length(), text.charAt(i));
        text = temp;
    }

    // Reverse
    public void reverse() {
        StringBuilder temp = new StringBuilder();
        for (int i = text.length() - 1; i >= 0; i--)
            temp.insert(temp.length(), text.charAt(i));
        text = temp;
    }

    // print string
    public void display() {
        System.out.println("Current String: " + text.toString());
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MyString str = new MyString();

        System.out.print("Enter initial string: ");
        String initial = sc.nextLine();
        str.append(initial);

        System.out.println("\nMenu:");
        System.out.println("1. Append");
        System.out.println("2. Count Words");
        System.out.println("3. Replace Substring");
        System.out.println("4. Split into Words");
        System.out.println("5. Is Palindrome");
        System.out.println("6. Splice");
        System.out.println("7. Max Repeating Character");
        System.out.println("8. Sort");
        System.out.println("9. Shift");
        System.out.println("10. Reverse");
        System.out.println("11. Display String");
        System.out.println("12. Exit\n");

        while (true) {

            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1:
                    System.out.print("Enter text to append: ");
                    String extra = sc.nextLine();
                    str.append(extra);
                    break;
                case 2:
                    System.out.println("Word Count: " + str.countWords());
                    break;
                case 3:
                    System.out.print("Enter character to replace: ");
                    char oldChar = sc.next().charAt(0);
                    System.out.print("Enter new character: ");
                    char newChar = sc.next().charAt(0);
                    str.replace(oldChar, newChar);
                    break;
                case 4:
                    System.out.print("enter the pattern for spliting :");
                    char pattern = sc.next().charAt(0);
                    ArrayList<String> words = str.split(pattern);
                    System.out.println("Words:");
                    for (String w : words)
                        System.out.print(w);
                    break;
                case 5:
                    System.out.println("Is Palindrome? " + str.isPalindrome());
                    break;
                case 6:
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter length: ");
                    int len = sc.nextInt();
                    sc.nextLine();
                    str.splice(start, len);
                    break;
                case 7:
                    System.out.println("Max Repeating Character: " + str.maxRepeat());
                    break;
                case 8:
                    str.sort();
                    break;
                case 9:
                    System.out.print("Enter number of characters to shift: ");
                    int n = sc.nextInt();
                    sc.nextLine();
                    str.shift(n);
                    break;
                case 10:
                    str.reverse();
                    break;
                case 11:
                    str.display();
                    break;
                case 12:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
