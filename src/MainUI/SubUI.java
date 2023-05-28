package MainUI;

import ChessGame.runChess;
import OmokGame.Client.Mainclient;
import OmokServer.Server.runOmokServer;
import PingPong.Server;
import PingPong.runclient;
import PingPong.runserver;
import TikTacToeGame.Start;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SubUI extends JFrame {
    String name;
    private final String FRAME_TITLE = "서버/클라리언트";
    private final int[] FRAME_SIZE = {400, 80};
    private final int FRAME_LOC_X = 700;
    private final int FRAME_LOC_Y = 300;

    public SubUI(String name){this.name=name;}

    public void SubUI() {
        OmokServer.Server.runOmokServer Omokserver = new runOmokServer();
        PingPong.runserver pingpongserver = new runserver();
        Start TikTacToe = new Start();

        setSize(FRAME_SIZE[0], FRAME_SIZE[1]);
        setTitle(name+" 생성");
        setLocation(FRAME_LOC_X, FRAME_LOC_Y);

        JPanel main = new JPanel();

        JButton psBt = new JButton("서버 생성");
        if (name.equals("핑퐁")){psBt.setText("서버측 클라리언트 생성");}
        JButton pcBt = new JButton("클라리언트 생성");

        psBt.setBounds(40,50,110,75);
        pcBt.setBounds(40,50,220,150);


        //--------------------------------------------------------------------------------------------//

        main.add(psBt);
        main.add(pcBt);

        add(main,BorderLayout.CENTER);

        setVisible(true);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        psBt.addActionListener((ActionEvent e) -> {
            if(psBt.getText().equals("서버 생성")||psBt.getText().equals("서버측 클라리언트 생성")) {
                switch (name) {
                    case "오목":
                        System.out.println("오목서버");
                        Omokserver.start();
                        psBt.setText("서버 중지");
                        break;
                    case "체스" :
                        break;
                    case "틱택토" :
                        System.out.println("틱택토서버");
                        TikTacToe.TikServer();
                        psBt.setText("서버 중지");
                        break;
                    case "핑퐁" :
                        System.out.println("핑퐁서버");
                        pingpongserver.start();
                        psBt.setText("생성 완료");
                        break;
                    default:
                        break;
                }
            } else if (psBt.getText().equals("서버 중지")) {
                switch (name) {
                    case "오목":
                        System.out.println("오목서버");
                        Omokserver.serverstop();
                        psBt.setText("서버 생성");
                        break;
                    case "체스" :
                        break;
                    case "틱택토" :
                        break;
                    case "핑퐁" :
                        System.out.println("핑퐁서버");
                        pingpongserver.serverstop();
                        psBt.setText("서버 생성");
                        break;
                    default:
                        break;
                }
            }
        });

        pcBt.addActionListener((ActionEvent e) -> {
            JTextField ip = new JTextField(20);
            JPanel connectPanel = new JPanel();
            connectPanel.add(new JLabel("서버 아이피:"));
            connectPanel.add(ip);
            connectPanel.add(Box.createHorizontalStrut(15)); //spacer
            int result = JOptionPane.showConfirmDialog(null, connectPanel, "Enter connection information", JOptionPane.OK_CANCEL_OPTION);
            if (result == JOptionPane.OK_OPTION) {
                String serverip = ip.getText();
                switch (name) {
                    case "오목" :
                        System.out.println("오목클라");
                        Mainclient.main(serverip);
                        break;
                    case "체스" :
                        break;
                    case "틱택토" :
                        TikTacToe.TikClient(serverip);
                        break;
                    case "핑퐁" :
                        System.out.println("핑퐁클라");
                        PingPong.runclient runclient = new runclient(serverip);
                        runclient.start();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}
