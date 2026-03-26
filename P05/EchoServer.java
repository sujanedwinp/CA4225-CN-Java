import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(24216);
        System.out.println("Calculator Online");

        Socket con = server.accept();
        System.out.println("Cal Comming");

        Scanner in = new Scanner(con.getInputStream());
        PrintWriter out = new PrintWriter(con.getOutputStream(), true);

        // PrintWriter prints to the other side
        int sum;
        int a=Integer.parseInt(in.nextLine());
        int b=Integer.parseInt(in.nextLine());
        sum=a+b;
        
        // log
        System.out.println(a+"+"+b+"="+sum);
        out.println(sum);

        con.close();
        server.close();
        in.close();
    }
}
