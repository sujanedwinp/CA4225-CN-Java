import java.io.*;
import java.net.*;
import java.util.*;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(24216);
        System.out.println("Calculator Online");

        Socket socket = serverSocket.accept();
        System.out.println("Cal Comming");

        Scanner in = new Scanner(socket.getInputStream());
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        // PrintWriter prints to the other side
        int sum;
        int a=Integer.parseInt(in.nextLine());
        int b=Integer.parseInt(in.nextLine());
        sum=a+b;
        // log
        System.out.printf("%d+%d: %s", a, b, sum);
        out.println(sum);

        socket.close();
        serverSocket.close();
        in.close();
    }
}
