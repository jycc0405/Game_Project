package OmokServer.Server;

import OmokServer.model.Model;

import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {
    public static void main() {
        ServerSocket serverSocket = null;
        Model model = null;
        try {
            serverSocket = new ServerSocket(9999);
            model = new Model();
            while (true) {
                Socket socket = serverSocket.accept();
                Thread thread = new PerClientThread(socket, model);
                thread.start();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
