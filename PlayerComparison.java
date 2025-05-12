//Project 2
//By Tyler Hoffman
//CSCI 1913

public class PlayerComparison{
    /**
     * The main method that runs the performance comparison for each AI player.
     * @param args
     */
    public static void main(String args[]){
        int numGames = 10000;

        double randomTotal = 0;
        double basicTotal = 0;
        double rankTotal = 0;
        double suitTotal = 0;

        Player randomPlayer = new RandomPlayer();
        Player basicPlayer = new BasicPlayer();
        Player rankPlayer = new RankRunner();
        Player suitStacker = new SuitStacker();

        for(int i = 0; i < numGames; i++){
            randomTotal += ConnectFwar.play(randomPlayer);
        }

        for(int i = 0; i < numGames; i++){
            basicTotal += ConnectFwar.play(basicPlayer);
        }

        for(int i = 0; i < numGames; i++){
            rankTotal += ConnectFwar.play(rankPlayer);
        }

        for(int i = 0; i < numGames; i++){
            suitTotal += ConnectFwar.play(suitStacker);
        }

        double randomAverage = randomTotal / numGames;
        double basicAverage = basicTotal / numGames;
        double rankAverage = rankTotal / numGames;
        double suitAverage = suitTotal / numGames;

        System.out.println("Average scores over " + numGames + " games");
        System.out.println("Random: " + randomAverage);
        System.out.println("Basic: " + basicAverage);
        System.out.println("RankRunner: " + rankAverage);
        System.out.println("SuitStacker: " + suitAverage);
    }
}