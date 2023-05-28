package TikTacToeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MessageBox extends Frame implements ActionListener {
    private static final long serialVersionUID = 0L;

    public MessageBox(String title, String message) {
        super(title);
        setResizable(false);
        setLayout(new BorderLayout());

        Label l = new Label(message);
        add(l, BorderLayout.NORTH);

        Button b = new Button("OK");
        b.addActionListener(this);
        add(b, BorderLayout.SOUTH);

        pack();
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(((int) dim.getWidth() / 2 - getWidth() / 2), ((int) dim.getHeight() / 2 - getHeight() / 2));
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        dispose();
    }

}
