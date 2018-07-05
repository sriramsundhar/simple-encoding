package encoding;

import pojo.TextInfo;

import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ReferenceText {

    private final static Logger LOGGER = Logger.getLogger(ReferenceText.class.getName());

    private static final String [] [] referenceTextArray= new String[][]{
        {"1","2","3","4","5","6","7","8","9","0"},
        {"q","w","e","r","t","y","u","i","o","p"},
        {"a","s","d","f","g","h","j","k","l",";"},
        {"z","x","c","v","b","n","m",",",".","/"},
    };

    public List<List<String>> getRefrenceTextList() {
        return TransientTextRef.refrenceTextList;
    }

    public Map<String, TextInfo> getRefrenceTextMap() {
        return TransientTextRef.referenceTextMap;
    }

    public List<TextInfo> getTextInfoList() {
        return TransientTextRef.textInfoList;
    }

    public static ReferenceText getInstance () {
        return new ReferenceText();
    }

    private static class TransientTextRef {
        private static final List<List<String>> refrenceTextList = Arrays.stream(referenceTextArray)
                .map(Arrays::asList)
                .collect(Collectors.toList());

        private static final Map<String, TextInfo> referenceTextMap = getRefrenceTextMap();

        private static final List<TextInfo> textInfoList = getTextInfoList();

        private static Map<String, TextInfo> getRefrenceTextMap() {
            Map<String, TextInfo> referenceTextMap = new LinkedHashMap<>();
            IntStream.range(0, refrenceTextList.size())
                .forEach(verticalIndex -> {
                    IntStream.range(0, refrenceTextList.get(verticalIndex).size())
                        .forEach(horizontalIndex -> {
                            referenceTextMap.put(
                                refrenceTextList.get(verticalIndex).get(horizontalIndex),
                                TextInfo.getInstance(verticalIndex, horizontalIndex, refrenceTextList.get(verticalIndex).get(horizontalIndex)));
                            });
                });
            return referenceTextMap;
        }

        private static final List<TextInfo> getTextInfoList() {
            List<TextInfo> textInfoList = new ArrayList<>();
            referenceTextMap.forEach((letter, textInfo) -> {
                textInfoList.add(textInfo);
                textInfo.setIndex(textInfoList.size() - 1);
            });
            return textInfoList;
        }
    }
}
