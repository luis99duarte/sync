import java.util.*;

class plate {
    String st;
    String nd;
    String rd;

    plate(String a, String b, String c) {
        st = a;
        nd = b;
        rd = c;
    }
}

public class daa003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int t = in.nextInt();
        in.useDelimiter("-|\\s+");

        for(int i = 0; i < t; i++) {
            String a = in.next();
            String b = in.next();
            String c = in.next();

            
            plate plateA = new plate(a, b, c);
            
            int nA = convertDecimal(a, b, c);

            a = in.next();
            b = in.next();
            c = in.next();

            plate plateB = new plate(a, b, c);

            int nB = convertDecimal(a, b, c);

            if(nA > nB) {
                System.out.println(nA - nB);
            }

            else {
                System.out.println(nB - nA);
            }
        }

        return;
    }

    public static int lettercalc(char c) {
        if(c >= 'A' && c < 'K') {
            return c - 'A';
        }

        else if(c >= 'L' && c < 'W') {
            return c - 'A' - 1;
        }

        else if(c == 'X') {
            return c - 'A' - 2;
        }

        else if(c == 'Z') {
            return c - 'A' -3;
        }

        return -1;
    }

    public static int convertDecimal(String a, String b, String c) {
        char partA;
        char partB;
        char partC;

        partA = a.charAt(0);
        partB = b.charAt(0);
        partC = c.charAt(0);

        int n = 1;

        if(Character.isLetter(partA) && Character.isDigit(partB) && Character.isDigit(partC)) {
            String s = b + c;

            n += Integer.parseInt(s);
            n += lettercalc(a.charAt(1)) * 10000;
            n += lettercalc(a.charAt(0)) * 230000;
        }

        else if(Character.isDigit(partA) && Character.isDigit(partB) && Character.isLetter(partC)) {
            String s = a + b;
            
            n += Integer.parseInt(s);
            n += lettercalc(c.charAt(1)) * 10000;
            n += lettercalc(c.charAt(0)) * 230000;
            n += 5290000;
        }

        else if(Character.isDigit(partA) && Character.isLetter(partB) && Character.isDigit(partC)) {
            String s = a + c;
            
            n += Integer.parseInt(s);
            n += lettercalc(b.charAt(1)) * 10000;
            n += lettercalc(b.charAt(0)) * 230000;
            n += 5290000 * 2;
        }

        else {
            String s = b;
            
            n += Integer.parseInt(s);
            n += lettercalc(c.charAt(1)) * 100;
            n += lettercalc(c.charAt(0)) * 2300;
            n += lettercalc(a.charAt(1)) * 52900;
            n += lettercalc(a.charAt(0)) * 1216700;
            n += 5290000 * 3;
        }

        return n;
    }
}


