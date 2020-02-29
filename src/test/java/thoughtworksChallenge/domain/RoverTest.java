package thoughtworksChallenge.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import thoughtworksChallenge.exceptions.InvalidInstructionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class RoverTest {

    private Rover rover;

    @Before
    public void before() {
        this.rover = new Rover(1, 2, 'N');
    }

    @After
    public void tearDown() {
        this.rover = null;
    }

    @Test
    public void createRover() throws Exception {
        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(), 2);
        assertEquals(rover.getCardinalPoint(), 'N');
    }

    @Test
    public void setNewRoverSize() throws Exception {
        this.rover.setX(3);
        this.rover.setY(1);

        assertEquals(rover.getX(), 3);
        assertEquals(rover.getY(), 1);
    }

    @Test
    public void roverMoves() {
        this.rover.move();
        assertEquals(3, this.rover.getY());
        assertEquals(1, this.rover.getX());

        this.rover.turnRight();
        this.rover.move();
        assertEquals(3, this.rover.getY());
        assertEquals(2, this.rover.getX());

        this.rover.turnRight();
        this.rover.move();
        assertEquals(2, this.rover.getY());
        assertEquals(2, this.rover.getX());

        this.rover.turnRight();
        this.rover.move();
        assertEquals(2, this.rover.getY());
        assertEquals(1, this.rover.getX());
    }

    @Test
    public void roverTurnsRight() {
        this.rover.turnRight();
        assertEquals('E', this.rover.getCardinalPoint());

        this.rover.turnRight();
        assertEquals('S', this.rover.getCardinalPoint());

        this.rover.turnRight();
        assertEquals('W', this.rover.getCardinalPoint());

        this.rover.turnRight();
        assertEquals('N', this.rover.getCardinalPoint());
    }

    @Test
    public void roverTurnsLeft() {
        this.rover.turnLeft();
        assertEquals('W', this.rover.getCardinalPoint());

        this.rover.turnLeft();
        assertEquals('S', this.rover.getCardinalPoint());

        this.rover.turnLeft();
        assertEquals('E', this.rover.getCardinalPoint());

        this.rover.turnLeft();
        assertEquals('N', this.rover.getCardinalPoint());
    }
}
