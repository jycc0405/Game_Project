package OmokGame.View;

import javax.swing.*;
import java.awt.*;

@SuppressWarnings("serial")
public class GameIntro extends JPanel {
    MainFrame frame;
    ImageIcon back;
    JTextField namefield;
    ImageIcon title;


    public GameIntro(MainFrame frame) {
        this.frame = frame;
        setLayout(null);
        back = new ImageIcon("src/OmokGame/res/introBackground.jpg");
        title = new ImageIcon("src/OmokGame/res/networktitle.png");

        setOpaque(false);
    }

    public void paintComponent(Graphics g) {
        g.drawImage(back.getImage(), 0, 0, 900, 1000, null);
        g.drawImage(title.getImage(), 50, 50, 800, 500, null);
    }
}
