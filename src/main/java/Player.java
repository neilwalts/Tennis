public class Player {
    private String playerName;
    private int score;
    private static final String[] scoreWords = {"love", "fifteen", "thirty", "forty"};
    private static final int FORTY_POINTS = 3;

    public Player(String playerName) {
        this.playerName = playerName;
        score = 0;
    }

    public void winBall() {
        score++;
    }

    public int getScore() {
        return score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public String getScoreWord() {
        return scoreWords[score];
    }

    public boolean hasPlayerReachedFortyPoints() {
        return score >= FORTY_POINTS;
    }
}
