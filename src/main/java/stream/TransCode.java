package stream;

import encoding.ReferenceText;
import pojo.InputText;
import pojo.TextInfo;

import java.util.logging.Logger;

public class TransCode {
    private final Logger LOGGER = Logger.getLogger(TransCode.class.getName());
    private ReferenceText refText = ReferenceText.getInstance();


    public InputText horizontalTransCode(InputText input) {
        StringBuilder sb = new StringBuilder();
        LOGGER.fine(refText.getRefrenceTextMap().toString());
        input.getInputString().chars()
            .forEach(intStream -> {
                TextInfo textInfo = getStringForIntStream((char)intStream);
                if (textInfo.getHorizontalIndex() < 0) {
                    sb.append(textInfo.getCharacter());
                } else {
                    LOGGER.fine(textInfo.toString());
                    sb.append(refText.getRefrenceTextList().get(textInfo.getVerticalIndex()).get(9-textInfo.getHorizontalIndex()));
                }
                LOGGER.fine("sb: " + sb.toString());
            });
        LOGGER.info("horizontal transform: "+ sb.toString());
        return InputText.getInstance(input.getOffset(), sb.toString());
    }

    public InputText verticalTranscode(InputText input) {
        StringBuilder sb = new StringBuilder();
        input.getInputString().chars()
            .forEach(intStream -> {
                TextInfo textInfo = getStringForIntStream((char)intStream);
                if (textInfo.getHorizontalIndex() < 0) {
                    sb.append(textInfo.getCharacter());
                } else {
                    LOGGER.fine(textInfo.toString());
                    sb.append(refText.getRefrenceTextList().get(3-textInfo.getVerticalIndex()).get(textInfo.getHorizontalIndex()));
                }
            });
        LOGGER.info("horizontal transform: "+ sb.toString());
        return InputText.getInstance(input.getOffset(), sb.toString());
    }

    public InputText shiftTranscode(InputText input) {
        StringBuilder sb = new StringBuilder();
        input.getInputString().chars()
            .forEach(intStream -> {
                TextInfo textInfo = getStringForIntStream((char)intStream);
                if (textInfo.getHorizontalIndex() < 0) {
                    sb.append(textInfo.getCharacter());
                } else {
                    LOGGER.fine(textInfo.toString());
                    Integer netOffset = (textInfo.getIndex() + input.getOffset()) % (refText.getTextInfoList().size() - 1);
                    if(netOffset < 0) {
                        netOffset = netOffset + (refText.getTextInfoList().size() - 1);
                    }
                    sb.append(refText.getTextInfoList().get(netOffset).getCharacter());

                }
            });
        LOGGER.info("Shift transform: "+ sb.toString());
        return InputText.getInstance(input.getOffset(), sb.toString());
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
