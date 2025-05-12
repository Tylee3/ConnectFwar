//Project 2
//By Tyler Hoffman
//CSCI 1913

import java.util.Random;

public class Deck{
    private Card[] cards;
    private int currentCardIndex;

    /**
     * This function is the constructor for a new deck of 52 cards.
     */
    public Deck(){
        cards = new Card[52];
        int index = 0;
        for(int suit = 1; suit <= 4; suit++){
            for(int rank = 1; rank <= 13; rank++){
                cards[index++] = new Card(rank, suit);
            }
        }

        currentCardIndex = 0;
        shuffle();
    }

    /**
     * Shuffles the deck of cards.
     */
    public void shuffle(){
        Random random = new Random();
        for(int i = cards.length - 1; i > 0; i--){
            int j = random.nextInt(i + 1);
            Card k = cards[i];
            cards[i] = cards[j];
            cards[j] = k;
        }

        currentCardIndex = 0;
    }

    /**
     * Draws the next card.
     * @return
     */
    public Card draw(){
        if(isEmpty()){
            return null;
        }

        return cards[currentCardIndex++];
    }

    /**
     * Returns the number of cards remaining.
     * @return
     */
    public int cardsRemaining(){
        return cards.length - currentCardIndex;
    }

    /**
     * Checks if the deck is empty.
     * @return
     */
    public boolean isEmpty(){
        return cardsRemaining() == 0;
    }
}