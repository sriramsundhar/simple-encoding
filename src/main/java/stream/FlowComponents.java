package stream;

import akka.NotUsed;
import akka.stream.javadsl.Flow;
import akka.util.ByteString;
import pojo.InputText;

public class FlowComponents {

    public static Flow<ByteString, InputText, NotUsed> byteStringToString() {
        return Flow.of(ByteString.class)
            .map(v -> InputText.getInstance(v.utf8String()));
    }

    public static Flow<InputText, ByteString, NotUsed> stringToByteString() {
        return Flow.of(InputText.class)
            .map(v -> ByteString.fromString(v.getInputString()));
    }

    public static Flow<InputText, InputText, NotUsed> horizontalTransformFlow() {
        return Flow.of(InputText.class)
            .map(v -> new TransCode().horizontalTransCode(v));
    }

    public static Flow<InputText, InputText, NotUsed> shiftTransformFlow() {
        return Flow.of(InputText.class)
                .map(v -> new TransCode().shiftTranscode(v));
    }
}


