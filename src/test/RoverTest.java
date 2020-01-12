package test;

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
    public Position position;
    private String turn;
    private String newExpectedPosition;

    public RoverTest(String turn, String newExpectedPosition) {
        this.turn = turn;
        this.newExpectedPosition = newExpectedPosition;
    }

    @Before
    public void setUp() throws Exception {
        rover = new Rover("E", new Position(0,0));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Parameterized.Parameters
    public static Collection<Object[]> testConditions(){
        return Arrays.asList(new Object[][] {
                {"L","0|0|W"},
                {"LR","0|0|N"}
        });
    }

    @Test
    public void turnRight(){
        System.out.println("newExpectedPosition -> " + newExpectedPosition );
        Assert.assertEquals(rover.move(turn),newExpectedPosition);
    }



}
