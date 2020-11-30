package usantatecla.tictactoe.views.console;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.junit.jupiter.MockitoExtension;
import usantatecla.tictactoe.controllers.ResumeController;
import usantatecla.tictactoe.models.Game;
import usantatecla.utils.Console;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.MockitoAnnotations.openMocks;

@ExtendWith(MockitoExtension.class)
public class ResumeViewTest {

    @Mock
    private ResumeController resumeController;

    @Mock
    private Console console;

    @InjectMocks
    private ResumeView resumeView;

    @BeforeEach
    void before() {
        openMocks(this);
    }

    @Test
    void testGivenNewGameIsFalseWhenInteractThenIsFalse() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('n');
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.resumeView.interact(), is(false));
        }
    }

    @Test
    void testGivenNewGameIsTrueWhenInteractThenIsTrue() {
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('y');
            this.resumeController.resume();
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.resumeView.interact(), is(true));
        }
    }

    // TDD-06
    @Test
    void testGivenNewGameIsFalseWhenInteractWithPassedControllerThenIsFalse() {
        ResumeController resumeController = mock(ResumeController.class);
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('n');
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.resumeView.interact(resumeController), is(false));
        }
    }

    // TDD-07
    @Test
    void testGivenNewGameIsTrueWhenInteractWithPassedControllerThenIsTrue() {
        ResumeController resumeController = mock(ResumeController.class);
        try (MockedStatic console = mockStatic(Console.class)) {
            when(this.console.readChar(anyString())).thenReturn('y');
            resumeController.resume();
            console.when(Console::getInstance).thenReturn(this.console);
            assertThat(this.resumeView.interact(resumeController), is(true));
        }
    }
}
