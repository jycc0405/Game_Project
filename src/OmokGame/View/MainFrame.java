package OmokGame.View;
import java.awt.Container;
import java.io.File;
import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MainFrame extends JFrame {
	public Container contentPane=this.getContentPane();
	AudioInputStream ais;
	Clip clip;

	
	public void introbgmplay() {
		try {
			InputStream file=getClass().getResourceAsStream("src/OmokGame/res/bgm.wav");
			//ais=AudioSystem.getAudioInputStream(new File(getClass().getResourceAsStream("src/OmokGame/res/bgm.wav")));
			ais = AudioSystem.getAudioInputStream(new File("src/OmokGame/res/bgm.wav"));
			//ais = AudioSystem.getAudioInputStream(file);
			clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void introbgmstop(){
		clip.stop();
	}
	
	public MainFrame(){
		setTitle("5MOK_by_Sku_Junyeong");

	}
	
	//---------------------------------------------------------------------
	public void play() {
		try {
			AudioInputStream ais = AudioSystem.getAudioInputStream(new File("src/OmokGame/res/win.wav"));
			Clip clip = AudioSystem.getClip();
			clip.open(ais);
			clip.start();
		} catch (Exception e) {
			System.out.println("에러");
		}
	}
	
	public void endgame(String message,JPanel board,JPanel intro){
		int yes = JOptionPane.showConfirmDialog(this,message,"승리!",JOptionPane.YES_OPTION);
		if(yes==JOptionPane.YES_OPTION){
			System.exit(1);
		}
	}
	//---------------------------------------------------------------------
}
