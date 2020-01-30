package thoughtworksChallenge.controllers;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import thoughtworksChallenge.domain.Rover;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class RoverControllerTest {

    private RoverController roverController;
    private Rover rover;

    @Before
    public void before() {
        this.roverController = new RoverController();
        this.rover = new Rover(1, 2, 'N');
    }

    @After
    public void tearDown() {
        this.rover = null;
        this.roverController = null;
    }

    @Test
    public void initRoverController() {
        assertNotNull(this.roverController);
    }

    @Test
    public void readRightCommand() throws Exception {
        this.rover = this.roverController.readCommand('R', this.rover);

        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(),2);
        assertEquals(rover.getCardinalPoint(), 'E');

        this.rover = this.roverController.readCommand('M', this.rover);

        assertEquals(rover.getX(), 2);
        assertEquals(rover.getY(),2);
        assertEquals(rover.getCardinalPoint(), 'E');

        this.rover = this.roverController.readCommand('L', this.rover);

        assertEquals(rover.getX(), 2);
        assertEquals(rover.getY(),2);
        assertEquals(rover.getCardinalPoint(), 'N');

        this.rover = this.roverController.readCommand('M', this.rover);

        assertEquals(rover.getX(), 2);
        assertEquals(rover.getY(),3);
        assertEquals(rover.getCardinalPoint(), 'N');
    }

    @Test
    public void ifTheCommandIsRRoverShouldBeTurnRight() throws Exception {
        this.rover = this.roverController.readCommand('R', this.rover);

        assertEquals(rover.getCardinalPoint(), 'E');
    }

    @Test
    public void ifTheCommandIsLRoverShouldBeTurnLeft() {

    }

    @Test
    public void readWrongCommand() throws Exception {
        try {
            this.rover = this.roverController.readCommand('H', this.rover);
        } catch (Exception e) {
            System.out.println(e);
        }
    }



}
