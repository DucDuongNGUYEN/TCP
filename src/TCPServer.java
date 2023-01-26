import java.io.*;
import java.net.*;

public class TCPServer {

    public static void main(String[] args) throws IOException {

        int port = 8088;

        // Créer un socket d'écoute sur le port spécifié
        ServerSocket welcomeSocket = new ServerSocket(port);

        while (true) {
            // Accepter une connexion entrante
            Socket connectionSocket = welcomeSocket.accept();

            // Créer des flux d'entrée et de sortie pour envoyer et recevoir des données
            BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
            DataOutputStream outToClient = new DataOutputStream(connectionSocket.getOutputStream());

            // Lire les données reçues
            String clientSentence = inFromClient.readLine();

            // Précéder les données reçues d'un ">" et envoyer les données modifiées de retour au client
            String modifiedSentence = ">" + clientSentence;
            outToClient.writeBytes(modifiedSentence + '\n');
        }
    }
}

