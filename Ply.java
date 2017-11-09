import java.util.Optional;
/**
 * Represents one player's move in chess.
 * @author mabdi3
 * @version 1.0
 */
public class Ply {
    private Piece piece;
    private Square from;
    private Square to;
    private Optional<String> comment;

    /**
     * Creates an instance of a player's move with all the
     * required parameters.
     *
     * @param piece the chess piece
     * @param from the Square from which the piece originated
     * @param to the Square to which the piece is going to move
     * @param comment String comment for the player's move
     */
    public Ply(Piece piece, Square from, Square to, Optional<String> comment) {
        this.piece = piece;
        this.from = from;
        this.to = to;
        this.comment = comment;
    }

    /**
     * @return Piece of the move
     */
    public Piece getPiece() {
        return piece;
    }

    /**
     * @return Square from which the piece originated
     */
    public Square getFrom() {
        return from;
    }

    /**
     * @return Square to which the piece is going to move
     */
    public Square getTo() {
        return to;
    }

    /**
     * @return Optional comment for the player's move
     */
    public Optional<String> getComment() {
        return comment;
    }



}