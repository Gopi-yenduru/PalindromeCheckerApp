import java.util.Scanner;
import java.util.Stack;

// Palindrome Service Class (Encapsulated Logic)
class PalindromeChecker {

    // Public method to check palindrome
    public boolean checkPalindrome(String input) {

        if (input == null) {
            return false;
        }

        // Normalize string (ignore spaces and case)
        String processed = input.replaceAll("\\s+", "").toLowerCase();

        Stack<Character> stack = new Stack<>();

        // Push all characters into stack
        for (char ch : processed.toCharArray()) {
            stack.push(ch);
        }

        // Compare original string with stack (reverse order)
        for (char ch : processed.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }

        return true;
    }
}

// Main Application Class
public class UseCase11PalindromeCheckerApp {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC11: Object-Oriented Palindrome Checker =====");
        System.out.print("Enter a string: ");

        String input = scanner.nextLine();

        // Create service object
        PalindromeChecker checker = new PalindromeChecker();

        // Call encapsulated method
        boolean result = checker.checkPalindrome(input);

        if (result) {
            System.out.println("Result: The given string is a Palindrome.");
        } else {
            System.out.println("Result: The given string is NOT a Palindrome.");
        }

        scanner.close();
    }
}