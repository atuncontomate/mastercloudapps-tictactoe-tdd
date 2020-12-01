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

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class PlayControllerTest {

    @Mock
    private State state;

    @Mock
    private Game game;

    @InjectMocks
    private PlayController playController;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    // TDD-15
    @Test
    public void whenPutCoordinateAndIsTicTacToeThenStateShouldGoToTheNext(){
        Coordinate coordinate = new Coordinate();
        when(this.game.put(coordinate)).thenReturn(null);
        playController.put(coordinate);
        verify(this.state).next();
    }
}
