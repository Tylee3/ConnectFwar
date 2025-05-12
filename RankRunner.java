//Project 2
//By Tyler Hoffman
//CSCI 1913

public class RankRunner implements Player{

    /**
     * Determines the next move for the RankRunner player based solely on the card's rank.
     */
    @Override
    public int nextMove(Card card, Board board){
        return (card.getRankNum() - 1) % 4;
    }
}