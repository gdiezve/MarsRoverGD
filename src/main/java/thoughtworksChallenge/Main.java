package thoughtworksChallenge;

import thoughtworksChallenge.domain.Plateau;
import thoughtworksChallenge.domain.Route;
import thoughtworksChallenge.domain.Rover;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    /**
     * Main method of Mars Rover problem
     * @param args arguments
     */
    public static void main(String[] args) {

        File input = new File(args[0]);
        Scanner scanner = new Scanner("");
        int i = 1;

        try {
            scanner = new Scanner(input);
        } catch (FileNotFoundException e) {
            System.out.println(e);
        }


        Route roverRoute;

        Plateau plateau = new Plateau(scanner.nextInt(), scanner.nextInt());
        System.out.println("Plateau dimensions: " + plateau.getX() + " " + plateau.getY() + "\n");

        while (scanner.hasNextLine()) {
            Rover rover = new Rover();

            rover.setX(scanner.nextInt());
            rover.setY(scanner.nextInt());
            rover.setCardinalPoint(scanner.next().charAt(0));
            System.out.println("Rover " + i + " orientation: " + rover.getX() + " " + rover.getY() + " " + rover.getCardinalPoint() + "\n");

            String instructions = scanner.next();
            System.out.println("Instructions: " + instructions + "\n");

            try {
                roverRoute = new Route(instructions, rover);
                roverRoute.processRoute(instructions);
            } catch (Exception e) {
                System.out.println(e);
            }

            i++;
        }

    }
}
