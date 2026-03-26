import java.io.*;
import java.net.*;
import java.util.*;

public class P09_File_Client_TCP {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost",5000);

        Scanner in=new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String file = sc.nextLine();
        out.println(file);

        String line;
        while (!(line = in.nextLine()).equals("EOF"))
            System.out.println(line);

        s.close();
    }
}