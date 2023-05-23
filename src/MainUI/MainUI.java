package MainUI;

import OmokGame.Client.Mainclient;
import OmokServer.Server.MainServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainUI extends JFrame {

    private final String FRAME_TITLE="메인창";
    private int[] FRAME_SIZE={700,600};
    private int FRAME_LOC_X = 500;
    private int FRAME_LOC_Y=100;

    public MainUI(){
        setSize(FRAME_SIZE[0],FRAME_SIZE[1]);
        setTitle(FRAME_TITLE);
        setLocation(FRAME_LOC_X,FRAME_LOC_Y);

        JButton OmokBt = new JButton("오목");
        JButton ChesstBt = new JButton("체스");

        OmokBt.setBounds(130,180,100,45);
        ChesstBt.setBounds(130,250,100,45);

        //--------------------------------------------------------------------------------------------//

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/res/MBG.png")));
        add(background);

        background.add(OmokBt);
        background.add(ChesstBt);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        OmokBt.addActionListener((ActionEvent e) ->{
            System.out.println("오목");
            Mainclient.main();
        });

        ChesstBt.addActionListener((ActionEvent e) ->{
            System.out.println("체스");
        });

    }

}

