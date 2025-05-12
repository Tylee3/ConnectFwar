//Project 2
//By Tyler Hoffman
//CSCI 1913

public interface Player{

    /**
     * Determines the next move for the player by choosing a column for the given card on the current board.
     * @param card
     * @param board
     * @return
     */
    public int nextMove(Card card, Board board);

}
