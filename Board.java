//Project 2
//By Tyler Hoffman
//CSCI 1913

public class Board{
    private Card[][] cards;

    public Board(){
        this.cards = new Card[4][4];
    }

    /**
     * Gets the top card in the specified column.
     * @param column
     * @return
     */
    public Card getTopCard(int column){
        if(column < 0 || column >= 4){
            return null;
        }

        for(int row = 3; row >= 0; row--){
            if(cards[column][row] != null){
                return cards[column][row];
            }
        }

        return null;
    }

    /**
     * Gets the card located at the specified column and row.
     * @param col
     * @param row
     * @return
     */
    public Card getCard(int col, int row){
        if(col < 0 || col >= 4 || row < 0 || row >= 4){
            return null;
        }

        return cards[col][row];
    }

    /**
     * Determines whether a card can be legally played in the given column.
     * @param c
     * @param column
     * @return
     */
    public boolean canPlay(Card c, int column){
        if(column < 0 || column >= 4){
            return false;
        }

        for(int row = 0; row < 4; row++){
            if(cards[column][row] == null){
                break;
            }
            if(row == 3){
                return false;
            }
        }

        Card top = getTopCard(column);
        if(top == null){
            return true;
        }

        if(c.getRankNum() == 1) {
            return top.getRankNum() == 1;
        } else {
            return c.getRankNum() >= top.getRankNum();
        }
    }

    /**
     * Plays the specified card into the given column on the board.
     * @param c
     * @param column
     */
    public void play(Card c, int column){
        if(column < 0 || column >= 4){
            return;
        }
        
        for(int row = 0; row < 4; row++){
            if(cards[column][row] == null){
                cards[column][row] = c;
                return;
            }
        }
    }

    /**
     * Determines if the board is in a win state. The board is in a win state if their is a connected sequence of four cards
     * either horizontally, vertically, or diagonally.
     * @return
     */
    public boolean isWinState(){
        return checkRows() || checkColumns() || checkDiagonals();
    }

    /**
     * From isWinState, checks each row of the board for a connected sequence of four cards.
     * @return
     */
    private boolean checkRows(){
        for(int row = 0; row < 4; row++){
            boolean filled = true;
            for(int col = 0; col < 4; col++){
                if(cards[col][row] == null){
                    filled = false;
                    break;
                }
            }

            if(filled && isConnectedSequence(getRow(row))){
                return true;
            }
        }

        return false;
    }

    /**
     * From isWinState, checks each column of the board for a connected sequence of four cards.
     * @return
     */
    private boolean checkColumns(){
        for(int col = 0; col < 4; col++){
            boolean filled = true;
            for(int row = 0; row < 4; row++){
                if(cards[col][row] == null){
                    filled = false;
                    break;
                }
            }

            if(filled && isConnectedSequence(getColumn(col))){
                return true;
            }
        }

        return false;
    }

    /**
     * From isWinState, checks both diagonals of the board for a connected sequence of four cards.
     * @return
     */
    private boolean checkDiagonals(){
        Card[] main = new Card[4];
        for(int i = 0; i < 4; i++){
            main[i] = cards[i][i];
        }

        if(allNotNull(main) && isConnectedSequence(main)){
            return true;
        }

        Card[] notMain = new Card[4];
        for(int i = 0; i < 4; i++){
            notMain[i] = cards[i][3 - i];
        }

        if(allNotNull(notMain) && isConnectedSequence(notMain)){
            return true;
        }

        return false;
    }

    /**
     * Gets a complete row from the board as an array.
     * @param row
     * @return
     */
    private Card[] getRow(int row){
        Card[] result = new Card[4];
        for(int col = 0; col < 4; col++){
            result[col] = cards[col][row];
        }

        return result;
    }

    /**
     * Gets a complete column from the board as an array.
     * @param col
     * @return
     */
    private Card[] getColumn(int col){
        Card[] result = new Card[4];
        for(int row = 0; row < 4; row++){
            result[row] = cards[col][row];
        }

        return result;
    }

    /**
     * Checks whether all elements in the array of cards are non-null.
     * @param array
     * @return
     */
    private boolean allNotNull(Card[] array){
        for(Card c : array){
            if(c == null){
                return false;
            }
        }

        return true;
    }

    /**
     * Determines if a given sequence of cards is connected.
     * @param sequence
     * @return
     */
    private boolean isConnectedSequence(Card[] sequence){
        for(int i = 0; i < sequence.length - 1; i++){
            if(!isConnected(sequence[i], sequence[i+1])){
                return false;
            }
        }

        return true;
    }

    /**
     * Checks if two cards are connected.
     * @param c1
     * @param c2
     * @return
     */
    private boolean isConnected(Card c1, Card c2){
        if(c1 == null || c2 == null){
            return false;
        }

        if(c1.getSuitName().equals(c2.getSuitName())){
            return true;
        }
        if(c1.getRankNum() == c2.getRankNum()){
            return true;
        }
        if(Math.abs(c1.getRankNum() - c2.getRankNum()) == 1){
            return true;
        }
        return false;
    }

    /**
     * Returns a string representation of the board.
     */
    @Override
    public String toString(){
        StringBuilder builder = new StringBuilder();
        String horizontalLine = "-------------\n";

        builder.append(horizontalLine);
        for(int row = 3; row >= 0; row--){
            builder.append("|");
            for(int col = 0; col < 4; col++){
                Card card = cards[col][row];
                String cell;
                if(card != null){
                    cell = card.toVeryFancyString();
                } else{
                    cell = "  ";
                }

                builder.append(cell);
                builder.append("|");
            }

            builder.append("\n");
            builder.append(horizontalLine);

        }
        return builder.toString();
    }
}