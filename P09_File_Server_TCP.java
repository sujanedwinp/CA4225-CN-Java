import java.io.*;
import java.net.*;

public class P09_File_Server_TCP {
    public static void main(String[] args) throws Exception {
        ServerSocket ss = new ServerSocket(5000);
        System.out.println("Server started");

        Socket s = ss.accept();
        System.out.println("Client connected");

        DataInputStream dis = new DataInputStream(s.getInputStream());
        DataOutputStream dos = new DataOutputStream(s.getOutputStream());

        String fileName = dis.readUTF();
        File f = new File(fileName);

        if (f.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(f));
            String line;
            while ((line = br.readLine()) != null)
                dos.writeUTF(line);
            dos.writeUTF("EOF");
            br.close();
        } else {
            dos.writeUTF("File not found");
        }

        s.close();
        ss.close();
    }
}