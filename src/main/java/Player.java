public class Player {
    private String playerName;
    private int score;

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
}
