package Interviews;

public class ReverseString {

    // 1. Using StringBuilder (Best + easiest)
    public static String reverseUsingStringBuilder(String name) {
        return new StringBuilder(name).reverse().toString();
    }

    // 2. In-place char array swap (Most memory-efficient)
    public static String reverseInPlace(String name) {
        char[] arr = name.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            char temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
        return new String(arr);
    }

    // 3. Reverse using char array + StringBuilder append
    public static String reverseUsingStringBuilderLoop(String name) {
        char[] arr = name.toCharArray();
        StringBuilder sb = new StringBuilder();

        for (int i = arr.length - 1; i >= 0; i--) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    // 4. Manual string concatenation (Not memory efficient)
    public static String reverseUsingConcatenation(String name) {
        char[] arr = name.toCharArray();
        String result = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            result += arr[i];
        }
        return result;
    }

    // 5. Reverse using recursion
    public static String reverseUsingRecursion(String name) {
        if (name == null || name.length() <= 1) {
            return name;
        }
        return reverseUsingRecursion(name.substring(1)) + name.charAt(0);
    }

    // 6. Reverse using Stack
    public static String reverseUsingStack(String name) {
        java.util.Stack<Character> stack = new java.util.Stack<>();

        for (char c : name.toCharArray()) {
            stack.push(c);
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }

    // 7. Reverse using Collections.reverse
    public static String reverseUsingCollections(String name) {
        java.util.List<Character> list = new java.util.ArrayList<>();
        for (char c : name.toCharArray()) {
            list.add(c);
        }

        java.util.Collections.reverse(list);

        StringBuilder sb = new StringBuilder();
        for (char c : list) {
            sb.append(c);
        }

        return sb.toString();
    }

    // 8. Reverse using Java 8 Streams
    public static String reverseUsingStreams(String name) {
        return name.chars()
                .mapToObj(c -> String.valueOf((char) c))
                .reduce("", (a, b) -> b + a);
    }

    // 9. Reverse using XOR swap (no temp variable)
    public static String reverseUsingXOR(String name) {
        char[] arr = name.toCharArray();
        int left = 0, right = arr.length - 1;

        while (left < right) {
            arr[left] = (char)(arr[left] ^ arr[right]);
            arr[right] = (char)(arr[left] ^ arr[right]);
            arr[left] = (char)(arr[left] ^ arr[right]);
            left++;
            right--;
        }
        return new String(arr);
    }

    // MAIN method to test everything
    public static void main(String[] args) {
        String name = "Sandeep";

        System.out.println(reverseUsingStringBuilder(name));
        System.out.println(reverseInPlace(name));
        System.out.println(reverseUsingStringBuilderLoop(name));
        System.out.println(reverseUsingConcatenation(name));
        System.out.println(reverseUsingRecursion(name));
        System.out.println(reverseUsingStack(name));
        System.out.println(reverseUsingCollections(name));
        System.out.println(reverseUsingStreams(name));
        System.out.println(reverseUsingXOR(name));
    }
}
