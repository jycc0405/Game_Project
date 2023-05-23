package OmokGame.View;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.PrintWriter;
import java.util.HashMap;

import javax.swing.JOptionPane;

import OmokGame.Model.Model;

public class Controller implements MouseListener {
	Model model;
	Board board;
	MainFrame frame;
	PrintWriter writer;

	// ****************************************************************************************8
	public Controller(Model model, Board board, MainFrame frame, PrintWriter writer) {
		this.model = model;
		this.board = board;
		this.frame = frame;
		this.writer = writer;
	}

	@Override
	public void mouseClicked(MouseEvent e) {

		// ********************************************
		int X = e.getX();
		int Y = e.getY();
		int my_turn = model.getMy_turn();
		int game_turn = model.getGame_turn();
		HashMap<String, Integer> map = new HashMap<String, Integer>();
		System.out.println("my ; " + my_turn + " game : " + game_turn);
		final int d = 50;
		for (int i = 0; i < 15; i++) {
			for (int j = 0; j < 15; j++) {
				if (((X > model.X_START + (d * i)) && (X < model.X_START + (d * (i + 1))))
						&& ((Y > model.Y_START + (d * j)) && (Y < model.Y_START + (d * (j + 1))))) {

					if (my_turn == game_turn && my_turn == 2) {
						if (model.getArr(i, j) == 0) {
//							
							model.setArr(model.WHITE, i, j);
							model.setPastwhite_x(model.getWhite_x());
							model.setPastwhite_y(model.getWhite_y());
							model.setWhite_x(i);
							model.setWhite_y(j);
							board.repaint();

							model.setGame_turn(3 - game_turn);
							map.put("game_turn", game_turn);
							map.put("x", i);
							map.put("y", j);
							writer.println(map);
							writer.flush();
							model.stonesound();
							if ((model.white_heightcheck(i, j) == true || model.white_widthcheck(i, j) == true
									|| model.white_leftdiagcheck(i, j) == true
									|| model.white_rightdiagcheck(i, j) == true || model.Wwinstate == true)) {
								frame.play();
								writer.println("!whitewin!");
								writer.flush();
								model.Wwinstate = true;
								frame.setSize(900, 900);
							}

						}
					} else if (my_turn == game_turn && my_turn == 1) {
						if (model.getArr(i, j) == 0) {
							model.setArr(model.BLACK, i, j);
							model.setPastblack_x(model.getBlack_x());
							model.setPastblack_y(model.getBlack_y());
							model.setBlack_x(i);
							model.setBlack_y(j);
							board.repaint();
							model.setGame_turn(3 - game_turn);

							map.put("game_turn", game_turn);
							map.put("x", i);
							map.put("y", j);
							writer.println(map);
							writer.flush();
							model.stonesound();
							if ((model.black_heightcheck(i, j) == true || model.black_widthcheck(i, j) == true
									|| model.black_leftdiagcheck(i, j) == true
									|| model.black_rightdiagcheck(i, j) == true || model.Bwinstate == true)) {
								frame.play();
								writer.println("!blackwin!");
								writer.flush();
								model.Bwinstate = true;
								frame.setSize(900, 900);
							}
						}
					}

				}
			}
		}
		
		// ----------------------------------------------------�׺��ϱ� ���
		if ((X > 250 && X < 450) && (Y > 830 && Y < 906)) {
			System.out.println("112");
			int result = JOptionPane.showConfirmDialog(frame, "정말 이대로 항복하실겁니까?", "항복", JOptionPane.YES_NO_OPTION);
			if (result == JOptionPane.YES_OPTION) {
				if (my_turn == 1) {
					frame.play();
					model.Wwinstate=true;
					writer.println("!Wwinstate!");
					writer.flush();
				} else if (my_turn == 2) {
					frame.play();
					model.Bwinstate=true;
					writer.println("!Bwinstate!");
					writer.flush();
				}
			}
		}
		// -------------------------------------------------
		if ((X > 500 && X < 700) && (Y > 830 && Y < 906)) {
			if (my_turn != game_turn) {
				reverseturn();
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mousePressed(MouseEvent arg0) {

	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub

	}

	// ----------------------------------------------------------------
	public void reverseturn() {

		HashMap<String, Integer> map = new HashMap<String, Integer>();

		if (model.getMy_turn() == 1) {
			if (model.b_reverseCount != 0) {
				model.setArr(0, model.getBlack_x(), model.getBlack_y());
				map.put("Rx", model.getBlack_x());
				map.put("Ry", model.getBlack_y());
				map.put("pastX", model.getPastblack_x());
				map.put("pastY", model.getPastblack_y());
				writer.println(map);
				writer.flush();
				board.repaint();
				model.b_reverseCount--;
			}
		} else if (model.getMy_turn() == 2) {
			if (model.w_reverseCount != 0) {
				model.setArr(0, model.getWhite_x(), model.getWhite_y());

				map.put("Rx", model.getWhite_x());
				map.put("Ry", model.getWhite_y());
				map.put("pastX", model.getPastwhite_x());
				map.put("pastY", model.getPastwhite_y());
				writer.println(map);
				writer.flush();
				board.repaint();
				model.w_reverseCount--;
			}
		}

	}

}
