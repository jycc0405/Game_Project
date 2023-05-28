package PingPong;

import MainUI.MainUI;
import OmokGame.Client.Mainclient;
import TikTacToeGame.Start;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class Main extends JFrame{
    private final String FRAME_TITLE="핑퐁";
    private int[] FRAME_SIZE={300,200};
    private int FRAME_LOC_X = 500;
    private int FRAME_LOC_Y = 100;


    public void main(){
        MainUI();
    }
    public void MainUI() {
        setSize(FRAME_SIZE[0], FRAME_SIZE[1]);
        setTitle(FRAME_TITLE);
        setLocation(FRAME_LOC_X, FRAME_LOC_Y);

        JPanel buttons = new JPanel();

        buttons.setLayout(new GridLayout(2,1,10,10));

        JButton psBt = new JButton("서버");
        JButton pcBt = new JButton("클라리언트");


        //--------------------------------------------------------------------------------------------//

        buttons.add(psBt);
        buttons.add(pcBt);

        add(buttons);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        psBt.addActionListener((ActionEvent e) -> {
            System.out.println("핑퐁서버");
            PingPong.runserver runserver = new runserver();
            runserver.start();
        });

        pcBt.addActionListener((ActionEvent e) -> {
            System.out.println("핑퐁클라");
            PingPong.runclient runclient = new runclient();
            runclient.start();
        });

    }
}
