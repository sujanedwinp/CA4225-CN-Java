import java.net.*;

public class P12_UDP_Client_TCP {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket();

        String msg = "Hello Server";
        InetAddress ip = InetAddress.getByName("localhost");

        DatagramPacket dp = new DatagramPacket(msg.getBytes(),
                msg.length(), ip, 9876);

        ds.send(dp);
        ds.close();
    }
}