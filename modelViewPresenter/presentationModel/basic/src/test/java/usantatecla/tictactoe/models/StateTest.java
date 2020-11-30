package usantatecla.tictactoe.models;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StateTest {

    // TDD-08
    @Test
    public void whenStateIsCreatedThenStateValueShouldBeInitial(){
        State state = new State();
        assertThat(state.getValueState(), is(StateValue.INITIAL));
    }

    // TDD-09
    @Test
    public void whenStateIsCreatedAndGoToTheNextThenStateValueShouldBeInGame(){
        State state = new State();
        state.next();
        assertThat(state.getValueState(), is(StateValue.IN_GAME));
    }
}