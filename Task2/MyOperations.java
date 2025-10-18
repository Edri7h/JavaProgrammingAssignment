package Task2;

// MyOperations.java
// Author: Ehtesham Nawaz
// Description: Contains string and number operation methods used in Main.java
// Date: 10 October 2025

import java.util.*;

public class MyOperations {
    private String textInput;
    private int numberInput;

    // Constructors for both string and number operations
    public MyOperations(String textInput) {
        this.textInput = textInput;
    }

    public MyOperations(int numberInput) {
        this.numberInput = numberInput;
    }

    // 1. Count Unique Palindromes
    public int countUniquePalindromes() {
        Set<String> uniquePalindromes = new HashSet<>();
        for (int i = 0; i < textInput.length(); i++) {
            for (int j = i + 1; j <= textInput.length(); j++) {
                String sub = textInput.substring(i, j);
                if (isPalindrome(sub)) {
                    uniquePalindromes.add(sub);
                }
            }
        }
        return uniquePalindromes.size();
    }

    private boolean isPalindrome(String str) {
        int left = 0, right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }

    // 2. Fibonacci Sequence – Nth Number
    public int fibonacci() {
        int n = numberInput;
        if (n <= 1) return n;
        int prev = 0, curr = 1, next = 0;
        for (int i = 2; i <= n; i++) {
            next = prev + curr;
            prev = curr;
            curr = next;
        }
        return curr;
    }

    // 3. Snake Case to Camel Case Conversion
    public String snakeToCamel() {
        String[] parts = textInput.split("_");
        StringBuilder result = new StringBuilder(parts[0]);
        for (int i = 1; i < parts.length; i++) {
            result.append(Character.toUpperCase(parts[i].charAt(0)))
                  .append(parts[i].substring(1));
        }
        return result.toString();
    }

    // 4. Count Consonants in a String
    public int countConsonants() {
        int consonantCount = 0;
        String lowerCase = textInput.toLowerCase();
        for (char ch : lowerCase.toCharArray()) {
            if (Character.isLetter(ch) && "aeiou".indexOf(ch) == -1) {
                consonantCount++;
            }
        }
        return consonantCount;
    }

    // 5. Binary to Decimal Conversion
    public int binaryToDecimal() {
        int decimalValue = 0;
        for (int i = 0; i < textInput.length(); i++) {
            decimalValue = decimalValue * 2 + (textInput.charAt(i) - '0');
        }
        return decimalValue;
    }

    // 6. Expand Characters in a String
    public String expandCharacters() {
        StringBuilder expanded = new StringBuilder();
        for (int i = 0; i < textInput.length() - 1; i += 2) {
            char ch = textInput.charAt(i);
            int repeatCount = textInput.charAt(i + 1) - '0';
            expanded.append(String.valueOf(ch).repeat(repeatCount));
        }
        return expanded.toString();
    }

    // 7. Character Frequency in a String
    public String charFrequency() {
        StringBuilder frequencyResult = new StringBuilder();
        int[] freq = new int[256];
        for (char ch : textInput.toCharArray()) {
            freq[ch]++;
        }
        for (int i = 0; i < textInput.length(); i++) {
            char ch = textInput.charAt(i);
            if (freq[ch] != 0) {
                frequencyResult.append(ch).append(freq[ch]);
                freq[ch] = 0;
            }
        }
        return frequencyResult.toString();
    }

    // 8. Prime Number Checker
    public boolean isPrime() {
        int n = numberInput;
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }

    // 9. Number to Words Converter
    public String numberToWords() {
        int num = numberInput;
        if (num == 0) return "zero";

        String[] ones = {"", "one", "two", "three", "four", "five", "six",
                         "seven", "eight", "nine", "ten", "eleven", "twelve",
                         "thirteen", "fourteen", "fifteen", "sixteen",
                         "seventeen", "eighteen", "nineteen"};
        String[] tens = {"", "", "twenty", "thirty", "forty", "fifty",
                         "sixty", "seventy", "eighty", "ninety"};

        StringBuilder words = new StringBuilder();

        if (num >= 100) {
            words.append(ones[num / 100]).append(" hundred ");
            num %= 100;
        }
        if (num >= 20) {
            words.append(tens[num / 10]).append(" ");
            num %= 10;
        }
        if (num > 0) {
            words.append(ones[num]).append(" ");
        }

        return words.toString().trim();
    }

    // 10. Longest Substring Without Repeating Characters
    public int longestUniqueSubstring() {
        int maxLength = 0;
        Set<Character> seenChars = new HashSet<>();
        int left = 0;
        for (int right = 0; right < textInput.length(); right++) {
            while (seenChars.contains(textInput.charAt(right))) {
                seenChars.remove(textInput.charAt(left++));
            }
            seenChars.add(textInput.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
        return maxLength;
    }
}
