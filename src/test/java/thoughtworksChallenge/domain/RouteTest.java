package thoughtworksChallenge.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import thoughtworksChallenge.exceptions.InvalidInstructionException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class RouteTest {

    Rover rover;
    Plateau plateau;
    Route route;
    String instructions;
    String emptyInstructions;

    @Before
    public void before() {
        this.rover = new Rover(1, 2, 'N');
        this.plateau = new Plateau(5,5);
        this.instructions = "LMMRMMRMLM";
        this.route = new Route(this.instructions, this.rover);
        this.emptyInstructions = "";
    }

    @After
    public void tearDown() {
        this.rover = null;
        this.plateau = null;
        this.route = null;
        this.emptyInstructions = null;
        this.instructions = null;
    }

    @Test
    public void routeShouldInitializeCorrectly() {
        String instruct = "LMMRMMRMLM";
        Route r = new Route(instruct, rover);
        assertNotNull(r);
    }

    @Test
    public void ifInstructionsAreEmptyRoverShouldNotMove() throws InvalidInstructionException {

        route.processRoute(emptyInstructions);

        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(),2);
        assertEquals(rover.getCardinalPoint(), 'N');
    }

    @Test
    public void ifInstructionsAreCorrectRoverShouldMove() throws InvalidInstructionException {
        instructions = "LMLMLMLMM";
        route.processRoute(instructions);
        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(),3);
        assertEquals(rover.getCardinalPoint(), 'N');

        rover.setX(3);
        rover.setY(3);
        rover.setCardinalPoint('E');

        instructions = "MMRMMRMRRM";
        route.processRoute(instructions);
        assertEquals(rover.getX(), 5);
        assertEquals(rover.getY(),1);
        assertEquals(rover.getCardinalPoint(), 'E');
    }

    @Test (expected = InvalidInstructionException.class)
    public void ifInstructionsAreWrongRoverShouldNotMove() throws InvalidInstructionException {
        instructions = "HYGJBOJN";
        route.processRoute(instructions);
    }
}
