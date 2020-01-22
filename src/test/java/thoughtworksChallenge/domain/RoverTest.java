package thoughtworksChallenge.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class RoverTest {

    private Rover rover;

    @Before
    public void before() {
        this.rover = new Rover(1,2,'N');
    }

    @After
    public void tearDown() {
        this.rover = null;
    }

    @Test
    public void createRover() throws Exception {
        assertEquals(rover.getX(),1);
        assertEquals(rover.getY(),2);
        assertEquals(rover.getCardinalPoint(), 'N');
        assertTrue(rover.getX() != 2);
        assertTrue(rover.getY() != 1);
        assertTrue(rover.getCardinalPoint() != 'W');
        assertTrue(rover.getCardinalPoint() != 'S');
        assertTrue(rover.getCardinalPoint() != 'E');
    }

    @Test
    public void setNewRoverSize() throws Exception {
        this.rover.setX(3);
        this.rover.setY(1);

        assertEquals(rover.getX(),3);
        assertEquals(rover.getY(),1);
    }
}
