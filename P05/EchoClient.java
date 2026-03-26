import java.io.*;
import java.net.*;
import java.util.*;
public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket con = new Socket("localhost", 24216);

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(con.getOutputStream(), true);
        Scanner con_in= new Scanner(con.getInputStream());
        int a[]=new int[2];
        System.out.print("Enter a: ");
        a[0] = in.nextInt();
        System.out.print("Enter b: ");
        a[1] = in.nextInt();
        out.println(a[0]);
        out.println(a[1]);
        System.out.println("Reply: " + con_in.nextLine());

        con.close();
        in.close();
        con_in.close();
    }
}
