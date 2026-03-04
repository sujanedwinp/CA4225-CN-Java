import java.util.*;

public class P13_Token_Passing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of processes: ");
        int n = sc.nextInt();

        System.out.print("Enter sender process: ");
        int sender = sc.nextInt();

        System.out.print("Enter receiver process: ");
        int receiver = sc.nextInt();

        System.out.println("Token passing:");

        for(int i = sender; i != receiver; i = (i + 1) % n){
            System.out.println("Token passed from " + i + " to " + ((i+1)%n));
        }

        System.out.println("Receiver " + receiver + " received the token");
    }
}