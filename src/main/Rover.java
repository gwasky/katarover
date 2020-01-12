package main;

/**
 * Created by Administrator on 1/12/20.
 */
public class Rover {

    private char direction;
    private Position position;
    private MarsDimension marsDim;


    public Rover(char direction, Position position, MarsDimension marsDim) {
        this.direction = direction;
        this.position = position;
        this.marsDim = marsDim;
    }

    public String executeCommand(String cmds) {
        String commands = cmds.toUpperCase();
        Utilities util = new Utilities();
        if(!util.validateCommandSeq(commands.toUpperCase())) {
            throw new IllegalArgumentException();
        }
        for (char cmd : commands.toCharArray()){
            //System.out.println("CMD -> " + cmd);
            if(cmd == 'L') {
                turnLeft(this.direction);
            }
            if(cmd == 'R') {
                turnRight(this.direction);
            }
            if(cmd == 'F'){
                moveForward(this.direction);
                System.out.println("Current Position [" + position.getX() + "|" + position.getY() + "|" + this.direction +"]");
            }
            if(cmd == 'B'){
                moveBackward(this.direction);
                System.out.println("Current Position [" + position.getX() + "|" + position.getY() + "|" + this.direction +"]");
            }
        }
        String newPosition = this.position.getX() + "|" + this.position.getY() + "|" + this.direction;
        // System.out.println("NewPosition " + newPosition);
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
        // System.out.println("Current Direction -> " + currentDirection);
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


    public void moveForward(char currentDirection) {
        switch(Character.toUpperCase(currentDirection)){
            case 'N':
                if(this.position.getY() < this.marsDim.getMaxY())
                    this.position.setY(this.position.getY() + 1);
                else
                    this.position.setY(0);
                break;
            case 'E':
                if(this.position.getX() < this.marsDim.getMaxX())
                    this.position.setX(this.position.getX() + 1);
                else
                    this.position.setX(0);
                break;
            case 'W':
                if(this.position.getX() < this.marsDim.getMaxX())
                    this.position.setX(this.position.getX() + 1);
                else
                    this.position.setX(0);
                break;
            case 'S':
                if(this.position.getY() < this.marsDim.getMaxY())
                    this.position.setY(this.position.getY() + 1);
                else
                    this.position.setY(0);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }

    public void moveBackward(char currentDirection) {
        // Set X,Y to zero if Mar Min/Max Dimensions are exceeded
        switch(Character.toUpperCase(currentDirection)){
            case 'N':
                if(this.position.getY() > this.marsDim.getMinY())
                    this.position.setY(this.position.getY() - 1);
                else
                    this.position.setY(0);
                break;
            case 'E':
                if(this.position.getX() > this.marsDim.getMinX())
                    this.position.setX(this.position.getX() - 1);
                else
                    this.position.setX(0);
                break;
            case 'W':
                if(this.position.getX() > this.marsDim.getMinX())
                    this.position.setX(this.position.getX() - 1);
                else
                    this.position.setX(0);
                break;
            case 'S':
                if(this.position.getY() > this.marsDim.getMinY())
                    this.position.setY(this.position.getY() - 1);
                else
                    this.position.setY(0);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
}
