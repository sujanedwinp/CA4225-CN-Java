import java.util.Scanner;

public class P07_D_D_Parity_Check {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Rows: ");
        int r = sc.nextInt();
        System.out.print("Columns: ");
        int c = sc.nextInt();

        int[][] data = new int[r + 1][c + 1];

        // Input received data (including parity bits)
        System.out.println("Enter received data bits:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                data[i][j] = sc.nextInt();

        // Row parity check
        for (int i = 0; i < r; i++) {
            int sum = 0;
            for (int j = 0; j < c; j++) sum += data[i][j];
            data[i][c] = sum % 2;
        }

        // Column parity check
        for (int j = 0; j < c; j++) {
            int sum = 0;
            for (int i = 0; i < r; i++) sum += data[i][j];
            data[r][j] = sum % 2;
        }

        // Block parity check
        int sum = 0;
        for (int i = 0; i < r; i++) sum += data[i][c];
        data[r][c] = sum % 2;

        // Error detection
        boolean error = false;
        for (int i = 0; i <= r; i++)
            for (int j = 0; j <= c; j++)
                if (data[i][j] != 0) error = true;

        if (error)
            System.out.println("Error Detected (Multiple Parity Check)");
        else
            System.out.println("No Error Detected");
    }
}
