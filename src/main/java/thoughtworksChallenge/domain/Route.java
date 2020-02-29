package thoughtworksChallenge.domain;

import thoughtworksChallenge.exceptions.InvalidInstructionException;

public class Route {

    private String instructions;
    private Rover rover;

    public Route(String instructions, Rover rover) {
        this.instructions = instructions;
        this.rover = rover;
    }

    /**
     * Process the instructions on given rover
     * @param instructions instructions of new rover's route
     * @throws Exception error when Rover doesn't fit on Plateau dimensions
     */
    public void processRoute(String instructions) throws InvalidInstructionException {
        for (int i = 0; i < instructions.length(); i++) {
            if (instructions.charAt(i) != 'L' && instructions.charAt(i) != 'R' && instructions.charAt(i) != 'M') throw new InvalidInstructionException();
            readCommand(instructions.charAt(i));
        }

        System.out.println("New rover orientation: " + rover.getX() + " " + rover.getY() + " " + rover.getCardinalPoint() + "\n");
    }

    /**
     * Process the command on route rover
     * @param command instruction of new rover's position
     * @throws Exception error when command is incorrect
     */
    private Rover readCommand(char command) {

        switch (command) {
            case 'L':
                rover.turnLeft();
                break;
            case 'R':
                rover.turnRight();
                break;
            case 'M':
                rover.move();
        }
        
        return rover;
    }
}
