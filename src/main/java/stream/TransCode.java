package stream;

import encoding.ReferenceText;
import pojo.TextInfo;

import java.util.logging.Logger;

public class TransCode {
    private final Logger LOGGER = Logger.getLogger(TransCode.class.getName());
    private ReferenceText refText = ReferenceText.getInstance();


    public String horizontalTransCode(String inputLine) {
        StringBuilder sb = new StringBuilder();
        LOGGER.fine(refText.getRefrenceTextMap().toString());
        inputLine.chars()
            .forEach(intStream -> {
                TextInfo textInfo = getStringForIntStream((char)intStream);
                if (textInfo.getHorizontalIndex() < 0) {
                    sb.append(textInfo.getCharecter());
                } else {
                    LOGGER.fine(textInfo.toString());
                    sb.append(refText.getRefrenceTextList().get(textInfo.getVerticalIndex()).get(9-textInfo.getHorizontalIndex()));
                }
                LOGGER.fine("sb: " + sb.toString());
            });
        LOGGER.info("horizontal transform: "+ sb.toString());
        return sb.toString();
    }

    public String verticalTranscode(String inputLine) {
        StringBuilder sb = new StringBuilder();
        inputLine.chars()
            .forEach(intStream -> {
                TextInfo textInfo = getStringForIntStream((char)intStream);
                if (textInfo.getHorizontalIndex() < 0) {
                    sb.append(textInfo.getCharecter());
                } else {
                    LOGGER.fine(textInfo.toString());
                    sb.append(refText.getRefrenceTextList().get(3-textInfo.getVerticalIndex()).get(textInfo.getHorizontalIndex()));
                }
            });
        LOGGER.info("horizontal transform: "+ sb.toString());
        return sb.toString();
    }

    private TextInfo getStringForIntStream(char charecter) {
        String letter = "" + charecter;
        TextInfo textInfo =  refText.getRefrenceTextMap().get(letter.toLowerCase());
        if(textInfo == null ) {
            textInfo = TextInfo.getInstance(-1,-1, letter);
        }
        return textInfo;
    }
}
