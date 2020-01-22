package thoughtworksChallenge;

import thoughtworksChallenge.domain.Plateau;
import thoughtworksChallenge.domain.Rover;
import thoughtworksChallenge.services.*;

import java.util.Scanner;

public class Main {

    /**
     * Main method of Mars Rover problem
     * @param args arguments
     */
    public static void main(String[] args) {
        MarsRoverService marsRoverService = new MarsRoverService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Please, enter plateau dimensions (input example: 5 5):\n");
        Plateau plateau = new Plateau(scanner.nextInt(), scanner.nextInt());

        System.out.println("Please, enter rover orientation (input example: 2 3 N):\n");
        Rover rover = new Rover();

        rover.setX(scanner.nextInt());
        rover.setY(scanner.nextInt());
        rover.setCardinalPoint(scanner.next().charAt(0));

        System.out.println("Please, enter the instructions (input example: LMMLMRMM):\n");
        String instructions = scanner.next();

        try {
            marsRoverService.processInstructions(plateau, rover, instructions);
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}
