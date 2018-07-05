package pojo;

import akka.NotUsed;
import akka.stream.javadsl.Flow;
import stream.FlowComponents;

/**
 * Enum of Encoding Types
 */
public enum EncodingType {
    VERTICAL(FlowComponents.verticalTransformFlow()),
    HORIZONTAL(FlowComponents.horizontalTransformFlow()),
    SHIFT(FlowComponents.shiftTransformFlow());

    private Flow<InputText, InputText, NotUsed> flow;

    EncodingType(Flow<InputText, InputText, NotUsed> flow) {
        this.flow = flow;
    }

    /**
     * Get Encoding type by input String
     * @param value Input String
     * @return @{@link EncodingType} by value
     */
    public static EncodingType getEncodinType(String value) {
        if(value.matches("-?\\d+")) {
            return SHIFT;
        }
        switch (value.toUpperCase()) {
            case "V": return VERTICAL;
            case "H": return HORIZONTAL;
            default: return null;
        }
    }

    public Flow<InputText, InputText, NotUsed> getFlow() {
        return flow;
    }
}
