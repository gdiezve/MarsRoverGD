package thoughtworksChallenge.exceptions;

public class PortalOutsidePlateauBoundaries extends MarsRoverException {

    public PortalOutsidePlateauBoundaries() { super("Portal coordinates are outside plateau boundaries."); }
}
