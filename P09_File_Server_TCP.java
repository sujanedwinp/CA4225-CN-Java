import java.io.*;
import java.net.*;
import java.util.Scanner;

public class P09_File_Server_TCP {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started");

        Socket s = ss.accept();
        System.out.println("Client connected");

        Scanner in=new Scanner(s.getInputStream());
        PrintWriter out = new PrintWriter(s.getOutputStream(), true);

        String fileName = in.nextLine();
        File f = new File(fileName);

        if (f.exists()) {
            in=new Scanner(new FileReader(f));
            String line;
            while (!(line = in.nextLine()).equals("EOF"))
                out.println(line);
            out.println("EOF");
        } else {
            out.println("File not found");
        }

        s.close();
        ss.close();
        in.close();
    }
}