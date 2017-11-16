public class Game {

    private Player playerOne;
    private Player playerTwo;
    private static final String[] scoreWords = {"love", "fifteen", "thirty", "forty"};
    private static final String[] scoreTiedWords = {"deuce", "advantage", "won"};
    private int tiedScore = 0;
    private int absoluteTiedScore = 0;
    private static final int DEUCE = 0;
    private static final int ADVANTAGE = 1;
    private static final int FORTY_POINTS = 3;


    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        int playerOneScore = playerOne.getScore();
        int playerTwoScore = playerTwo.getScore();

        if (playerOneScore >= FORTY_POINTS && playerTwoScore >= FORTY_POINTS) {
            setTieBreakScore(playerOneScore, playerTwoScore);
            return getTieBreakScore();
        }
        return scoreWords[playerOneScore] + ", " + scoreWords[playerTwoScore];
    }

    private void setTieBreakScore(int playerOneScore, int playerTwoScore) {
        tiedScore = playerOneScore - playerTwoScore;
        absoluteTiedScore = Math.abs(tiedScore);
    }

    private String getTieBreakScore() {
        if (tiedScore == DEUCE) return scoreTiedWords[tiedScore];

        String nameOfPlayerAhead = getNameOfPlayerAhead();
        if (absoluteTiedScore == ADVANTAGE) return scoreTiedWords[absoluteTiedScore] + " " + nameOfPlayerAhead;
        else return nameOfPlayerAhead + " " + scoreTiedWords[absoluteTiedScore];
    }

    private String getNameOfPlayerAhead() {
        if (tiedScore > 0) return playerOne.getPlayerName();
        else return playerTwo.getPlayerName();
    }
}