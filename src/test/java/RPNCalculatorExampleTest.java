import com.airwallex.rpncalculator.calculator.RPNCalculator;
import com.airwallex.rpncalculator.exception.OperationException;
import junit.framework.Assert;
import org.junit.Test;

/**
 * @Author Sangdi
 * @Date 2019/1/13
 */
public class RPNCalculatorExampleTest {


    @Test
    public void testExample() throws Exception {
        RPNCalculator calculator = new RPNCalculator();
        //Example 1
        Assert.assertEquals("5 2", calculator.process("5 2"));
        calculator.process("clear");

        //Example 2
        Assert.assertEquals("1.4142135623", calculator.process("2 sqrt"));
        Assert.assertEquals("3", calculator.process("clear 9 sqrt"));
        calculator.process("clear");


        //Example 3
        Assert.assertEquals("3", calculator.process("5 2 -"));
        Assert.assertEquals("", calculator.process("clear"));
        calculator.process("clear");

        //Example 4
        Assert.assertEquals("5 4 3 2", calculator.process("5 4 3 2"));
        Assert.assertEquals("20", calculator.process("undo undo *"));
        Assert.assertEquals("100", calculator.process("5 *"));
        Assert.assertEquals("20 5", calculator.process("undo"));
        calculator.process("clear");

        //Example 5
        Assert.assertEquals("7 6", calculator.process("7 12 2 /"));
        Assert.assertEquals("42", calculator.process("*"));
        Assert.assertEquals("10.5", calculator.process("4 /"));
        calculator.process("clear");

        //Example 6
        Assert.assertEquals("1 2 3 4 5", calculator.process("1 2 3 4 5"));
        Assert.assertEquals("1 2 3 20", calculator.process("*"));
        Assert.assertEquals("-1", calculator.process("clear 3 4 -"));
        calculator.process("clear");

        //Example 7
        Assert.assertEquals("1 2 3 4 5", calculator.process("1 2 3 4 5"));
        Assert.assertEquals("120", calculator.process("* * * *"));
        calculator.process("clear");

        //Example 8
        try{
            calculator.process("1 2 3 * 5 + * * 6 5");
        }catch (OperationException e){
            Assert.assertEquals("operator * (position: 15): insufficient parameters", e.getMessage());
            Assert.assertEquals("11", e.getStackInfo());
            calculator.process("clear");
        }

    }

    @Test
    public void testCustomCase() throws Exception {
        RPNCalculator calculator = new RPNCalculator();
        //wrong input
        try{
            calculator.process("aaa");
        }catch (OperationException e){
            Assert.assertEquals("operator aaa (position: 3): not an operator nor a number!", e.getMessage());
            Assert.assertEquals("", e.getStackInfo());
            calculator.process("clear");
        }

        //wrong input with correct number
        try{
            calculator.process("1 2 aaa");
        }catch (OperationException e){
            Assert.assertEquals("operator aaa (position: 7): not an operator nor a number!", e.getMessage());
            Assert.assertEquals("1 2", e.getStackInfo());
            calculator.process("clear");
        }


        //sqrt negative number
        try{
            calculator.process("-1 sqrt");
        }catch (OperationException e){
            Assert.assertEquals("operator sqrt (position: 7): cannot sqrt a negative value", e.getMessage());
            Assert.assertEquals("-1", e.getStackInfo());
            calculator.process("clear");
        }

        //divide zero number
        try{
            calculator.process("2 0 /");
        }catch (OperationException e){
            Assert.assertEquals("operator / (position: 5): cannot divide zero value", e.getMessage());
            Assert.assertEquals("2 0", e.getStackInfo());
            calculator.process("clear");
        }
    }


}