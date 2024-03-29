package net.sourceforge.jibs.backgammon;

import net.sourceforge.jibs.server.Player;

import java.util.StringTokenizer;

/**
 *
 */
public class MoveBackgammon {
    private BackgammonBoard bgBoard;

    public MoveBackgammon(BackgammonBoard bgBoard) {
        this.bgBoard = bgBoard;
    }

    public boolean checkMove(Player player, String args, int canMove) {
        int turn = bgBoard.getTurn();
        boolean retCode = false;

        switch (turn) {
        case 0:
            retCode = checkMoveO(player, args, canMove);

            break;

        case -1:
            retCode = checkMoveX(player, args, canMove);

            break;
        }

        return true;
    }

    private boolean checkMoveX(Player player, String args, int canMove) {
        // TODO Auto-generated method stub
        return false;
    }

    private boolean checkMoveO(Player player, String args, int canMove) {
        // TODO Auto-generated method stub
        return false;
    }

    public BackgammonBoard placeMoveO(String mv) {
        BackgammonBoard setBoard = new BackgammonBoard(bgBoard);

        StringTokenizer stoken = new StringTokenizer(mv, " -");
        int bOnce = 0;
        int source = -1;
        int destination = -1;

        while (stoken.hasMoreTokens()) {
            String s = stoken.nextToken();

            switch (bOnce) {
            case 0:

                if (s.equalsIgnoreCase("bar") || s.equalsIgnoreCase("b")) {
                    source = 25;
                } else {
                    source = Integer.parseInt(s);
                }

                bOnce++;

                break;

            case 1:

                if (s.equalsIgnoreCase("off") || s.equalsIgnoreCase("o")) {
                    destination = 0;
                } else {
                    destination = Integer.parseInt(s);
                }

                bOnce = 0;

                Move move = null;

                move = new Move(source, destination);

                BackgammonBoard newBoard = setBoard.placeMoveO(move);

                setBoard = newBoard;

                break;
            }
        } // while

        return setBoard;
    }

    public BackgammonBoard placeMoveX(String mv) {
        BackgammonBoard setBoard = new BackgammonBoard(bgBoard);

        StringTokenizer stoken = new StringTokenizer(mv, " -");
        int bOnce = 0;
        int source = -1;
        int destination = -1;

        while (stoken.hasMoreTokens()) {
            String s = stoken.nextToken();

            switch (bOnce) {
            case 0:

                if (s.equalsIgnoreCase("bar") || s.equalsIgnoreCase("b")) {
                    source = 0;
                } else {
                    source = Integer.parseInt(s);
                }

                bOnce++;

                break;

            case 1:

                if (s.equalsIgnoreCase("off") || s.equalsIgnoreCase("o")) {
                    destination = 0;
                } else {
                    destination = Integer.parseInt(s);
                }

                bOnce = 0;

                Move move = null;

                move = new Move(source, destination);

                BackgammonBoard newBoard = setBoard.placeMoveX(move);

                setBoard = newBoard;

                break;
            }
        } // while

        return setBoard;
    }
}
