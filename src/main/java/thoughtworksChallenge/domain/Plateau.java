package thoughtworksChallenge.domain;

import thoughtworksChallenge.exceptions.PortalOutsidePlateauBoundaries;

public class Plateau {

    private int x;
    private int y;
    private Portal portal;


    /**
     * Constructor Plateau class
     */
    public Plateau (int x, int y) {
        this.x = x;
        this.y = y;
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

    public void addPortal(Portal portal) throws PortalOutsidePlateauBoundaries {
        this.portal = portal;
        if (this.portal.getEntryX() > this.x || this.portal.getEntryY() > this.y || this.portal.getExitX() > this.x || this.portal.getExitY() > this.y) throw new PortalOutsidePlateauBoundaries();
    }


}
