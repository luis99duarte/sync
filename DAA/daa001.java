import java.util.Scanner;

public class daa001 {
    public static void main(String[] args) {
	    Scanner in = new Scanner(System.in);
	    int n = in.nextInt();
        
        int counter = 0;

	    for (int i = 0; i < n; i++) {
            int ncheck = in.nextInt();
            
	        if (ncheck == 42) {
                counter++;
            }
	    }

        System.out.println(counter);
        
        return;
    }
}
