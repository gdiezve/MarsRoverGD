package thoughtworksChallenge.domain;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import thoughtworksChallenge.exceptions.PortalOutsidePlateauBoundaries;
import thoughtworksChallenge.exceptions.RoverOutsidePlateauBoundaries;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(JUnit4.class)
public class PlateauTest {

    private Plateau plateau;

    @Before
    public void before() {
        this.plateau = new Plateau(5,6);
    }

    @After
    public void tearDown() {
        this.plateau = null;
    }

    @Test
    public void createPlateau() {
        assertEquals(plateau.getX(),5);
        assertEquals(plateau.getY(),6);
        assertTrue(plateau.getX() != 6);
        assertTrue(plateau.getY() != 5);
    }

    @Test
    public void setNewPlateauSize() {
        this.plateau.setX(4);
        this.plateau.setY(5);

        assertEquals(4, plateau.getX());
        assertEquals(5, plateau.getY());
    }

    @Test
    public void portalShouldFitInsidePlateau() throws PortalOutsidePlateauBoundaries {
        Portal portal = new Portal(3, 4, 1, 2);

        this.plateau.addPortal(portal);
        assertEquals(this.plateau.getPortal(), portal);
    }

    @Test(expected = PortalOutsidePlateauBoundaries.class)
    public void shouldThrowExceptionWhenPortalDoesNotFitOnPlateau() throws PortalOutsidePlateauBoundaries {
        Portal portal = new Portal(3,6,6,6);
        this.plateau.addPortal(portal);
    }

    @Test
    public void roverShouldBeOnsidePlateauBoundaries() throws RoverOutsidePlateauBoundaries {
        Rover r = new Rover(3,4,'N');

        this.plateau.addRover(r);
        assertEquals(true, this.plateau.getRovers().contains(r));
    }

    @Test(expected = RoverOutsidePlateauBoundaries.class)
    public void shouldThrowExceptionWhenRoverIsOutsidePlateauBoundaries() throws RoverOutsidePlateauBoundaries {
        Rover r = new Rover(6,7,'N');
        this.plateau.addRover(r);
    }
}
