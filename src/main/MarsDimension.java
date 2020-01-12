package main;

/**
 * Created by Administrator on 1/12/20.
 */
public class MarsDimension {

    private int maxX;
    private int minX;
    private int maxY;
    private int minY;


    public MarsDimension(){
        this(10,0,10,0);
    }

    public MarsDimension(int maxX, int minX, int maxY, int minY) {
        this.maxX = maxX;
        this.minX = minX;
        this.maxY = maxY;
        this.minY = minY;
    }

    public int getMaxX() {
        return maxX;
    }

    public void setMaxX(int maxX) {
        this.maxX = maxX;
    }

    public int getMinX() {
        return minX;
    }

    public void setMinX(int minX) {
        this.minX = minX;
    }

    public int getMaxY() {
        return maxY;
    }

    public void setMaxY(int maxY) {
        this.maxY = maxY;
    }

    public int getMinY() {
        return minY;
    }

    public void setMinY(int minY) {
        this.minY = minY;
    }

    public String toString(){
        return "Initializing Mars Max Positions | minX:" + this.getMinX() + " maxX: " + this.getMaxX() + " minY:" + this.getMinY() + " maxY:" + this.getMaxY();
    }
}
