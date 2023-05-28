package PingPong;

public class runserver extends Thread {
    boolean run= true;
    @Override
    public void run() {
            PingPong.Server.main();

    }
    public void serverstop(){
        run=false;
    }
}
