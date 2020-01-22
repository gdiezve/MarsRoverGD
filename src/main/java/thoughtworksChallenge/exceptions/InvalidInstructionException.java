package thoughtworksChallenge.exceptions;

/**
 * Specific exception for Mars Rover problem.
 */
public class InvalidInstructionException extends MarsRoverException {

    public InvalidInstructionException() {
        super("Enter a valid command, please.");
    }
}
