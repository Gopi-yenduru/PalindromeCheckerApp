import java.util.*;

public class UseCase13PalindromeCheckerApp {

    // Normalize input (ignore spaces & case)
    public static String normalize(String input) {
        return input.replaceAll("\\s+", "").toLowerCase();
    }

    // 1️⃣ Two-Pointer Method
    public static boolean twoPointerCheck(String str) {
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

    // 2️⃣ Stack Method
    public static boolean stackCheck(String str) {
        Stack<Character> stack = new Stack<>();

        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        for (char ch : str.toCharArray()) {
            if (ch != stack.pop()) {
                return false;
            }
        }
        return true;
    }

    // 3️⃣ Recursive Method
    public static boolean recursiveCheck(String str, int start, int end) {
        if (start >= end) {
            return true;
        }

        if (str.charAt(start) != str.charAt(end)) {
            return false;
        }

        return recursiveCheck(str, start + 1, end - 1);
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("===== UC13: Performance Comparison =====");
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();

        String processed = normalize(input);

        // Two-Pointer Timing
        long start1 = System.nanoTime();
        boolean result1 = twoPointerCheck(processed);
        long end1 = System.nanoTime();
        long duration1 = end1 - start1;

        // Stack Timing
        long start2 = System.nanoTime();
        boolean result2 = stackCheck(processed);
        long end2 = System.nanoTime();
        long duration2 = end2 - start2;

        // Recursive Timing
        long start3 = System.nanoTime();
        boolean result3 = recursiveCheck(processed, 0, processed.length() - 1);
        long end3 = System.nanoTime();
        long duration3 = end3 - start3;

        System.out.println("\n===== Results =====");
        System.out.println("Two-Pointer Result: " + result1 + " | Time: " + duration1 + " ns");
        System.out.println("Stack Method Result: " + result2 + " | Time: " + duration2 + " ns");
        System.out.println("Recursive Method Result: " + result3 + " | Time: " + duration3 + " ns");

        scanner.close();
    }
}