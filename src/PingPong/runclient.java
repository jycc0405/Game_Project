package PingPong;

public class runclient extends Thread {
    String ip;
    public runclient(String ip){this.ip=ip;}
    @Override
    public void run() {
        PingPong.RemotePlayer.main(ip);
    }
}
