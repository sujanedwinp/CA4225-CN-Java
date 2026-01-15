import java.util.Scanner;

public class P06_CRC_CCITT {

    // XOR operation between two binary strings
    static String xor(String a, String b) {
        String result = "";

        // MSB is skipped during CRC division
        for (int i = 1; i < b.length(); i++)
            result += (a.charAt(i) == b.charAt(i)) ? '0' : '1';

        return result;
    }

    // Function to compute CRC-CCITT remainder (sender side)
    static String calCRC(String data, String divs) {
        int k = divs.length();
        String temp = data.substring(0, k);

        for (int i = k; i < data.length(); i++) {
            if (temp.charAt(0) == '1')
                temp = xor(divs, temp) + data.charAt(i);
            else
                temp = xor("0".repeat(k), temp) + data.charAt(i);
        }

        return (temp.charAt(0) == '1') ? xor(divs, temp) : xor("0".repeat(k), temp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // CRC-CCITT polynomial (x^16 + x^12 + x^5 + 1)
        String divs = "10001000000100001";

        System.out.print("Sender Data Bits: ");
        String data = sc.nextLine();

        // Append 16 zeros and calculate CRC
        String crc = calCRC(data + "0".repeat(16), divs);

        // Form transmitted frame
        String transmitted = data + crc;

        System.out.println("\n--- SENDER SIDE ---");
        System.out.println("Data: " + data);
        System.out.println("CRC: " + crc);
        System.out.println("Transmitted: " + transmitted);

        sc.close();
    }
}
