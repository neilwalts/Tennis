public class Game {

    private Player playerOne;
    private Player playerTwo;
    private static final int ADVANTAGE = 1;
    private int playerOneScore;
    private int playerTwoScore;


    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
    }

    public String getScore() {
        playerOneScore = playerOne.getScore();
        playerTwoScore = playerTwo.getScore();

        if (playerOne.hasPlayerReachedFortyPoints() && playerTwo.hasPlayerReachedFortyPoints()) {
            return (playerOneScore == playerTwoScore) ? "deuce" : getTieBreakStatus();
        }
        return playerOne.getScoreWord() + ", " + playerTwo.getScoreWord();
    }

    private String getTieBreakStatus() {
        String nameOfPlayerAhead = getNameOfPlayerAhead();
        return (Math.abs(playerOneScore - playerTwoScore) == ADVANTAGE) ?
                ("advantage " + nameOfPlayerAhead) : (nameOfPlayerAhead + " won");
    }

    private String getNameOfPlayerAhead() {
        return (playerOneScore > playerTwoScore) ? playerOne.getPlayerName() : playerTwo.getPlayerName();
    }
}