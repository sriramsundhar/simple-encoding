package pojo;

/**
 * This object hosts the details about encoding
 */
public class EncodingInfo {

    private EncodingType encodingType;

    private Integer shift;

    private EncodingInfo(EncodingType encodingType, Integer shift) {
        this.encodingType = encodingType;
        this.shift = shift;
    }

    public static EncodingInfo getInstance(String encodingType) {
        if(encodingType.matches("-?\\d+")) {
            return new EncodingInfo(EncodingType.getEncodinType(encodingType), Integer.parseInt(encodingType));
        }
        return new EncodingInfo(EncodingType.getEncodinType(encodingType), 0);
    }

    public EncodingType getEncodingType() {
        return encodingType;
    }

    public Integer getShift() {
        return shift;
    }
}
