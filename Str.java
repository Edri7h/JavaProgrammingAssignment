public class Str {
    private String s;

    public Str(String s) {
        this.s = s;
    }

    // 1. Append
    public void append(String newString) {
        s = s + newString;
    }

    // 2. Count words
    public int countWords() {
        if (s.trim().isEmpty()) return 0;
        return s.trim().split("\\s+").length;
    }

    // 3. Replace
    public void replace(String a, String b) {
        s = s.replace(a, b);
    }

    // 4. isPalindrome
    public boolean isPalindrome() {
        String clean = s.replaceAll("\\s+", "").toLowerCase();
        return new StringBuilder(clean).reverse().toString().equals(clean);
    }

    // 5. Splice
    public void splice(int start, int length) {
        if (start >= 0 && start + length <= s.length()) {
            s = s.substring(0, start) + s.substring(start + length);
        }
    }

    // 6. Split
    public String[] split(String pattern) {
        return s.split(pattern);
    }

    // 7. Max repeating character
    public char maxRepeat() {
        int[] freq = new int[256];
        for (char c : s.toCharArray()) freq[c]++;
        int max = 0;
        char result = 0;
        for (char c : s.toCharArray()) {
            if (freq[c] > max) {
                max = freq[c];
                result = c;
            }
        }
        return result;
    }

    // 8. Sort
    public void sort() {
        char[] chars = s.toCharArray();
        java.util.Arrays.sort(chars);
        s = new String(chars);
    }

    // 9. Shift
    public void shift(int n) {
        n = n % s.length();
        s = s.substring(n) + s.substring(0, n);
    }

    // 10. Reverse
    public void reverse() {
        s = new StringBuilder(s).reverse().toString();
    }

    public String getString() {
        return s;
    }
}
