package OmokGame.Controller;

import OmokGame.Model.Model;
import OmokGame.View.Board;
import OmokGame.View.Controller;
import OmokGame.View.MainFrame;

import javax.swing.*;
import java.awt.*;
import java.io.PrintWriter;
import java.net.Socket;

public class Viewcontroller {
    MainFrame frame;
    Model model;
    Socket socket;
    Board board;
    PrintWriter writer;

    public Viewcontroller(MainFrame frame, Model model, Socket socket, PrintWriter writer, Board board) {
        this.frame = frame;
        this.model = model;
        this.socket = socket;
        this.writer = writer;
        this.board = board;
/////////////////////////////////////////////////

        frame.contentPane.add(board);
        frame.setPreferredSize(new Dimension(900, 1000));
        frame.setLocation(500, 20);
        frame.contentPane.add(board);
        board.addMouseListener(new Controller(model, board, frame, writer));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
