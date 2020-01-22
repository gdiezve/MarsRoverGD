package thoughtworksChallenge.services;


import thoughtworksChallenge.controllers.*;
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
    public Rover processInstructions(Rover rover, String instructions) throws Exception {
        for (int i = 0; i < instructions.length(); i++) {
            rover = roverController.readCommand(instructions.charAt(i), rover);
        }
        return rover;
    }
}
