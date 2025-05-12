//Project 2
//By Tyler Hoffman
//CSCI 1913

import java.util.Scanner;

public class HumanPlayer implements Player{
    private Scanner scanner = new Scanner(System.in);

    /**
     * Prompts the human player for a move
     */
    @Override
    public int nextMove(Card card, Board board){
        System.out.println(card.toString());
        System.out.println(board.toString());
        int input = scanner.nextInt();
        return input;
    }

    /**
     * The main method allows a human player to test and play the ConnectFwar game.
     * @param args
     */
    public static void main(String[] args){
        HumanPlayer human = new HumanPlayer();

        int score = ConnectFwar.play(human);
        System.out.println("Game over! Your score is: " + score);
    }
}