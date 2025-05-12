//Project 2
//By Tyler Hoffman
//CSCI 1913

public class Card{
    private final int rank;
    private final int suit;

    /**
     * This function is the constructor for the card. 
     * @param rank
     * @param suit
     */
    public Card(int rank, int suit){
        if(rank < 1 || rank > 13 || suit < 1 || suit > 4){
            System.out.println("Invalid Card");
            this.rank = 1;
            this.suit = 1;
        } else{
            this.rank = rank;
            this.suit = suit;
        }
    }

    public int getRankNum(){
        return rank;
    }

    public int getSuitNum(){
        return suit;
    }

    /**
     * Returns the name of the card's rank.
     * @return
     */
    public String getRankName(){
        String[] rankNames = {
            "",
            "Ace",
            "Two",
            "Three",
            "Four",
            "Five",
            "Six",
            "Seven",
            "Eight",
            "Nine",
            "Ten",
            "Jack", 
            "Queen",
            "King"
        };

        return rankNames[rank];
    }

    /**
     * Returns the name of the suit.
     * @return
     */
    public String getSuitName(){
        String[] suitNames = {
            "",
            "Spades",
            "Hearts",
            "Clubs",
            "Diamonds",
        };

        return suitNames[suit];
    }

    /**
     * returns a string description of this card.
     */
    @Override
    public String toString(){
        return getRankName() + " of " + getSuitName(); 
    }
    
    /**
     * Compares this card to the specified object for equality. Cards are equal if they have the same rank and suit.
     */
    @Override
    public boolean equals(Object obj){
        if (this == obj){
            return true;
        } if(!(obj instanceof Card)){
            return false;
        }

        Card other = (Card) obj;
        return this.rank == other.rank && this.suit == other.suit;
    }

    public String toVeryFancyString() {
        // we're getting into some deep magic with this one.
        // Don't be too worried if it doesn't work on your computer.

        
        // user getSuitNum and getRankNum so we don't assume any specific private variable name.
        char letter_part_one = '\uD83C';
        char letter_part_two = (char) ('\uDCA0' + getRankNum());
        if (getSuitNum() == 2) {
            letter_part_two += 16;
        } else if (getSuitNum() == 4) {
            letter_part_two += 32;
        } else if (getSuitNum() == 3) {
            letter_part_two += 48;
        }
        if (getRankNum() >=12) {
            letter_part_two++; // skip "Knight".
        }
        
        String retval;
        if (getSuitNum()%2 == 1) {
            // black card
            retval = "\u001B[30m\u001B[47m";
        } else {
            // red card
            retval = "\u001B[31m\u001B[47m";
        }

        return retval + letter_part_one + letter_part_two + " \u001B[0m";
    }
}