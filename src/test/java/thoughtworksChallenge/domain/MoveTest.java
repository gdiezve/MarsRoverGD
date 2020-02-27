package thoughtworksChallenge.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import thoughtworksChallenge.exceptions.InvalidInstructionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class MoveTest {

    private RoverMove move;
    private Rover rover;

    @Before
    public void before() {
        this.move = new RoverMove();
        this.rover = new Rover(1, 2, 'N');
    }

    @After
    public void tearDown() {
        this.rover = null;
        this.move = null;
    }

    @Test
    public void initRoverController() {
        assertNotNull(this.move);
    }

    @Test
    public void ifTheCommandIsRRoverShouldBeTurnRight() throws InvalidInstructionException {
        this.rover = this.move.readCommand('R', this.rover);

        assertEquals(rover.getCardinalPoint(), 'E');
    }

    @Test
    public void ifTheCommandIsLRoverShouldBeTurnLeft() throws InvalidInstructionException {

        this.rover = this.move.readCommand('L', this.rover);

        assertEquals(rover.getCardinalPoint(), 'W');
    }

    @Test
    public void ifTheCommandIsMRoverShouldMoveOnePoint() throws InvalidInstructionException {
        this.rover = this.move.readCommand('M', this.rover);

        assertEquals(rover.getY(), 3);
    }

    @Test(expected = InvalidInstructionException.class)
    public void ifTheCommandIsWrongRoverShouldReturnException() throws InvalidInstructionException {
        this.rover = this.move.readCommand('G', this.rover);
    }

}
