/**
 * Represents the Queen piece in chess
 * @author mabdi3
 * @version 1.0
 */
public class Queen extends Piece {
    /**
     * Creates a Pawn chess piece of a given color
     *
     * @param c the color of the piece
     *
     * @see Color
     */
    public Queen(Color c) {
        super(c);
    }
    @Override
    public String algebraicName() {
        return "Q";
    }
    @Override
    public String fenName() {
        return getColor() == Color.WHITE ? "Q" : "q";
    }
    @Override
    public Square[] movesFrom(Square square) {
        Square[] sq = new Square[64];
        int counter = 0;
        char rank = square.getRank();
        char file = square.getFile();

        for (int i = 1; i <= 8; i++) {
            char[] ranks = new char[]{(char) (rank + i), (char) (rank - i)};
            char[] files = new char[]{(char) (file + i), (char) (file - i)};
            if (isInBoard(files[0], ranks[0])) {
                sq[counter++] = new Square(files[0], ranks[0]);
            }
            if (isInBoard(files[1], ranks[0])) {
                sq[counter++] = new Square(files[1], ranks[0]);
            }
            if (isInBoard(files[0], ranks[1])) {
                sq[counter++] = new Square(files[0], ranks[1]);
            }
            if (isInBoard(files[1], ranks[1])) {
                sq[counter++] = new Square(files[1], ranks[1]);
            }
            if (isInBoard(files[0], rank)) {
                sq[counter++] = new Square(files[0], rank);
            }
            if (isInBoard(files[1], rank)) {
                sq[counter++] = new Square(files[1], rank);
            }
            if (isInBoard(file, ranks[0])) {
                sq[counter++] = new Square(file, ranks[0]);
            }
            if (isInBoard(file, ranks[1])) {
                sq[counter++] = new Square(file, ranks[1]);
            }
        }

        Square[] full = new Square[counter];
        for (int i = 0; i < counter; i++) {
            full[i] = sq[i];
        }

        return full;
    }
}