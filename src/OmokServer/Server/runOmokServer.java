package OmokServer.Server;

import ChessGame.Chess;

public class runOmokServer extends Thread{
    boolean run=true;
    @Override
    public void run() {

        while (run){MainServer.main();}
    }
    public void serverstop(){run=false;}
}
