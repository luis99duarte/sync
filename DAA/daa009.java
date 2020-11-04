import java.util.*;

class ADN implements Comparable<ADN> {
    int frequency;
    int position;
    char letter;

    ADN(char c) {
        frequency = 0;
        position = -1;
        letter = c;
    }

    @Override
    public int compareTo(ADN l) {
        if(this.frequency < l.frequency) return +1;
        if(this.frequency > l.frequency) return -1;
        if(this.position < l.position) return -1;
        if(this.position > l.position) return +1;
        return 0;
    }
}

public class daa009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();

        ADN a[] = new ADN[26];

        for(int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);
            ADN l = new ADN(c);
            a[i] = l;
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(a[c - 'A'].position == -1) {
                a[c - 'A'].position = i;
            }

                a[c - 'A'].frequency++;
        }

        Arrays.sort(a);

        for(int i = 0; i < 26; i++) {
            if(a[i].frequency > 0) {
                System.out.println(a[i].letter + " " + a[i].frequency);
            }
        }
    }
}