import java.util.*;

public class P10_Leaky_Bucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Bucket size: ");
        int bucket = sc.nextInt();

        System.out.print("Output rate: ");
        int rate = sc.nextInt();

        System.out.print("Packets: ");
        int n = sc.nextInt();

        int store = 0;

        for(int i=1;i<=n;i++){
            System.out.print("Packet size: ");
            int packet = sc.nextInt();

            if(store + packet > bucket){
                System.out.println("Overflow. Packet discarded");
            } else {
                store += packet;
            }

            System.out.println("Bucket content: "+store);

            store -= rate;
            if(store < 0) store = 0;

            System.out.println("After leak: "+store);
        }
    }
}