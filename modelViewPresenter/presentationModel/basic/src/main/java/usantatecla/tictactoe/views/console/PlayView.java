package usantatecla.tictactoe.views.console;

import usantatecla.tictactoe.controllers.PlayController;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.views.Message;
import usantatecla.tictactoe.types.Error;

class PlayView {

    private PlayController playController;

    PlayView(PlayController playController) {
        this.playController = playController;
    }

    void interact() {
        this.interact(this.playController);
    }

    void interact(PlayController playController) {
        do {
            if (!playController.isBoardComplete()) {
                this.put(playController);
            } else {
                this.move();
            }
            new GameView(playController).write();
        } while (!playController.isTicTacToe());
        new TokenView(playController.getToken()).write();
        Message.PLAYER_WIN.writeln();
    }

    private void put() {
        boolean isUser = this.playController.isUser();
        Coordinate coordinate;
        Error error;
        do {
            if (isUser) {
                coordinate = new CoordinateView().read(Message.COORDINATE_TO_PUT.toString());
            } else {
                coordinate = createRandomCoordinate();
            }
            error = this.playController.put(coordinate);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    private void put(PlayController playController){
        boolean isUser = playController.isUser();
        Coordinate coordinate;
        Error error;
        do {
            if (isUser) {
                coordinate = new CoordinateView().read(Message.COORDINATE_TO_PUT.toString());
            } else {
                coordinate = createRandomCoordinate();
            }
            error = playController.put(coordinate);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    private void move() {
        boolean isUser = this.playController.isUser();
        Coordinate origin;
        Coordinate target;
        Error error;
        do {
            if (isUser) {
                origin = new CoordinateView().read(Message.COORDINATE_TO_REMOVE.toString());
                target = new CoordinateView().read(Message.COORDINATE_TO_MOVE.toString());
            } else {
                origin = createRandomCoordinate();
                target = createRandomCoordinate();
            }
            error = this.playController.move(origin, target);
            if (isUser) {
                new ErrorView(error).writeln();
            }
        } while (!error.isNull());
    }

    Coordinate createRandomCoordinate() {
        Coordinate coordinate = new Coordinate();
        coordinate.random();
        return coordinate;
    }

}
