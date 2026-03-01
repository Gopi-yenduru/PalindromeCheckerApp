import java.util.Scanner;

public class UseCase10PalindromeCheckerApp {

    // Method to check palindrome (iterative approach)
    public static boolean isPalindrome(String str) {

        int left = 0;
        int right = str.length() - 1;

        while (left < right) {

            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC10: Case-Insensitive & Space-Ignored Palindrome Checker =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // Step 1: Normalize string
        // Remove all spaces using regular expression and convert to lowercase
        String normalizedInput = input.replaceAll("\\s+", "").toLowerCase();

        // Step 2: Apply palindrome logic
        boolean result = isPalindrome(normalizedInput);

        // Display result
        if (result) {
            System.out.println("Result: The given string is a Palindrome (ignoring spaces and case).");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}