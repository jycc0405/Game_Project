package PingPong;

public class runclient extends Thread{
    @Override
    public void run() {
        PingPong.RemotePlayer.main("localhost");
    }
}
