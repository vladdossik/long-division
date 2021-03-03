import com.course.Calculator;
import com.course.ClassicFormatter;
import com.course.Pair;
import com.course.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CalculatorTest {
    private Calculator calculator;
    @BeforeEach
    public void setUp() throws Exception{
        calculator=new Calculator();
    }
    @Test
    @DisplayName("divisor is 0")
    public void testDivisorZero(){
        Throwable exception=assertThrows(IllegalArgumentException.class,()->calculator.divide(7,0));
        assertEquals("Divisor cannot be 0",exception.getMessage());
    }
    @Test
    @DisplayName("divided is 0")
    public void testDividedZero(){
        ArrayList<Pair>pairs=new ArrayList<>();
        pairs.add(new Pair(0,3));
        Result expected=new Result(0,3,0,0,pairs);
        assertEquals(calculator.divide(0,3).equals(expected),true);
    }
    @Test
    @DisplayName("simple division")
    public void testSimpleDivision(){
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(7,4));
        pairs.add(new Pair(38,36));
        pairs.add(new Pair(29,28));
        pairs.add(new Pair(14,12));
        pairs.add(new Pair(25,24));
        Result expected=new Result(78945,4,19736,1,pairs);
        assertEquals(calculator.divide(78945,4).equals(expected),true);
    }
    @Test
    @DisplayName("divisionLessPairs")
    public void testDivisionLessPairs(){
        ArrayList<Pair> pairs=new ArrayList<>();
        pairs.add(new Pair(10,10));
        pairs.add(new Pair(21,20));
        pairs.add(new Pair(10,10));
        Result expected=new Result(10210,5,2042,0,pairs);
        assertEquals(calculator.divide(10210,5).equals(expected),true);
    }
    @Test
    @DisplayName("hard division")
    public void testHardDivision(){
        ArrayList<Pair> pairs=new ArrayList<>();
        pairs.add(new Pair(12,12));
        pairs.add(new Pair(12,12));
        Result expected=new Result(120012,12,10001,0,pairs);
        assertEquals(calculator.divide(120012,12).equals(expected),true);
    }
}
