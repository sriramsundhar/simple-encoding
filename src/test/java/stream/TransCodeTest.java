package stream;

import akka.util.ByteString;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class TransCodeTest {

    private TransCode transCode = null;

    @Before
    public void setUp() throws Exception {
        transCode = new TransCode();
    }

    @After
    public void tearDown() throws Exception {
        transCode = null;
    }

    @Test
    public void horizontalTransform() {
        String transformedString = transCode.horizontalTransCode("asd");
        assertEquals("Transformed string is", ";lk", transformedString);
        assertEquals("Transformed string is", ",mn", transCode.horizontalTransCode("cvb"));
        assertEquals("Transformed string is", "654", transCode.horizontalTransCode("567"));
        assertEquals("Transformed string is", " |!", transCode.horizontalTransCode(" |!"));
    }

    @Test
    public void verticalTranscode() {
        assertEquals("Transformed string is", ",mn", transCode.verticalTranscode("876"));
        assertEquals("Transformed string is", "fgh", transCode.verticalTranscode("RTY"));
        assertEquals("Transformed string is", " `\\", transCode.verticalTranscode(" `\\"));
    }
}