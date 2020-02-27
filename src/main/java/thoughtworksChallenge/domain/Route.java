package thoughtworksChallenge.domain;

import thoughtworksChallenge.exceptions.WrongRoverPositionException;

public class Route {

    private Move move;

    public Route() {
        this.move = new Move();
    }

    /**
     * Process the instructions on given rover
     * @param plateau where rover is going to move
     * @param rover that is going to move around plateau
     * @param instructions instructions of new rover's route
     * @throws Exception error when Rover doesn't fit on Plateau dimensions
     */
    public void processInstructions(Plateau plateau, Rover rover, String instructions) throws WrongRoverPositionException {

        for (int i = 0; i < instructions.length(); i++) {
            try {
                rover = move.readCommand(instructions.charAt(i), rover);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (rover.getX() > plateau.getX() || rover.getY() > plateau.getY() || rover.getX() < 0 || rover.getY() < 0) {
            throw new WrongRoverPositionException();
        } else {
            System.out.println("New rover orientation: " + rover.getX() + " " + rover.getY() + " " + rover.getCardinalPoint() + "\n");
        }
    }
}
