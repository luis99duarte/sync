import java.util.Scanner;

public class daa006 {


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt; // número de casos

        for(int i = 0; i < n; i++ ) {
            int sx = in.nextInt(); // qx e qx representa o canto inferior esquerdo de cada quadrado
            int sy = in.nextInt();
            double ss = in.nextInt(); // q1 representa o tamanho de cada lado do quadrado

            int cx = in.nextInt(); // cx e cy representam o centro do círculo
            int cy = in.nextInt();
            int cr = in.nextInt(); // cr representa o raio do círculo

            if(cx + cr < sx || cy + cr < sy || cx - cr > sx + ss || cy - cr > sy + ss) {  // não há interseção entre nenhum dos dois
                return 0;
            }

            if(cx - cr >= sx && cy - cr >= sy && cx + cr <= sx + ss && cy + cr <= sy + ss) {  // circunferência completamente dentro do quadrado
                return Math.PI * cr * cr;
            }

            if(sx >= cx - cr && sy >= cy - cr && sx + ss <= cx + cr && sy + ss <= cy + cr) {  // quadrado completamente dentro da circunferência
                return ss * ss;
            }
            
            else {
                intersection(sx, sy, ss, cx, cy, cr);
            }
        }

        return;
    }

    public static double intersection (int sx, int sy, double ss, int cx, int cy, int cr) {
        float area = 0;

        area += intersection(sx, sy, ss / 2, cx, cy, cr); // inferior esquerdo
        area += intersection(sx, sy + ss / 2, ss / 2, cx, cy, cr); // inferior direito
        area += intersection(sx + ss / 2, sy, ss / 2, cx, cy, cr); // superior esquerdo
        area += intersection(sx + ss / 2, sy + ss / 2, ss / 2, cx, cy, cr); // superior direito
        

        return area;
    }
}