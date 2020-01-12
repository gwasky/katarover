package main;

/**
 * Created by Administrator on 1/12/20.
 */
public class Rover {

    private String direction;
    private Position position;


    public Rover(String direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public String move(String cmd) {
        String newPosition = this.position.getX() + "|" + this.position.getY() + "|" + this.direction;
        System.out.println("New Position " + newPosition);
        return newPosition;
    }


//    public String turnRight(String cmd) {
//        switch ()
//    }
}
