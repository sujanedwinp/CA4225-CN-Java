import java.util.*;

class P15_Ceaser_Cipher {
    static String encrypt(String text, int shift) {
        String result = "";
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                c = (char)((c - base + shift) % 26 + base);
            }
            result += c;
        }
        return result;
    }

    static String decrypt(String text, int shift) {
        return encrypt(text, 26 - shift);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter text: ");
        String text = sc.nextLine();
        System.out.print("Enter shift: ");
        int shift = sc.nextInt();

        String enc = encrypt(text, shift);
        String dec = decrypt(enc, shift);

        System.out.println("Encrypted: " + enc);
        System.out.println("Decrypted: " + dec);
    }
}
