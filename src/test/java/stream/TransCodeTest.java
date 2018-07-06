package stream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.InputText;

import static org.junit.Assert.*;

public class TransCodeTest {

    private TransCode transCode = null;

    @Before
    public void setUp() {
        transCode = new TransCode();
    }

    @After
    public void tearDown() {
        transCode = null;
    }

    @Test
    public void horizontalTransform() {
        assertEquals("Transformed string is", ";lk", transCode.horizontalTransCode(InputText.getInstance("asd", 1)).getInputString());
        assertEquals("Transformed string is", ",mn", transCode.horizontalTransCode(InputText.getInstance("cvb", 1)).getInputString());
        assertEquals("Transformed string is", "654", transCode.horizontalTransCode(InputText.getInstance("567", 1)).getInputString());
        assertEquals("Transformed string is", " |!", transCode.horizontalTransCode(InputText.getInstance(" |!", 1)).getInputString());
        assertEquals("Transformed string is", "9ol.", transCode.horizontalTransCode(InputText.getInstance("2wsx", 1)).getInputString());
        assertEquals("Transformed string is", "7ujm", transCode.horizontalTransCode(InputText.getInstance("4rfv", 1)).getInputString());
    }

    @Test
    public void verticalTranscode() {
        assertEquals("Transformed string is", ",mn", transCode.verticalTranscode(InputText.getInstance("876", 1)).getInputString());
        assertEquals("Transformed string is", "fgh", transCode.verticalTranscode(InputText.getInstance("RTY", 1)).getInputString());
        assertEquals("Transformed string is", " `\\", transCode.verticalTranscode(InputText.getInstance(" `\\", 1)).getInputString());

    }

    @Test
    public void shiftTranscode() {
        assertEquals("Transformed string is", "r", transCode.shiftTranscode(InputText.getInstance("e", 1), 1).getInputString());
        assertEquals("Transformed string is", "/", transCode.shiftTranscode(InputText.getInstance("1", 1), -1).getInputString());
        assertEquals("Transformed string is", "1", transCode.shiftTranscode(InputText.getInstance( "2", 1), 39).getInputString());
        assertEquals("Transformed string is", "3", transCode.shiftTranscode(InputText.getInstance("2", 1), -39).getInputString());
        assertEquals("Transformed string is", "2", transCode.shiftTranscode(InputText.getInstance("2", 1), 40).getInputString());
        assertEquals("Transformed string is", "2", transCode.shiftTranscode(InputText.getInstance("2", 1), -40).getInputString());
        assertEquals("Transformed string is", "r", transCode.shiftTranscode(InputText.getInstance("e", 1), 41).getInputString());
        assertEquals("Transformed string is", "w", transCode.shiftTranscode(InputText.getInstance("e", 1), -41).getInputString());
    }
}