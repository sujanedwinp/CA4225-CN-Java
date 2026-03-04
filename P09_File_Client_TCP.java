import java.io.*;
import java.net.*;
import java.util.*;

public class P09_File_Client_TCP {
    public static void main(String[] args) throws Exception {
        Socket s = new Socket("localhost",5000);

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter file name: ");
        String file = sc.nextLine();
        dos.writeUTF(file);

        String line;
        while (!(line = dis.readUTF()).equals("EOF"))
            System.out.println(line);

        s.close();
    }
}