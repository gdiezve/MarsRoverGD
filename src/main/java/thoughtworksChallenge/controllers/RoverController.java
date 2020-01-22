package thoughtworksChallenge.controllers;

import thoughtworksChallenge.domain.Rover;

public class RoverController {

    public RoverController() {

    }

    /**
     * Process the command on given rover
     * @param rover that would have new position attributes
     * @param command instruction of new rover's position
     * @throws Exception error when command is incorrect
     */
    public Rover readCommand(char command, Rover rover) throws Exception {

        if (command == 'L') {
            turnLeft(rover);
        } else if (command == 'R') {
            turnRight(rover);
        } else if (command == 'M') {
            move(rover);
        } else {
            throw new Exception("Enter a valid command, please.");
        }

        return rover;
    }

    //TODO: explicar metodes privats
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
