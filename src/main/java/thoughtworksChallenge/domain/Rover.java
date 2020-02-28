package thoughtworksChallenge.domain;

public class Rover {

    private int x;
    private int y;
    private char cardinalPoint;

    /**
     * Constructor Rover class
     */
    public Rover(){
        this.x = 0;
        this.y = 0;
        this.cardinalPoint = ' ';
    }

    /**
     * Constructor Rover class
     */
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

    public void move() {
        switch (this.cardinalPoint) {
            case 'E':
                this.x++;
                break;
            case 'W':
                this.x--;
                break;
            case 'N':
                this.y++;
                break;
            case 'S':
                this.y--;
        }
    }
}
