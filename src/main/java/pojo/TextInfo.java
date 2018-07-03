package pojo;

import java.util.Objects;

public class TextInfo {
    private Integer verticalIndex;

    private Integer horizontalIndex;

    private String character;

    private Integer index;

    private TextInfo(Integer verticalIndex, Integer horizontalIndex, String character) {
        this.horizontalIndex = horizontalIndex;
        this.verticalIndex = verticalIndex;
        this.character = character;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TextInfo) {
            TextInfo textInfo = (TextInfo) obj;
            return this.verticalIndex == textInfo.verticalIndex && this.horizontalIndex == textInfo.horizontalIndex;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TextInfo{" +
                "verticalIndex=" + verticalIndex +
                ", horizontalIndex=" + horizontalIndex +
                ", character=" + character +
                ", index=" + index +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(verticalIndex, horizontalIndex);
    }

    public static TextInfo getInstance(Integer verticalIndex, Integer horizontalIndex, String charecter) {
        return new TextInfo(verticalIndex, horizontalIndex, charecter);
    }

    public Integer getHorizontalIndex() {
        return horizontalIndex;
    }

    public Integer getVerticalIndex() {
        return verticalIndex;
    }

    public String getCharacter() {
        return character;
    }
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }
}
