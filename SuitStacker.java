//Project 2
//By Tyler Hoffman
//CSCI 1913

public class SuitStacker implements Player{

    /**
     * Determines the next move based on the card’s suit.
     */
    @Override
    public int nextMove(Card card, Board board){
        return card.getSuitNum() - 1;
    }
}