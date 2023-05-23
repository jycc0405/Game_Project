package OmokGame.Client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

import OmokGame.Model.Model;
import OmokGame.View.Board;
import OmokGame.View.GameIntro;
import OmokGame.View.MainFrame;

public class Mainclient {
//	
	
	public static void main(){
		Model model;

		try {
			model = new Model();
			InetAddress ip = InetAddress.getLocalHost();
			Socket socket = new Socket(ip,9999);
			MainFrame frame = new MainFrame();
			ImageIcon startbutton = new ImageIcon("src/OmokGame/res/startbutton.png");
			JButton namebutton = new JButton(startbutton);
			GameIntro panel = new GameIntro(frame);
			Board board = new Board(model);
			JTextField namefield = new JTextField("이름을 입력해주세요:");
			ImageIcon waitimage= new ImageIcon("src/OmokGame/res/waiting.png");
			JButton bt= new JButton(waitimage);
			Font font = new Font("Courier", Font.BOLD, 22);
			
			PrintWriter writer = new PrintWriter(socket.getOutputStream());
			ActionListener listener = new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					String name = namefield.getText();
					panel.removeAll();
					panel.add(bt);
					bt.setSize(814, 237);
					bt.setLocation(50,550);
					bt.setBorderPainted(false);
					bt.setBackground(new Color(255,0,0,0));
					bt.setContentAreaFilled(false);
					panel.repaint();
					
					Thread thread1 = new SenderThread(socket,name, model,writer);
					Thread thread2 = new ReceiverThread(socket, model, board,frame, writer);
					thread1.start();
					thread2.start();
					
				}
			};
			
			
			panel.setLayout(null);
			panel.add(namefield);
			panel.add(namebutton);
			namefield.setLocation(300, 600);
			namefield.setSize(300, 60);
			namefield.setFont(font);
			namebutton.setLocation(300, 700);
			namebutton.setSize(300, 80);
			namebutton.addActionListener(listener);
			namebutton.setBorderPainted(false);
			namebutton.setContentAreaFilled(false);
			
			
			frame.introbgmplay();
			frame.contentPane.add(panel,BorderLayout.CENTER);
			
			frame.setPreferredSize(new Dimension(900, 900));// 프레임크기 지정
			frame.setLocation(500, 20);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.pack();
			frame.setVisible(true);
			
			
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
	}
}
