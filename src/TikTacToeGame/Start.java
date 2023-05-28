package TikTacToeGame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

public class Start extends Frame implements ActionListener {
    private static final long serialVersionUID = 0L;
    private final TextField server;
    private String host;
    private int port = 9888;
    private final Button c;
	private final Button start;
	private final Button stop;
    private Server s = null;

    public Start() {
        super("Tic-Tac-Toe");
        setLayout(new GridLayout(0, 2));

        c = new Button("Start Client");
        c.addActionListener(this);
        add(c);

        server = new TextField("localhost:31137");
        add(server);

        start = new Button("Start Server");
        start.addActionListener(this);
        add(start);
        stop = new Button("Stop Server");
        stop.addActionListener(this);
        add(stop);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        setSize(200, 200);
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation((int) (Math.random() * (dim.getHeight() - 200)), (int) (Math.random() * (dim.getHeight() - 200)));
        setVisible(false);
    }

    public static void main(String[] args) {
        new Start();
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == c) {
            try {
                parseHost();
                new Client(host, port);
            } catch (IOException io) {
                new MessageBox(getTitle(), "Error connecting to Server: " + io.getMessage());
            }
        } else if (e.getSource() == start) {
            if (s != null)
                s.interrupt();
            parseHost();
            s = new Server(port);
            s.start();
        } else if (e.getSource() == stop) {
            if (s != null)
                s.interrupt();
            s = null;
        }
    }

    public void parseHost() {
        String[] socket = server.getText().split(":");
        host = socket[0];
        if (socket.length > 1) {
            try {
                int port = Integer.parseInt(socket[1]);
                this.port = (port >= 1024 && port < 0xFFFF) ? port : Protocol.DEFAULTPORT;
            } catch (NumberFormatException e) {
                this.port = Protocol.DEFAULTPORT;
            }
        } else {
            this.port = Protocol.DEFAULTPORT;
        }
    }

    public void TikClient(String ip) {
        try {
            parseHost();
            new Client(ip, port);
        } catch (IOException io) {
            new MessageBox(getTitle(), "Error connecting to Server: " + io.getMessage());
        }
    }

    public void TikServer() {
        if (s != null)
            s.interrupt();
        parseHost();
        s = new Server(port);
        s.start();
    }
}

