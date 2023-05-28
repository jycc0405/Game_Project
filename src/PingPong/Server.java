package PingPong;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by matiaskaskimies on 27/01/15.
 */

/*
    Server class starts the server and makes the game
 */

public class Server {
    static Socket sock = null;
    public static void main() {

        // create serversocket


        try {
            // new serversocket on port 3777
            ServerSocket ss = new ServerSocket(3777);
            ss.setSoTimeout(20000);
            System.out.println("waiting for connection...");
            sock = ss.accept();
            // after client is conntected create new game
            Game game = new Game(sock);
            System.out.println("Game created");

        } catch (IOException e) {
            System.err.print(e);
        }

    }

}
