import java.io.*;
import java.net.*;

class TCPClient {
   public static void main(String argv[]) throws Exception
   {
      String sentence;
      String modifiedSentence;

      BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

      String S = args[2];
      int P = Integer.parseInt(argv[1]);

      System.out.println(S);
      System.out.println(P);

      Socket clientSocket = new Socket(S, P);

      DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

      BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));

      sentence = inFromUser.readLine();

      outToServer.writeBytes(sentence + '\n');

      modifiedSentence = inFromServer.readLine();

      System.out.println("FROM SERVER: " + modifiedSentence);
      
      clientSocket.close();
   }
}
