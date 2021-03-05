package formatters;

import com.course.model.ClassicFormatter;
import com.course.model.Pair;
import com.course.model.Result;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ClassicFormatterTest {
    ClassicFormatter classicFormatter;

    @BeforeEach
    public void setUp() throws Exception {
        classicFormatter = new ClassicFormatter();
    }

    @Test
    @DisplayName("small offset ")
    void testSmallOffset() {
        String expected =
                "\n" + "_10210|5\n" +
                        " 10   |----\n" +
                        " __   |2042\n" +
                        "  _21\n" +
                        "   20\n" +
                        "   __\n" +
                        "   _10\n" +
                        "    10\n" +
                        "    __\n" +
                        "     0\n";
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(10, 10));
        pairs.add(new Pair(21, 20));
        pairs.add(new Pair(10, 10));
        Result actual = new Result(10210, 5, 2042, 0, pairs);
        assertEquals(expected, classicFormatter.format(actual));
    }

    @Test
    @DisplayName("large offset ")
    void testLargeOffset() {
        String expected =
                "\n" + "_120012|12\n" +
                        " 12    |-----\n" +
                        " __    |10001\n" +
                        "    _12\n" +
                        "     12\n" +
                        "     __\n" +
                        "      0\n";
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(12, 12));
        pairs.add(new Pair(12, 12));
        Result actual = new Result(120012, 12, 10001, 0, pairs);
        assertEquals(expected, classicFormatter.format(actual));
    }

    @Test
    @DisplayName("simple division")
    void testSimpleDivision() {
        String expected =
                "\n" + "_78945|4\n" +
                        " 4    |-----\n" +
                        " _    |19736\n" +
                        "_38\n" +
                        " 36\n" +
                        " __\n" +
                        " _29\n" +
                        "  28\n" +
                        "  __\n" +
                        "  _14\n" +
                        "   12\n" +
                        "   __\n" +
                        "   _25\n" +
                        "    24\n" +
                        "    __\n" +
                        "     1\n";
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(7, 4));
        pairs.add(new Pair(38, 36));
        pairs.add(new Pair(29, 28));
        pairs.add(new Pair(14, 12));
        pairs.add(new Pair(25, 24));
        Result actual = new Result(78945, 4, 19736, 1, pairs);
        assertEquals(expected, classicFormatter.format(actual));
    }

    @Test
    @DisplayName("divided is zero")
    void testDividedZero() {
        String expected =
                "\n" + "_0|4\n" +
                        " 0|-\n" +
                        " _|0\n" +
                        " 0\n";
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(0, 0));
        Result actual = new Result(0, 4, 0, 0, pairs);
        assertEquals(expected, classicFormatter.format(actual));
    }

    @Test
    @DisplayName("large divided")
    void testLargeDivided() {
        String expected =
                "\n_1000004535|5430\n" +
                        "  5430     |------\n" +
                        "  ____     |184162\n" +
                        " _45700\n" +
                        "  43440\n" +
                        "  _____\n" +
                        "  _22604\n" +
                        "   21720\n" +
                        "   _____\n" +
                        "   _8845\n" +
                        "    5430\n" +
                        "    ____\n" +
                        "    _34153\n" +
                        "     32580\n" +
                        "     _____\n" +
                        "     _15735\n" +
                        "      10860\n" +
                        "      _____\n" +
                        "       4875\n";
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(10000, 5430));
        pairs.add(new Pair(45700, 43440));
        pairs.add(new Pair(22604, 21720));
        pairs.add(new Pair(8845, 5430));
        pairs.add(new Pair(34153, 32580));
        pairs.add(new Pair(15735, 10860));
        Result actual = new Result(1000004535, 5430, 184162, 4875, pairs);
        assertEquals(expected, classicFormatter.format(actual));
    }

    @Test
    @DisplayName("negative divided")
    void testNegativeDivided() {
        String expected = "\n_-7879|13\n" +
                "  78  |----\n" +
                "  __  |-606\n" +
                "   _79\n" +
                "    78\n" +
                "    __\n" +
                "     1\n";
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(78, 78));
        pairs.add(new Pair(79, 78));
        Result actual = new Result(-7879, 13, -606, 1, pairs);
        assertEquals(expected, classicFormatter.format(actual));
    }

    @Test
    @DisplayName("negative divisor")
    void testNegativeDivisor() {
        String expected =
                "\n" + "_134565|-13\n" +
                        " 13    |------\n" +
                        " __    |-10351\n" +
                        "  _45\n" +
                        "   39\n" +
                        "   __\n" +
                        "   _66\n" +
                        "    65\n" +
                        "    __\n" +
                        "    _15\n" +
                        "     13\n" +
                        "     __\n" +
                        "      2\n";
        ArrayList<Pair> pairs = new ArrayList<>();
        pairs.add(new Pair(13, 13));
        pairs.add(new Pair(45, 39));
        pairs.add(new Pair(66, 65));
        pairs.add(new Pair(15, 13));
        Result actual = new Result(134565, -13, -10351, 2, pairs);
        assertEquals(expected, classicFormatter.format(actual));
    }
}
