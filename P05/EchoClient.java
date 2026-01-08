import java.io.*;
import java.net.*;
import java.util.*;
public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 24216);

        Scanner in = new Scanner(System.in);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        Scanner sin= new Scanner(socket.getInputStream());
        int a[]=new int[2];
        System.out.print("Enter a: ");
        a[0] = in.nextInt();
        System.out.print("Enter b: ");
        a[1] = in.nextInt();
        out.println(a[0]);
        out.println(a[1]);
        System.out.println("Reply: " + sin.nextLine());

        socket.close();
        in.close();
        sin.close();
    }
}
