import java.net.*;

public class P12_UDP_Server_TCP {
    public static void main(String[] args) throws Exception {
        DatagramSocket ds = new DatagramSocket(9876);

        byte[] receive = new byte[1024];

        DatagramPacket dp = new DatagramPacket(receive, receive.length);
        ds.receive(dp);

        String msg = new String(dp.getData());
        System.out.println("Message from client: " + msg);

        ds.close();
    }
}