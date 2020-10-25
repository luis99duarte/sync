/* Exercício realizado juntamente com o Telmo Ribeiro 201805124 */

import java.util.Scanner;

class Point {
    double x;
    double y;

    Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class daa006v1 {
    public static boolean checkCircleInSquare(Point A, Point B, Point C, int radius) {
        if (A.x <= C.x - radius && A.y <= C.y - radius && B.x >= C.x + radius && B.y >= C.y + radius) { return true; }

        return false;
    }

    public static boolean checkSquareInCircle(Point A, Point B, Point C, int radius) {
        Point D = new Point(B.x, A.y);
        Point E = new Point(A.x, B.y);

        if (
            Math.pow(A.x - C.x, 2) + Math.pow(A.y - C.y, 2) <= Math.pow(radius, 2) &&
            Math.pow(B.x - C.x, 2) + Math.pow(B.y - C.y, 2) <= Math.pow(radius, 2) &&
            Math.pow(D.x - C.x, 2) + Math.pow(D.y - C.y, 2) <= Math.pow(radius, 2) &&
            Math.pow(E.x - C.x, 2) + Math.pow(E.y - C.y, 2) <= Math.pow(radius, 2)
        ) { return true; }

        return false;
    }

    public static boolean checkNoneIn(Point A, Point B, Point C, int radius) {
        if (A.x > C.x + radius || A.y > C.y + radius || B.x < C.x - radius || B.y < C.y - radius) { return true; }

        return false;
    }

    public static double intersection(Point A, Point B, Point C, int radius) {
        if (checkCircleInSquare(A, B, C, radius)) { return Math.PI * Math.pow(radius, 2); } // círculo dentro do quadrado logo área do círculo

        if (checkSquareInCircle(A, B, C, radius)) { return (B.x - A.x) * (B.y - A.y); } // quadrado dentro do círculo logo área do quadrado

        if (checkNoneIn(A, B, C, radius)) { return 0; } // não há interseção

        double area = 0;

        Point D = new Point((B.x - A.x) / 2.0 + A.x, (B.y - A.y) / 2.0 + A.y);
        Point E = new Point(D.x, A.y);
        Point F = new Point(B.x, D.y);
        Point G = new Point(A.x, D.y);
        Point H = new Point(D.x, B.y);

        if (B.x - A.x > 0.01) {
            area += intersection(A, D, C, radius); // quadrado inferior esquerdo
            area += intersection(E, F, C, radius); // quadrado inferior direito
            area += intersection(G, H, C, radius); // quadrado superior esquerdo
            area += intersection(D, B, C, radius); // quadrado superior direito
        }

        return area;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int N = input.nextInt();

        for (int i = 0; i < N; i++) {
            int x;
            int y;
            int side;
            int radius;

            x = input.nextInt();
            y = input.nextInt();
            Point A = new Point(x, y); // ponto inferior esquerdo do quadrado

            side = input.nextInt();

            x += side;
            y += side;
            Point B = new Point(x, y); // ponto superior direito do quadrado

            x = input.nextInt();
            y = input.nextInt();
            Point C = new Point(x, y); // ponto central da circunferência
           
            radius = input.nextInt(); // raio da circunferência

            System.out.println(intersection(A, B, C, radius));
        }
    }
}
