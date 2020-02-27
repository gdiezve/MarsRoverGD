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

    /**
     * Move rover 1 point on plateau's grid
     * @param rover that would have new position attributes
     */
    private static Rover move(Rover rover) {
        char CP = rover.getCardinalPoint();
        switch (CP) {
            case 'N':
                rover.setY(rover.getY() + 1);
                break;
            case 'W':
                rover.setX(rover.getX() - 1);
                break;
            case 'S':
                rover.setY(rover.getY() - 1);
                break;
            case 'E':
                rover.setX(rover.getX() + 1);
                break;
        }
        return rover;
    }

    /**
     * Change rover orientation on plateau's grid counterclockwise
     * @param rover that would have new position attributes
     */
    private static Rover turnLeft(Rover rover) {
        char CP = rover.getCardinalPoint();
        switch (CP) {
            case 'N':
                rover.setCardinalPoint('W');
                break;
            case 'W':
                rover.setCardinalPoint('S');
                break;
            case 'S':
                rover.setCardinalPoint('E');
                break;
            case 'E':
                rover.setCardinalPoint('N');
                break;
        }
        return rover;
    }

    /**
     * Change rover orientation on plateau's grid clockwise
     * @param rover that would have new position attributes
     */
    private static Rover turnRight(Rover rover) {
        char CP = rover.getCardinalPoint();
        switch (CP) {
            case 'N':
                rover.setCardinalPoint('E');
                break;
            case 'W':
                rover.setCardinalPoint('N');
                break;
            case 'S':
                rover.setCardinalPoint('W');
                break;
            case 'E':
                rover.setCardinalPoint('S');
                break;
        }
        return rover;
    }
}
