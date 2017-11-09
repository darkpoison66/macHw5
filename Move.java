/**
 * Represents one turn of chess, both White's Ply and Blacks Ply
 *
 * @version 1.0
 * @author mabdi3
 */
public class Move {
    private Ply whitePly;
    private Ply blackPly;

    /**
     * Create an instance of a turn of chess with
     * all the required parameters.
     *
     * @param whitePly the white player's move
     * @param blackPly the black player's move
     */
    public Move(Ply whitePly, Ply blackPly) {
        this.whitePly = whitePly;
        this.blackPly = blackPly;
    }

    /**
     * @return the white player's move
     */
    public Ply getWhitePly() {
        return whitePly;
    }

    /**
     * @return the black player's move
     */
    public Ply getBlackPly() {
        return blackPly;
    }

    /**
     * @return String representation of a move
     */
    public String toString() {
        return "" + whitePly.getTo().toString() + ", "
                  + blackPly.getTo().toString();
    }


}