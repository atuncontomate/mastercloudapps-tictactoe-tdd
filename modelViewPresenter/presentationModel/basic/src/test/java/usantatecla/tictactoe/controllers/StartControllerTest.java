package usantatecla.tictactoe.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.models.Game;
import usantatecla.tictactoe.models.State;

import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class StartControllerTest {

    @Mock
    private State state;

    @Mock
    private Game game;

    @InjectMocks
    private StartController startController;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    // TDD-13
    @Test
    public void whenSetUsersThenStateShouldGoToTheNext(){
        startController.setUsers(2);
        verify(this.state).next();
    }
}
