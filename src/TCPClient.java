import java.io.*;
import java.net.*;

public class TCPClient {

    public static void main(String[] args) throws IOException {

        String hostname = "localhost";
        int port = 8088;

        /*String hostname;
        int port;
        // Vérifier les arguments de la ligne de commande
        if (args.length == 2) {
            hostname = args[0];
            port = Integer.parseInt(args[1]);
        } else {
            System.err.println("Usage: java TCPClient hostname port");
            return;
        }

         */
        // Créer un socket de connexion au serveur
        Socket clientSocket = new Socket(hostname, port);

        // Créer des flux d'entrée et de sortie pour envoyer et recevoir des données
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        // Boucle pour lire au clavier jusqu'à fermeture de l'entrée standard
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        String sentence;
        while ((sentence = inFromUser.readLine()) != null) {
            // Envoyer la ligne au serveur
            outToServer.writeBytes(sentence + '\n');

            // Lire la réponse du serveur
            String modifiedSentence = inFromServer.readLine();

            // Afficher la réponse à l'écran
            System.out.println("FROM SERVER: " + modifiedSentence);
        }

        // Fermer le socket de connexion
        clientSocket.close();
    }
}
