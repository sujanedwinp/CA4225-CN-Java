import java.util.*;

public class P16_Playfair_Cipher {

    // 5×5 Playfair cipher matrix (I and J are treated as the same letter)
    static char[][] matrix = new char[5][5];

    /*
     * Generates the Playfair key matrix
     * Steps:
     * 1. Normalize key (uppercase, J → I)
     * 2. Insert unique key characters into matrix (row-wise)
     * 3. Fill remaining unused alphabets (excluding J)
     */
    static void generateMatrix(String key) {

        boolean[] used = new boolean[26];

        key = key.toUpperCase().replace("J", "I");

        int r = 0, c = 0; 

        for (char ch : key.toCharArray()) {

            if (ch < 'A' || ch > 'Z') 
                continue;

            if (!used[ch - 'A']) {
                matrix[r][c++] = ch;        
                used[ch - 'A'] = true;      

                if (c == 5) {
                    r++;
                    c = 0;
                }
            }
        }

        // Remaining letters
        for (char ch = 'A'; ch <= 'Z'; ch++) {

            if (ch == 'J') 
                continue;

            // Insert only letters not already used by the key
            if (!used[ch - 'A']) {
                matrix[r][c++] = ch;

                if (c == 5) {
                    r++;
                    c = 0;
                }
            }
        }
    }

    /*
     * Prepares plaintext for Playfair encryption
     * Rules applied:
     * - Convert to uppercase
     * - Replace J with I
     * - Remove non-alphabet characters
     * - Insert X between identical letters in a digraph
     * - Append X if final length is odd
     */
    static String prepareText(String text) {

        text = text.toUpperCase()
                   .replace("J", "I")
                   .replaceAll("[^A-Z]", "");

        StringBuilder sb = new StringBuilder();

        // Process characters to form valid digraphs
        for (int i = 0; i < text.length(); i++) {

            // Append current character
            sb.append(text.charAt(i));

            // If next character is same, insert filler 'X'
            if (i + 1 < text.length() &&
                text.charAt(i) == text.charAt(i + 1)) {
                sb.append('X');
            }
        }

        // Ensure even length by appending 'X' if required
        if (sb.length() % 2 != 0)
            sb.append('X');

        return sb.toString();
    }

    /*
     * Finds the position of a character in the 5×5 matrix
     * Returns an array: {row, column}
     */
    static int[] find(char ch) {

        // Traverse entire matrix to locate the character
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {

                // Match found
                if (matrix[i][j] == ch)
                    return new int[]{i, j};
            }
        }

        // Should never occur for valid input
        return null;
    }

    /*
     * Encrypts prepared plaintext using Playfair cipher rules
     * Encryption rules:
     * 1. Same row    → shift right
     * 2. Same column → shift down
     * 3. Rectangle  → swap columns
     */
    static String encrypt(String text) {

        StringBuilder cipher = new StringBuilder();

        // Process text two characters at a time (digraphs)
        for (int i = 0; i < text.length(); i += 2) {

            char a = text.charAt(i);       // First character of digraph
            char b = text.charAt(i + 1);   // Second character of digraph

            // Find matrix positions of both characters
            int[] p1 = find(a);
            int[] p2 = find(b);

            // Case 1: Both characters in the same row
            if (p1[0] == p2[0]) {
                cipher.append(matrix[p1[0]][(p1[1] + 1) % 5]);
                cipher.append(matrix[p2[0]][(p2[1] + 1) % 5]);
            }

            // Case 2: Both characters in the same column
            else if (p1[1] == p2[1]) {
                cipher.append(matrix[(p1[0] + 1) % 5][p1[1]]);
                cipher.append(matrix[(p2[0] + 1) % 5][p2[1]]);
            }

            // Case 3: Characters form a rectangle
            else {
                cipher.append(matrix[p1[0]][p2[1]]);
                cipher.append(matrix[p2[0]][p1[1]]);
            }
        }

        return cipher.toString();
    }

    /*
     * Main driver method
     * Controls:
     * - User input
     * - Matrix generation
     * - Plaintext preparation
     * - Encryption and output
     */
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        // Fixed Playfair key
        String key = "MONARCHY";

        // Read plaintext input
        System.out.println("Enter word to cipher: ");
        String plaintext = in.next();

        // Execute Playfair cipher steps
        generateMatrix(key);
        String prepared = prepareText(plaintext);
        String cipher = encrypt(prepared);

        // Display results
        System.out.println("Prepared Text : " + prepared);
        System.out.println("Cipher Text   : " + cipher);
    }
}
