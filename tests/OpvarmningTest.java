import FirstOpgave.Opvarmning;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;


public class OpvarmningTest {
    Opvarmning opvarmning = new Opvarmning();

    @Test
    public void isANumberReturnsFalseIfString() {


        Assert.assertFalse(opvarmning.isANumber("hi"));
    }

    @Test
    public void isNotExitInput() {

        Assert.assertFalse(opvarmning.isExitInput("k"));
    }

    @Test
    public void calculateAverageBetweenPositiveAndNegative() {
        List<Double> listOfNumbers = Stream.of(-3., 9.).toList();
        Assert.assertEquals(3, opvarmning.calculateAverage(listOfNumbers), 0);
    }
}