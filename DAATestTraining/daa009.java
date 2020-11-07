import java.util.*;

class letter implements Comparable<letter> {
    char c;
    int frequency;
    int position;

    letter(char c) {
        frequency = 0;
        position = -1;
        this.c = c;
    }

    @Override
    public int compareTo(letter l) {
        if(this.frequency > l.frequency) {
            return -1;
        }

        if(this.frequency < l.frequency) {
            return +1;
        }

        if(this.position < l.position) {
            return -1;
        }

        if(this.position > l.position) {
            return +1;
        }

        return 0;
    }
}

public class daa009 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String s = in.next();

        letter ADN[] = new letter[26];

        for(int i = 0; i < 26; i++) {
            char c = (char) ('A' + i);

            letter l = new letter(c);

            ADN[i] = l;
        }

        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if(ADN[c - 'A'].position == -1) {
                ADN[c - 'A'].position = i;
            }

            ADN[c - 'A'].frequency++;
        }

        Arrays.sort(ADN);

        for(int i = 0; i < 26; i++) {
            if(ADN[i].frequency > 0) {
                System.out.println(ADN[i].c + " " + ADN[i].frequency);
            }
        }
    }
}