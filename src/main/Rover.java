package main;

/**
 * Created by Administrator on 1/12/20.
 */
public class Rover {

    private char direction;
    private Position position;


    public Rover(char direction, Position position) {
        this.direction = direction;
        this.position = position;
    }

    public String move(String cmds) {
        Utilities util = new Utilities();
        if(!util.validateCommandSeq(cmds.toLowerCase())) {
            throw new IllegalArgumentException();
        }
        for (char cmd : cmds.toCharArray()){
            if(cmd == 'L') {
                turnLeft(this.direction);
            }
            if(cmd == 'R') {
                turnRight(this.direction);
            }
        }
        String newPosition = this.position.getX() + "|" + this.position.getY() + "|" + this.direction;
        System.out.println("NewPosition " + newPosition);
        return newPosition;
    }

    public char turnRight(char currentDirection) {
        switch(Character.toUpperCase(currentDirection)){
            case 'N':
                this.direction = 'E';
                break;
            case 'E':
                this.direction = 'S';
                break;
            case 'W':
                this.direction = 'N';
                break;
            case 'S':
                this.direction = 'W';
                break;
            default:
                throw new IllegalArgumentException();
        }
        return this.direction;
    }

    public char turnLeft(char currentDirection) {
        switch(Character.toUpperCase(currentDirection)){
            case 'N':
                this.direction = 'W';
                break;
            case 'E':
                this.direction = 'N';
                break;
            case 'W':
                this.direction = 'S';
                break;
            case 'S':
                this.direction = 'E';
                break;
            default:
                throw new IllegalArgumentException();
        }
        return this.direction;
    }
}
