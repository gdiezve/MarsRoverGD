package thoughtworksChallenge.services;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import thoughtworksChallenge.domain.Rover;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(JUnit4.class)
public class MarsRoverServiceTest {

    private MarsRoverService marsRoverService;
    private Rover rover;
    private String emptyInstructions;
    private String instructions;

    @Before
    public void before() {
        this.marsRoverService = new MarsRoverService();
        this.rover = new Rover(1,2,'N');
        this.emptyInstructions = "";
    }

    @After
    public void tearDown() {
        this.marsRoverService = null;
    }

    @Test
    public void createService() throws Exception {
        assertNotNull(this.marsRoverService);
    }

    @Test
    public void processEmptyInstructions() throws Exception {
        rover = marsRoverService.processInstructions(rover, emptyInstructions);

        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(),2);
        assertEquals(rover.getCardinalPoint(), 'N');
    }

    @Test
    public void processInstructions() throws Exception {
        instructions = "LMLMLMLMM";
        rover = marsRoverService.processInstructions(rover, instructions);
        assertEquals(rover.getX(), 1);
        assertEquals(rover.getY(),3);
        assertEquals(rover.getCardinalPoint(), 'N');

        rover.setX(3);
        rover.setY(3);
        rover.setCardinalPoint('E');
        instructions = "MMRMMRMRRM";
        rover = marsRoverService.processInstructions(rover, instructions);
        assertEquals(rover.getX(), 5);
        assertEquals(rover.getY(),1);
        assertEquals(rover.getCardinalPoint(), 'E');
    }

    @Test
    public void processWrongInstructions() throws Exception {
        instructions = "HYGJBOJN";
        try {
            rover = marsRoverService.processInstructions(rover, instructions);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
