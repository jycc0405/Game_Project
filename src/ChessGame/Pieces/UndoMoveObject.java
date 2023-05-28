package ChessGame.Pieces;

public class UndoMoveObject {
    private final ChessPiece pieceTakenOffBoard;
    private final ChessPiece pieceLastMoved;

    private final int lastCol;
    private final int lastRow;
    private boolean hadntMoved;

    private boolean castle;

    public UndoMoveObject(ChessPiece piece, int lastRow, int lastCol, ChessPiece gonePiece) {
        pieceLastMoved = piece;
        pieceTakenOffBoard = gonePiece;
        this.lastRow = lastRow;
        this.lastCol = lastCol;
    }

    public int getLastRow() {
        return lastRow;
    }

    public int getLastCol() {
        return lastCol;
    }

    public ChessPiece getTakenPiece() {
        return pieceTakenOffBoard;
    }

    public ChessPiece getUndoPiece() {
        return pieceLastMoved;
    }

    public boolean hadNotMoved() {
        return hadntMoved;
    }

    public void setNotMoved() {
        hadntMoved = true;
    }

    public void isCastle() {
        castle = true;
    }

    public boolean checkIfCastle() {
        return castle;
    }
}