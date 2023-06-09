package ChessGame.Pieces;

public class whiteKnight extends ChessPiece {
    public whiteKnight(int row, int col) {
        this.row = row;
        this.col = col;
        letter = 'N';
    }

    public boolean canMoveToLocation(ChessPiece[][] board, int finalRow, int finalCol) {
        int dx = finalCol - col;
        int dy = finalRow - row;
        if ((Math.abs(dx) == 2 && Math.abs(dy) == 1) || (Math.abs(dx) == 1 && Math.abs(dy) == 2)) {
            if (board[finalRow][finalCol] == null) return true;
			return board[finalRow][finalCol].getClass().getName().charAt(7 + 10) == 'b';
        }
        return false;
    }

    public boolean possibleEnPassant() {
        return false;
    }

    public void switchEnPassant() {
    }

    public boolean amIInCheck(ChessPiece[][] board) {
        return false;
    }
}