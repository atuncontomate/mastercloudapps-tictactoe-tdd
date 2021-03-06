package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Coordinate;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;
import usantatecla.tictactoe.types.Error;

import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest {

    private Coordinate coordinate;

    @Mock
    private State state;

    @Mock
    private Game game;

    @InjectMocks
    private PlayController playController;

    @BeforeEach
    void before() {
        coordinate = new Coordinate();
        openMocks(this);
    }

    // TDD-15
    @Test
    public void whenPutCoordinateAndIsTicTacToeThenStateShouldGoToTheNext(){
        when(this.game.put(coordinate)).thenReturn(Error.NULL);
        when(this.game.isTicTacToe()).thenReturn(true);
        playController.put(coordinate);
        verify(this.state).next();
    }

    // TDD-16
    @Test
    public void whenPutCoordinateAndIsNotTicTacToeThenStateShouldStay(){
        when(this.game.put(coordinate)).thenReturn(Error.NULL);
        playController.put(coordinate);
        verify(this.state, never()).next();
    }

    // TDD-17
    @Test
    public void whenMoveCoordinateAndIsTicTacToeThenStateShouldGoToTheNext(){
        when(this.game.move(coordinate, coordinate)).thenReturn(Error.NULL);
        when(this.game.isTicTacToe()).thenReturn(true);
        playController.move(coordinate, coordinate);
        verify(this.state).next();
    }

    // TDD-18
    @Test
    public void whenMoveCoordinateAndIsNotTicTacToeThenStateShouldStay(){
        when(this.game.move(coordinate, coordinate)).thenReturn(Error.NULL);
        playController.move(coordinate, coordinate);
        verify(this.state, never()).next();
    }
}
