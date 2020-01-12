package test;

import main.MarsDimension;
import main.Position;
import main.Rover;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

/**
 * Created by Administrator on 1/12/20.
 */
@RunWith(Parameterized.class)
public class RoverTest {

    public Rover rover;
    public MarsDimension marsDimension;
    private String command;
    private char currentDirection;
    private String newExpectedPosition;

    public RoverTest(String command, char currentDirection,String newExpectedPosition) {
        this.command = command;
        this.currentDirection = currentDirection;
        this.newExpectedPosition = newExpectedPosition;
    }

    @Before
    public void setUp() throws Exception {

        marsDimension = new MarsDimension();
        System.out.println( marsDimension.toString());
        rover = new Rover(this.currentDirection, new Position(0,0), marsDimension);
    }

    @After
    public void tearDown() throws Exception {

    }

    /***
     * {DirectionToTurnTo, CurrentDirection, NewDirection}
     * @return
     */
    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][] {
                {"FLFF",'N',"2|1|W"},
                {"FLFFFB",'N',"2|1|W"},
                {"FLFFFFFFFFFFF",'N',"0|1|W"}
        });
    }

    @Test
    public void exec(){
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------------");
        System.out.println("Initializing Rover Position | Command: " + this.command + " CurrentDirection : " + this.currentDirection + "| Expected Position " + this.newExpectedPosition);
        Assert.assertEquals(rover.executeCommand(this.command), newExpectedPosition);
    }

    @Override
    public String toString(){
        return "Initializing Rover Position | Turn: " + this.command + " Current Direction : " + this.currentDirection;
    }
}
