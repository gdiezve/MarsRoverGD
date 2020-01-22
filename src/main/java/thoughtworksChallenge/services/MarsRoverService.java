package thoughtworksChallenge.services;


import thoughtworksChallenge.controllers.*;
import thoughtworksChallenge.domain.Plateau;
import thoughtworksChallenge.domain.Rover;

public class MarsRoverService {

    private RoverController roverController;

    public MarsRoverService() {
        this.roverController = new RoverController();
    }
    /**
     * Process the instructions on given rover
     * @param rover that would have new position attributes
     * @param instructions instructions of new rover's position
     * @return rover after process instructions
     * @throws Exception error when some command is incorrect
     */
    public void processInstructions(Plateau plateau, Rover rover, String instructions) throws Exception {

        for (int i = 0; i < instructions.length(); i++) {
            try {
                rover = roverController.readCommand(instructions.charAt(i), rover);
            } catch (Exception e) {
                System.out.println(e);
            }
        }

        if (rover.getX() > plateau.getX() || rover.getY() > plateau.getY() || rover.getX() < 0 || rover.getY() < 0) {
            throw new Exception("Can't move rover robot, it would be out of plateau limits.");
        } else {
            System.out.print(rover.getX());
            System.out.print(' ');
            System.out.print(rover.getY());
            System.out.print(' ');
            System.out.println( rover.getCardinalPoint());
        }
    }
}
