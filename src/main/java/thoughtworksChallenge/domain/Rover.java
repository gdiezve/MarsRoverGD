package thoughtworksChallenge.domain;

public class Rover {

    private int x;
    private int y;
    private char cardinalPoint;

    public Rover(){
        this.x = 0;
        this.y = 0;
        this.cardinalPoint = 0;
    }

    public Rover (int x, int y, char CP) {
        this.x = x;
        this.y = y;
        this.cardinalPoint = CP;
    }

    public char getCardinalPoint() {
        return cardinalPoint;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public void setCardinalPoint(char cardinalPoint) {
        this.cardinalPoint = cardinalPoint;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

}
