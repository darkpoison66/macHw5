import java.util.*;
public class Tester {
    public static void main(String[] args) {

        //Testting Constructors for Ply and Move
        System.out.println();
        System.out.println("Now Testing Constructors");
        boolean passedConstructors = true;
        System.out.println("Passed all Constructor testing");

        Piece a = new Pawn(Color.WHITE);
        Piece b = new Pawn(Color.BLACK);

        Square blackF = new Square("a7");
        Square blackT = new Square("a6");

        Square whiteF = new Square("a1");
        Square whiteT = new Square("a2");

        Optional<String> com = Optional.of("purple");
        Optional<String> comp = Optional.empty();

        Ply first = new Ply(new Bishop(Color.BLACK), whiteF, whiteT, comp);
        Ply second = new Ply(a, blackF, blackT, com);

        Ply third = new Ply(new Pawn(Color.WHITE), new Square("a2"), new Square("a3"), comp);
        Ply fourth = new Ply(new Queen(Color.BLACK), new Square("a6"), new Square("a5"), comp);

        Ply fifth = new Ply(new Knight(Color.WHITE), new Square("g1"), new Square("f3"), com);
        Ply sixth = new Ply(new Bishop(Color.BLACK), new Square("f8"), new Square("d6"), comp);

        Move numbaOne = new Move(first, second);
        Move numbaTwo = new Move(third, fourth);
        Move numbaTree = new Move(fifth, sixth);

        List<Move> list = new ArrayList<>();
        list.add(numbaOne);
        list.add(numbaTwo);
        list.add(numbaTree);

        ChessGame chess = new ChessGame(list);

        //Testing Ply Getters and Move Getters
        System.out.println();
        System.out.println("Now Testing Getters");
        boolean passedPly = true;
        boolean passedMove = true;
        try {
            Square one = first.getFrom();
            Square two = first.getTo();
            Square three = second.getFrom();
            Square four = second.getTo();
            Piece knight = fifth.getPiece();
            Piece shouldFail = fourth.getPiece();
        } catch (Exception e) {
            System.out.println("[WARNING] Supercatch caught an exception.");
            e.printStackTrace();
            passedPly = false;
        }

        Ply one = numbaOne.getWhitePly();
        Square from = one.getFrom();
        Square to = one.getTo();
        if (!(from.equals(new Square("a1"))) || (!(to.equals(new Square("a2"))))) {
            System.out.println("Move returned weird Plys");
            passedMove = false;
        }
        if (passedMove && passedPly) {
            System.out.println("Passed all getters tests");
        } else {
            System.out.print("failed one or more ggetters tests");
        }

        //Testing getMove()
        boolean passedGetMove = true;
        if (list.get(0) != numbaOne || list.get(1) != numbaTwo || list.get(2) != numbaTree) {
            System.out.println("Why are you getting weird stuff");
            passedGetMove = false;
        }
        if (passedGetMove) {
            System.out.println("Passed all getMove() tests");
        } else {
            System.out.print("failed one or more getMove() tests");
        }

        //Testing getMovesWithComment()
        System.out.println();
        System.out.println("Now Testing getMovesWithComment()");
        boolean passedGetMoveWithComment = true;
        List<Move> test = new ArrayList<>();
        test.add(numbaOne);
        test.add(numbaTree);
        List<Move> comments = new ArrayList<>();
        comments = chess.getMovesWithComment();
        if (!(test.containsAll(comments))) {
            System.out.println("go fix ur method");
            passedGetMoveWithComment = false;
        }
        if(passedGetMoveWithComment) {
            System.out.println("Passed all getMoveWithComment() tests");
        } else {
            System.out.print("failed one or more getMoveWithComment() tests");
        }

        //Testing getMovesWithoutComment()
        System.out.println();
        System.out.println("Now Testing getMovesWithoutComment()");
        boolean passedGetMovesWithoutComment = true;
        test = new ArrayList<>();
        test.add(numbaTwo);
        List<Move> withoutComments = new ArrayList<>();
        withoutComments = chess.getMovesWithoutComment();
        if(!(test.containsAll(withoutComments))) {
            System.out.println("go fix ur method");
            passedGetMovesWithoutComment = false;
        }
        if (passedGetMovesWithoutComment) {
            System.out.println("Passed all getMoveWithoutComment() tests");
        } else {
            System.out.print("failed one or more getMoveWithoutComment() tests");
        }



        //Testing getMovesWithPiece()
        System.out.println();
        System.out.println("Now Testing getMovesWithPiece()");
        boolean passedGetMoveWithPiece = true;
        /* Pawn */
        List<Move> movesWithPiece = chess.getMovesWithPiece(new Pawn(Color.WHITE));
        test = new ArrayList<>();
        test.add(numbaOne);
        test.add(numbaTwo);
        if(!(test.containsAll(movesWithPiece))) {
            System.out.println("maybe ur equals method is broken");
            passedGetMoveWithPiece = false;
        }
        /* Bishop */
        test = new ArrayList<>();
        movesWithPiece = chess.getMovesWithPiece(new Bishop(Color.BLACK));
        test.add(numbaOne);
        test.add(numbaTree);
        if(!(test.containsAll(movesWithPiece))) {
            System.out.println("maybe ur equals method is broken and your father left you");
            passedGetMoveWithPiece = false;
        }
        if (passedGetMoveWithPiece) {
            System.out.println("Passed all getMoveWithPiece() tests");
        } else {
            System.out.print("Failed one or more getMoveWithPiece() tests");
        }

        //Testing filter(Predicate<Move> filter)
        System.out.println();
        System.out.println("Now Testing filter()");
        test = new ArrayList<>();
        boolean passedFilter = true;
        test.add(numbaTwo);
        test.add(numbaTree);
        List<Move> froms = new ArrayList<>();
        froms = chess.filter((z) -> {
            if (z.getWhitePly().equals(new Square("a1")) || z.getWhitePly().equals(new Square("g1"))) {
                return true;
            } else {
                return false;
            }
        });
        if (!(test.containsAll(froms))) {
            System.out.println("you suck");
            passedFilter = false;
        }
        if (passedFilter) {
            System.out.println("Passed all filter() tests");
        } else {
            System.out.print("Failed one or more filter() tests");
        }

        int score = 0;
        score = passedConstructors ? (score = score + 21) : (score = score);
        score = passedPly ? (score = score + 5) : (score = score);
        score = passedMove ? (score = score + 4) : (score = score);
        score = passedGetMove ? (score = score + 10) : (score = score);
        score = passedGetMoveWithComment ? (score = score + 15) : (score = score);
        score = passedGetMovesWithoutComment ? (score = score + 15) : (score = score);
        score = passedGetMoveWithPiece ? (score = score + 15) : (score = score);
        score = passedFilter ? (score = score + 15) : (score = score);

        System.out.printf("\nYou scored a %d/100. Nice work\n", score);





    }
}