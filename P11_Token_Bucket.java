import java.util.*;

public class P11_Token_Bucket {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Bucket capacity: ");
        int capacity = sc.nextInt();

        System.out.print("Token rate: ");
        int rate = sc.nextInt();

        int tokens = 0;

        for(int i=0;i<5;i++){
            tokens = Math.min(capacity, tokens + rate);

            System.out.print("Packet size: ");
            int packet = sc.nextInt();

            if(tokens >= packet){
                tokens -= packet;
                System.out.println("Packet sent");
            } else {
                System.out.println("Packet delayed");
            }

            System.out.println("Tokens left: "+tokens);
        }
    }
}