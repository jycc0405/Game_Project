package MainUI;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.InetAddress;

public class MainUI extends JFrame {

    private final String FRAME_TITLE = "메인창";
    private final int[] FRAME_SIZE = {700, 600};
    private final int FRAME_LOC_X = 500;
    private final int FRAME_LOC_Y = 100;
    InetAddress ip=null;

    public MainUI() {
        setSize(FRAME_SIZE[0], FRAME_SIZE[1]);
        setTitle(FRAME_TITLE);
        setLocation(FRAME_LOC_X, FRAME_LOC_Y);

        JButton OmokBt = new JButton("오목");
        JButton ChesstBt = new JButton("체스");
        JButton TiktaktoeBt = new JButton("틱택토");
        JButton PingpongBt = new JButton("핑퐁");
        JButton QuitBt = new JButton("종료");

        OmokBt.setBounds(130, 180, 100, 45);
        ChesstBt.setBounds(130, 250, 100, 45);
        TiktaktoeBt.setBounds(250, 180, 100, 45);
        PingpongBt.setBounds(250, 250, 100, 45);
        QuitBt.setBounds(130, 320, 100, 45);

        //--------------------------------------------------------------------------------------------//
        try {
            ip = InetAddress.getLocalHost();
        }catch (Exception e){e.printStackTrace();}
        JLabel ipLb = new JLabel("내 아이피 : "+ip.getHostAddress());
        ipLb.setBounds(50,500,200,30);

        JLabel background = new JLabel(new ImageIcon(getClass().getResource("/res/MBG.png")));
        add(background);

        background.add(OmokBt);
        background.add(ChesstBt);
        background.add(TiktaktoeBt);
        background.add(PingpongBt);
        background.add(ipLb);
        background.add(QuitBt);

        setVisible(true);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        OmokBt.addActionListener((ActionEvent e) -> {
            System.out.println("오목");
            SubUI subUI = new SubUI("오목");
            subUI.SubUI();
        });

        ChesstBt.addActionListener((ActionEvent e) -> {
            System.out.println("체스");
            try {
                ProcessBuilder pb = new ProcessBuilder("java", "-cp", "bin", "ChessStart");
                pb.start();
                ProcessBuilder pb1 = new ProcessBuilder("java", "-cp", "out/production/Game_Project", "ChessStart");
                pb1.start();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        TiktaktoeBt.addActionListener((ActionEvent e) -> {
            System.out.println("틱택톡");
            SubUI subUI = new SubUI("틱택토");
            subUI.SubUI();
        });

        PingpongBt.addActionListener((ActionEvent e) -> {
            System.out.println("핑퐁");
            SubUI subUI = new SubUI("핑퐁");
            subUI.SubUI();
        });

        QuitBt.addActionListener((ActionEvent e) -> {
            System.exit(0);
        });
    }
}

