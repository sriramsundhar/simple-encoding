package encoding;

import pojo.TextInfo;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReferenceText {

    private final static Logger LOGGER = Logger.getLogger(ReferenceText.class.getName());

    private final String [] [] referenceTextArray= new String[][]{
        {"1","2","3","4","5","6","7","8","9","0"},
        {"q","w","e","r","t","y","u","i","o","p"},
        {"a","s","d","f","g","h","j","k","l",";"},
        {"z","x","c","v","b","n","m",",",".","/"},
    };

    private final List<List<String>> refrenceTextList = Arrays.stream(referenceTextArray)
            .map(Arrays::asList)
            .collect(Collectors.toList());

    private Map<String, TextInfo> referenceTextMap = null;

    public List<List<String>> getRefrenceTextList() {
        return refrenceTextList;
    }

    private void setRefrenceTextMap() {
        Map<String, TextInfo> referenceTextMap = new HashMap<>();
        IntStream.range(0, getRefrenceTextList().size())
            .forEach(verticalIndex -> {
                IntStream.range(0, getRefrenceTextList().get(verticalIndex).size())
                    .forEach(horizontalIndex -> {
                        referenceTextMap.put(
                            getRefrenceTextList().get(verticalIndex).get(horizontalIndex),
                            TextInfo.getInstance(verticalIndex, horizontalIndex));
                    });
            });
        this.referenceTextMap = referenceTextMap;
    }

    public Map<String, TextInfo> getRefrenceTextMap() {
        if(this.referenceTextMap == null) {
            this.setRefrenceTextMap();
        }
        return referenceTextMap;
    }
}
