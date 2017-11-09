/**
 * Represents the Pawn piece in chess
 * @author mabdi3
 * @version 1.0
 */
public class Pawn extends Piece {
    /**
     * Creates a Pawn chess piece of a given color
     *
     * @param c the color of the piece
     *
     * @see Color
     */
    public Pawn(Color c) {
        super(c);
    }
    @Override
    public String algebraicName() {
        return "";
    }
    @Override
    public String fenName() {
        return getColor() == Color.WHITE ? "P" : "p";
    }
    @Override
    public Square[] movesFrom(Square square) {
        char rank = square.getRank();
        char file = square.getFile();
        if (getColor() == Color.WHITE) {
            if (rank == '8') {
                return new Square[0];
            } else if (rank == '2') {
                return new Square[]{new Square(file, '4'),
                                    new Square(file, '3')};
            } else {
                return new Square[]{new Square(file, (char) (rank + 1))};
            }
        } else {
            if (rank == '1') {
                return new Square[0];
            } else if (rank == '7') {
                return new Square[]{new Square(file, '5'),
                                    new Square(file, '6')};
            } else {
                return new Square[]{new Square(file, (char) (rank - 1))};
            }
        }
    }
}