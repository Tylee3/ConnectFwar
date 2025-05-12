//Project 2
//By Tyler Hoffman
//CSCI 1913

import java.util.Random;

public class RandomPlayer implements Player{
    private Random random = new Random();

    /**
     * Returns a randomly chosen column index between 0 and 3.
     */
    @Override
    public int nextMove(Card card, Board board){
        return random.nextInt(4);
    }
}