package thoughtworksChallenge.domain;

import thoughtworksChallenge.exceptions.InvalidInstructionException;

public class Move {

    /**
     * Process the command on given rover
     * @param rover that would have new position attributes
     * @param command instruction of new rover's position
     * @throws Exception error when command is incorrect
     */
    public Rover readCommand(char command, Rover rover) throws InvalidInstructionException {

        switch (command) {
            case 'L':
                turnLeft(rover);
                break;
            case 'R':
                turnRight(rover);
                break;
            case 'M':
                move(rover);
                break;
            default:
                throw new InvalidInstructionException();
        }

        return rover;
    }
}
