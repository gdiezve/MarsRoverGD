package thoughtworksChallenge.exceptions;

/**
 * Specific exception for Mars Rover problem.
 */
public class RoverOutsidePlateauBoundaries extends MarsRoverException {

    public RoverOutsidePlateauBoundaries() {
        super("Can't move rover robot, it would be out of plateau limits.");
    }
}
