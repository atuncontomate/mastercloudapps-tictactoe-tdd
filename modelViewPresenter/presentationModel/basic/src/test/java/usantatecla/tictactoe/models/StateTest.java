package usantatecla.tictactoe.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class StateTest {

    private State state;

    @BeforeEach
    public void init(){
        this.state = new State();
    }

    // TDD-08
    @Test
    public void whenStateIsCreatedThenStateValueShouldBeInitial(){
        assertThat(state.getValueState(), is(StateValue.INITIAL));
    }

    // TDD-09
    @Test
    public void whenStateIsCreatedAndGoToTheNextThenStateValueShouldBeInGame(){
        state.next();
        assertThat(state.getValueState(), is(StateValue.IN_GAME));
    }
}
