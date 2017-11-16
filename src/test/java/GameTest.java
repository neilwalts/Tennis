import org.junit.Before;
import org.junit.Test;

import java.util.stream.IntStream;

import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

//https://technologyconversations.com/2014/04/23/java-tutorial-through-katas-tennis-game-easy/

public class GameTest {
    private Player victor;
    private Player sarah;
    private Game game;

    @Before
    public void beforeTestTennis() {
        victor = new Player("Victor");
        sarah = new Player("Sarah");
        game = new Game(victor, sarah);
    }

    @Test
    public void loveShouldBeDescriptionForScore0() {
        Game game = new Game(victor, sarah);
        assertThat(game, hasProperty("score", is("love, love")));
    }

    @Test
    public void fifteenShouldBeDescriptionForScore1() {
        sarah.winBall();
        assertThat(game, hasProperty("score", is("love, fifteen")));
    }

    @Test
    public void thirtyShouldBeDescriptionForScore2() {
        victor.winBall();
        victor.winBall();
        sarah.winBall();
        assertThat(game, hasProperty("score", is("thirty, fifteen")));
    }

    @Test
    public void fortyShouldBeDescriptionForScore3() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> victor.winBall());
        assertThat(game, hasProperty("score", is("forty, love")));
    }

    @Test
    public void advantageShouldBeDescriptionWhenLeastThreePointsHaveBeenScoredByEachSideAndPlayerHasOnePointMoreThanHisOpponent() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> victor.winBall());
        IntStream.rangeClosed(1, 4).forEach((Integer) -> sarah.winBall());
        assertThat(game, hasProperty("score", is("advantage Sarah")));
    }

    @Test
    public void deuceShouldBeDescriptionWhenAtLeastThreePointsHaveBeenScoredByEachPlayerAndTheScoresAreEqual() {
        IntStream.rangeClosed(1, 3).forEach((Integer) -> victor.winBall());
        IntStream.rangeClosed(1, 3).forEach((Integer) ->  sarah.winBall());
        assertThat(game, hasProperty("score", is("deuce")));
        victor.winBall();
        assertThat(game, hasProperty("score", is(not("deuce"))));
        sarah.winBall();
        assertThat(game, hasProperty("score", is("deuce")));
    }

    @Test
    public void gameShouldBeWonByTheFirstPlayerToHaveWonAtLeastFourPointsInTotalAndWithAtLeastTwoPointsMoreThanTheOpponent() {
        IntStream.rangeClosed(1, 4).forEach((Integer) -> victor.winBall());
        IntStream.rangeClosed(1, 3).forEach((Integer) -> sarah.winBall());
        assertThat(game, hasProperty("score", is(not("Victor won"))));
        assertThat(game, hasProperty("score", is(not("Sarah won"))));
        victor.winBall();
        assertThat(game, hasProperty("score", is("Victor won")));
    }

}
