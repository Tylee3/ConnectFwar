public class BasicPlayer implements Player{

    /**
     * Determines the next move by checking each column in order and returning the first column where the card can be legally played.
     */
    @Override
    public int nextMove(Card card, Board board){
        for(int col = 0; col < 4; col++){
            if(board.canPlay(card, col)){
                return col;
            }
        }

        return -1;
    }
}
