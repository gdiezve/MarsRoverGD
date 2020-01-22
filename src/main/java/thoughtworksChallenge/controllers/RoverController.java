package thoughtworksChallenge.controllers;

import thoughtworksChallenge.domain.Rover;

public class RoverController {

    public static final Integer N = 1;
    public static final Integer E = 2;
    public static final Integer S = 3;
    public static final Integer W = 4;

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
        if (rover.getCardinalPoint() == N) {
            rover.setY(rover.getY() + 1);
        } else if (rover.getCardinalPoint() == E) {
            rover.setX(rover.getX() + 1);
        } else if (rover.getCardinalPoint() == S) {
            rover.setY(rover.getY() - 1);
        } else if (rover.getCardinalPoint() == W) {
            rover.setX(rover.getX() - 1);
        }

        return rover;
    }
    private static Rover turnLeft(Rover rover) {
        int CP = rover.getCardinalPoint() - 1;
        if (CP < N) {
            rover.setCardinalPoint('W');
        } else {
            rover.setCardinalPoint((char) (CP - 1));
        }
        return rover;
    }
    private static Rover turnRight(Rover rover) {
        int CP = rover.getCardinalPoint() + 1;
        if (CP > W) {
            rover.setCardinalPoint('N');
        } else {
            rover.setCardinalPoint((char) (CP + 1));
        }
        return rover;
    }
}
