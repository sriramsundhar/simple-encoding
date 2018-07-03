package pojo;

import java.util.Objects;

public class TextInfo {
    private Integer verticalIndex;

    private Integer horizontalIndex;

    private String charecter;

    private TextInfo(Integer verticalIndex, Integer horizontalIndex, String charecter) {
        this.horizontalIndex = horizontalIndex;
        this.verticalIndex = verticalIndex;
        this.charecter = charecter;

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

    public String getCharecter() {
        return charecter;
    }
}
