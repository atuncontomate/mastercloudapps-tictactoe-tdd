package usantatecla.tictactoe.models;

public class State {

    private StateValue stateValue;

    public State(){
        this.stateValue = StateValue.INITIAL;
    }

    public StateValue getValueState() {
        return this.stateValue;
    }

    public void next() {
        this.stateValue = StateValue.IN_GAME;
    }
}
