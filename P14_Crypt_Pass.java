import java.util.*;

class P14_Crypt_Pass {
    // XOR SELF INVERSE PROPERTY
    // A (+) B (+) B = A
    // text (+) key (+) key = text
    static String cryptPass(String text, char key) {
        String result = "";
        for (char c : text.toCharArray())
            result += (char)(c ^ key);
        return result;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter password: ");
        String pass = in.nextLine();

        char key = 'h';   // secret key
        String ePass = cryptPass(pass, key);
        String dPass = cryptPass(ePass, key);

        System.out.println("Encrypted: " + ePass);
        System.out.println("Decrypted: " + dPass);
    }
}
