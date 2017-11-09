/**
 * Represents any of six pieces in chess
 *
 * @author mabdi3
 * @version 1.0
 */
public abstract class Piece {

    private Color color;

    /**
     * Creates a chess piece of a given color
     * with all required paramters.
     *
     * @param color the color of the chess piece.
     *
     * @see Color
     */
    public Piece(Color color) {
        this.color = color;
    }

    /**
     * @return this Piece's color
     *
     * @see Color
     */
    public Color getColor() {
        return this.color;
    }

    /**
     * @return true if square is on a chess board
     *
     * @param file file of the square
     * @param rank rank of the sqaure
     */
    public boolean isInBoard(char file, char rank) {
        return file >= 'a' && file <= 'h' && rank >= '1' && rank <= '8';
    }

    /**
     * @return the algebraic name of the piece
     */
    public abstract String algebraicName();

    /**
     * @return the FEN name for the piece
     */
    public abstract String fenName();


    /**
     * @return String representation of the square
     */
    public String toString() {
        return color.toString() + " " + this.getClass();
    }

    /**
     * @return a Square array containing the squares that can be legally
     *         moved to with the all the required parameters.
     *
     * @param square the square of the piece
     */
    public abstract Square[] movesFrom(Square square);


}