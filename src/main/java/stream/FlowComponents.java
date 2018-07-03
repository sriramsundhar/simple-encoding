package stream;

import akka.NotUsed;
import akka.stream.javadsl.Flow;
import akka.util.ByteString;

public class FlowComponents {

    public static Flow<ByteString, String, NotUsed> byteStringToString() {
        return Flow.of(ByteString.class)
            .map(v -> v.utf8String());
    }

    public static Flow<String, ByteString, NotUsed> stringToByteString() {
        return Flow.of(String.class)
            .map(v -> ByteString.fromString(v));
    }

    public static Flow<String, String, NotUsed> horizontalTransformFlow() {
        return Flow.of(String.class)
            .map(v -> new TransCode().horizontalTransCode(v));
    }

}


