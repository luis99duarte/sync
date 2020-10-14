import java.util.*;

public class daa003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        String fill = in.nextLine();

        for (int i = 0; i < n; i++) {
            String pairPlate = in.nextLine();

            /*
            System.out.println(pairPlate);
            */

            String[] plate = pairPlate.split(" ");

            /*
            System.out.println(plate[0]);
            System.out.println(plate[1]);
            */

            String[] pairA = plate[0].split("-");
            String[] pairB = plate[1].split("-");

            /*
            System.out.println(pairA[0]);
            System.out.println(pairA[1]);
            System.out.println(pairA[2]);
            System.out.println(pairB[0]);
            System.out.println(pairB[1]);
            System.out.println(pairB[2]);
            */
        }
    }   

    public static converter int() {
        
    }
}