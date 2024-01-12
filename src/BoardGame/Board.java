package BoardGame;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Erro creating board!");
        }
        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    public Piece piece(int row, int colunm) {
        if (!positionEcxists(row, colunm)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[row][colunm];
    }

    public Piece piece(Position position) {
        if (!positionEcxists(position)) {
            throw new BoardException("Position not on the board");
        }
        return pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position) {
        if (thereIsAPiece(position)) {
            throw new BoardException("There is already piece on position: " + position);
        }
        // pega a peça e coloca na posição dada
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    private boolean positionEcxists(int row, int column) {
        return row >= 0 && row < rows && column >= 0 && column < columns;
    }

    public boolean positionEcxists(Position position) {
        return positionEcxists(position.getRow(), position.getColumn());
    }

    public boolean thereIsAPiece(Position position) {
        if (!positionEcxists(position)) {
            throw new BoardException("There is already piece on position" + position);
        }
        return piece(position) != null;
    }

}
