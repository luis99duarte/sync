import java.util.*;
import java.lang.*;

public class daa003 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int n = in.nextInt();

        String fill = in.nextLine(); // o telmo confia...

        for (int i = 0; i < n; i++) {
            String pairPlate = in.nextLine();

            /* código teste
            System.out.println(pairPlate);
            */

            String[] plate = pairPlate.split(" ");

            /* código teste
            System.out.println(plate[0]);
            System.out.println(plate[1]);
            */

            String[] pairA = plate[0].split("-"); // o telmo confia MUITO...
            String[] pairB = plate[1].split("-"); // o telmo confia MUITO...

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

   public static int converter(String[] pair) {
        // começar com divisão entre gerações (if...)
        // em cada geração tem o número da primeira matrícula atribuído e depois vai identando
        // calcula como se fosse para a primeira geração e depois soma o valor atribuído à geração
        // converte as letras para números a partir do ASCII (Z - A = 22)
        // concatenar os com números (integer parse int)
        // Somar o valor direto dos números ao valor dado pelas letras e somar com 1 por causa da matrícula com 00
        /* Para cada letra mais à direita basta somar o número com 10000*X. Para cada letra à esquerda soma-se tudo o que obtemos
           com 230000 */    
        //retornar esse int

        if(pair[0].isLetter() && pair[1].isDigit() && pair[2].isDigit()) { // geração 1
            
        }
   }
}