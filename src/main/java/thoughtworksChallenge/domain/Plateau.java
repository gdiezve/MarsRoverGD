package thoughtworksChallenge.domain;

import thoughtworksChallenge.exceptions.PortalOutsidePlateauBoundaries;
import thoughtworksChallenge.exceptions.RoverOutsidePlateauBoundaries;

import java.util.ArrayList;

public class Plateau {

    private int x;
    private int y;
    private Portal portal;
    private ArrayList<Rover> rovers;

    /**
     * Constructor Plateau class
     */
    public Plateau (int x, int y) {
        this.x = x;
        this.y = y;
        this.rovers = new ArrayList<Rover>();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Portal getPortal() {
        return portal;
    }

    public ArrayList<Rover> getRovers() {
        return rovers;
    }

    public void addPortal(Portal portal) throws PortalOutsidePlateauBoundaries {
        this.portal = portal;
        if (this.portal.getEntryX() > this.x || this.portal.getEntryY() > this.y || this.portal.getExitX() > this.x || this.portal.getExitY() > this.y) throw new PortalOutsidePlateauBoundaries();
    }

    public void addRover(Rover rover) throws RoverOutsidePlateauBoundaries {
        if (rover.getX() > this.x || rover.getY() > this.y || rover.getX() < 0 || rover.getY() < 0) throw new RoverOutsidePlateauBoundaries();
        this.rovers.add(rover);
    }
}
