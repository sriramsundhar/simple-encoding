package encoding;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.TextInfo;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

public class ReferenceTextTest {

    List<List<String>> refrenceTextList = null;
    Map<String, TextInfo> referenceTextMap = null;

    @Before
    public void setUp() throws Exception {
        ReferenceText referenceText = new ReferenceText();
        refrenceTextList = referenceText.getRefrenceTextList();
        referenceTextMap = referenceText.getRefrenceTextMap();
    }

    @After
    public void tearDown() throws Exception {
        refrenceTextList = null;
        referenceTextMap = null;
    }

    @Test
    public void getRefrenceTextList() {
        assertEquals("Number of rows returns 4", 4, refrenceTextList.size());
        assertEquals("Number of vertical columns in a row 1 is 10", 10, refrenceTextList.get(0).size());
        assertEquals("Number of vertical columns in a row 2 is 10", 10, refrenceTextList.get(1).size());
        assertEquals("First element of row 1 returns 1", "1", refrenceTextList.get(0).get(0));
        assertEquals("Second element of row 2 returns w", "w", refrenceTextList.get(1).get(1));
    }

    @Test
    public void getRefrenceTextMap() {
        assertEquals("Value of a is ", TextInfo.getInstance(2,0), referenceTextMap.get("a"));
        assertEquals("Value of v is ", TextInfo.getInstance(3,3), referenceTextMap.get("v"));

    }
}