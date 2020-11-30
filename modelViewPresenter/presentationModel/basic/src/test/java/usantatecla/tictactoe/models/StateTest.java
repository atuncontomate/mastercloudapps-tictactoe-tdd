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

    // TDD-10
    @Test
    public void whenStateIsCreatedAndGoToTheNextTwiceThenStateValueShouldBeResume(){
        state.next();
        state.next();
        assertThat(state.getValueState(), is(StateValue.RESUME));
    }

    // TDD-11
    @Test
    public void whenStateIsCreatedAndGoToTheNextThreeTimesThenStateValueShouldBeExit(){
        state.next();
        state.next();
        state.next();
        assertThat(state.getValueState(), is(StateValue.EXIT));
    }

    // TDD-12
    @Test
    public void whenStateIsCreatedAndGoToTheNextAndResetThenStateValueShouldBeInitial(){
        state.next();
        state.reset();
        assertThat(state.getValueState(), is(StateValue.INITIAL));
    }
}
