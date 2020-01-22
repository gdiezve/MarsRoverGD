package thoughtworksChallenge.exceptions;

/**
 * Specific exception for Mars Rover problem.
 */
public class WrongRoverPositionException extends MarsRoverException {

    public WrongRoverPositionException() {
        super("Can't move rover robot, it would be out of plateau limits.");
    }
}
