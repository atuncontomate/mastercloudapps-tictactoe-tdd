package usantatecla.tictactoe.controllers;

import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

public class ResumeController extends Controller {

  private State state;

  public ResumeController(Game game) {
    super(game);
  }

  public ResumeController(Game game, State state) {
    super(game);
    this.state = state;
  }

  public void resume() {
    this.game.reset();
    this.state.reset();
  }

}
