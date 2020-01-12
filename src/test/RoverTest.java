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
    private MarsDimension mars;
    private String turn;
    private char currentDirection;
    private String newExpectedPosition;

    public RoverTest(String turn, char currentDirection,String newExpectedPosition) {
        this.turn = turn;
        this.currentDirection = currentDirection;
        this.newExpectedPosition = newExpectedPosition;
    }

    @Before
    public void setUp() throws Exception {
        rover = new Rover(this.currentDirection, new Position(0,0));
        System.out.println(rover.toString());
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
                {"L",'N',"0|0|W"},
                {"R",'N',"0|0|E"},
                {"RR",'N',"0|0|S"},
                {"RRR",'N',"0|0|W"},
                {"LLL",'N',"0|0|E"},
        });
    }

    @Test
    public void exec(){
        System.out.println("Initializing Rover Position | Turn: " + this.turn + " CurrentDirection : " + this.currentDirection + "| Expected Position " + this.newExpectedPosition);
        Assert.assertEquals(rover.move(this.turn),newExpectedPosition);
    }

    @Override
    public String toString(){
        return "Initializing Rover Position | Turn: " + this.turn + " Current Direction : " + this.currentDirection;
    }
}
