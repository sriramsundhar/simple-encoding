package stream;

import encoding.ReferenceText;
import pojo.InputText;
import pojo.TextInfo;

import java.util.logging.Logger;

public class TransCode {
    private final Logger LOGGER = Logger.getLogger(TransCode.class.getName());
    private final ReferenceText refText = ReferenceText.getInstance();

    /**
     * Perform Horizontal transformation
     * @param input Input string
     * @return @{@link InputText} for another flow or sink
     */
    public InputText horizontalTransCode(InputText input) {
        LOGGER.info("horizontalTransCode");
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
        LOGGER.fine("Input: "+ input.getInputString() + " horizontal transform: "+ sb.toString());
        return InputText.getInstance(sb.toString(), input.getOffset()+1);
    }

    /**
     * Perform Vertical transformation
     * @param input Input string
     * @return @{@link InputText} for another flow or sink
     */
    public InputText verticalTranscode(InputText input) {
        LOGGER.info("vertical transcode");
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
        LOGGER.fine("Input: "+ input.getInputString() + " vertical transform: "+ sb.toString());
        return InputText.getInstance(sb.toString(), input.getOffset()+1);
    }

    /**
     * Perform Shift transformation
     * @param input Input string
     * @return @{@link InputText} for another flow or sink
     */
    public InputText shiftTranscode(InputText input, Integer shift) {
        LOGGER.fine("getOffset: "+input.getOffset());
        LOGGER.info("shift: "+shift);
        StringBuilder sb = new StringBuilder();

        input.getInputString().chars()
            .forEach(intStream -> {
                TextInfo textInfo = getStringForIntStream((char)intStream);
                if (textInfo.getHorizontalIndex() < 0) {
                    sb.append(textInfo.getCharacter());
                } else {
                    LOGGER.fine(textInfo.toString());
                    Integer netOffset = (textInfo.getIndex() + shift) % refText.getTextInfoList().size();
                    if(netOffset < 0) {
                        netOffset = netOffset + (refText.getTextInfoList().size());
                    }
                    LOGGER.fine("netOffset: "+netOffset);
                    sb.append(refText.getTextInfoList().get(netOffset).getCharacter());

                }
            });
        LOGGER.fine("Input: "+ input.getInputString() + " Shift transform: "+ sb.toString() + " shift: "+ shift);
        return InputText.getInstance(sb.toString(), input.getOffset()+1);
    }


    /**
     * Get Text info from library
     * @param character Input character
     * @return @{@link TextInfo} for the relevant character
     */
    private TextInfo getStringForIntStream(char character) {
        String letter = "" + character;
        TextInfo textInfo =  refText.getRefrenceTextMap().get(letter.toLowerCase());
        if(textInfo == null ) {
            textInfo = TextInfo.getInstance(-1,-1, letter);
        }
        return textInfo;
    }
}
