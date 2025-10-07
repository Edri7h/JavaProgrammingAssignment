import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter initial string: ");
        Str str = new Str(sc.nextLine());

        while (true) {
            System.out.println("\nChoose operation: append, countWords, replace, isPalindrome, splice, split, maxRepeat, sort, shift, reverse, exit");
            String choice = sc.next();

            switch (choice) {
                case "append":
                    System.out.print("Enter string to append: ");
                    sc.nextLine(); 
                    String appendStr = sc.nextLine();
                    str.append(appendStr);
                    break;

                case "countWords":
                    System.out.println("Word count: " + str.countWords());
                    break;

                case "replace":
                    System.out.print("Enter old string: ");
                    String oldStr = sc.next();
                    System.out.print("Enter new string: ");
                    String newStr = sc.next();
                    str.replace(oldStr, newStr);
                    break;

                case "isPalindrome":
                    System.out.println("Is palindrome: " + str.isPalindrome());
                    break;

                case "splice":
                    System.out.print("Enter start index: ");
                    int start = sc.nextInt();
                    System.out.print("Enter length: ");
                    int len = sc.nextInt();
                    str.splice(start, len);
                    break;

                case "split":
                    System.out.print("Enter split pattern: ");
                    String pattern = sc.next();
                    String[] parts = str.split(pattern);
                    System.out.println("Result:");
                    for (String p : parts) System.out.println(p);
                    break;

                case "maxRepeat":
                    System.out.println("Max repeating char: " + str.maxRepeat());
                    break;

                case "sort":
                    str.sort();
                    break;

                case "shift":
                    System.out.print("Enter shift amount: ");
                    int n = sc.nextInt();
                    str.shift(n);
                    break;

                case "reverse":
                    str.reverse();
                    break;

                case "exit":
                    System.out.println("Final string: " + str.getString());
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid option.");
            }

            System.out.println("Current string: " + str.getString());
        }
    }
}
