import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.List;
import java.util.stream.Stream;


/**
 * Represnts a squence of Moves in a game of chess
 * @version 1.0
 * @author mabdi3
 */
public class ChessGame {
    private List<Move> moves = new ArrayList<>();;
    private List<Move> filteredInnerList;
    private Piece filterPiece;

    /**
     * Creates an instance of a ChessGame with all
     * the required parameters.
     *
     * @param moves List of moves
     */
    public ChessGame(List<Move> moves) {
        this.moves = moves;
    }

    /**
     * @return the List of moves
     */
    public List<Move> getMoves() {
        return moves;
    }

    /**
     * @return the nth move
     * @param n the nth move
     */
    public Move getMove(int n) {
        return moves.get(n);
    }

    /**
     * @return a list filtered  by the Predicate filter
     * @param filter filter for which the list should be ordered
     */
    public List<Move> filter(Predicate<Move> filter) {
        List<Move> filteredList = new ArrayList<>();
        Stream<Move> stream = moves.stream();
        stream.filter(filter).forEach((a) -> filteredList.add(a));
        return filteredList;
    }

    /**
     * @return a list of moves without comments
     */
    public List<Move> getMovesWithoutComment() {
        List<Move> filteredList = new ArrayList<>();
        Stream<Move> stream = moves.stream();
        stream.filter(new Predicate<Move>() {
            public boolean test(Move move) {
                if (!(move.getWhitePly().getComment().isPresent())
                    && !(move.getBlackPly().getComment().isPresent())) {
                    return true;
                }
                return false;
            }
        }).forEach((a) -> filteredList.add(a));
        return filteredList;
    }

    /**
     * @return a list of moves with comments
     */
    public List<Move> getMovesWithComment() {
        List<Move> filteredList = new ArrayList<>();
        Stream<Move> stream = moves.stream();
        stream.filter((b) -> {
                return (b.getWhitePly().getComment().isPresent()
                    || b.getBlackPly().getComment().isPresent());
            }).forEach((a) -> {
                    filteredList.add(a);
                });
        return filteredList;
    }

    /**
     * @return a list of moves with a piece of this type
     * @param p the piece to match moves with
     */
    public List<Move> getMovesWithPiece(Piece p) {
        filteredInnerList = new ArrayList<>();
        filterPiece = p;
        Stream<Move> stream = moves.stream();
        stream.filter(new Coolio()).forEach((a) -> {
                filteredInnerList.add(a);
            });
        return filteredInnerList;
        // stream.forEach(new )
    }

    /**
     * Represents a predicate for determining piece equality of a move
     * @verson 1.0
     * @author mabdi3
     */
    public class Coolio implements Predicate<Move> {
        @Override
        public boolean test(Move move) {
            return (move.getWhitePly().getPiece().equals(filterPiece)
                   || move.getBlackPly().getPiece().equals(filterPiece));
        }
    }

}