package encoding;

import akka.Done;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import stream.FileSink;
import stream.FileSource;
import stream.FlowComponents;

import java.util.concurrent.CompletionStage;

public class main {
    public static void main(String[] v) {
        final ActorSystem system = ActorSystem.create();
        final Materializer materializer = ActorMaterializer.create(system);

        CompletionStage<Done> completion =
                FileSource.getInstance("sampleFiles/inputSource.txt")
                    .via(FlowComponents.byteStringToString())
                    .via(FlowComponents.horizontalTransformFlow())
                    .via(FlowComponents.stringToByteString())
                    .runWith(FileSink.getSink(), materializer);

        completion.thenRun(() -> system.terminate());
    }
}
