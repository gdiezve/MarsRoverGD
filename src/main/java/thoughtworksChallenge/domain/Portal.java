package thoughtworksChallenge.domain;

public class Portal {

    private int entryX;
    private int entryY;
    private int exitX;
    private int exitY;

    public Portal(int entryX, int entryY, int exitX, int exitY) {
        this.entryX = entryX;
        this.entryY = entryY;
        this.exitX = exitX;
        this.exitY = exitY;
    }

    public int getEntryX() {
        return entryX;
    }

    public int getEntryY() {
        return entryY;
    }

    public int getExitX() {
        return exitX;
    }

    public int getExitY() {
        return exitY;
    }



}
