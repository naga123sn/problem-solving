package day3;
public class StringCompression {

    // Method to compress the string
    public static String compressString(String str) {
        // If the string is empty, return it as is
        if (str == null || str.isEmpty()) {
            return str;
        }

        StringBuilder compressed = new StringBuilder();
        int count = 1;

        // Iterate through the string
        for (int i = 1; i < str.length(); i++) {
            // If the current character is the same as the previous one, increment the count
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                // Append the previous character and its count to the result
                compressed.append(str.charAt(i - 1)).append(count);
                count = 1; // Reset the count for the new character
            }
        }

        // Append the last character and its count
        compressed.append(str.charAt(str.length() - 1)).append(count);

        // Return the compressed string if it is shorter than the original; otherwise, return the original string
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        String str1 = "aabcccccaaa";
        String str2 = "abcd";

        System.out.println("Compressed string (aabcccccaaa): " + compressString(str1));
        System.out.println("Compressed string (abcd): " + compressString(str2));
    }
}

