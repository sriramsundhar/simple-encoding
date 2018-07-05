package encoding;

import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import stream.EncodingStream;

public class main {
    public static void main(String[] v) {
        final ActorSystem system = ActorSystem.create();
        final Materializer materializer = ActorMaterializer.create(system);

        new EncodingStream().createEncodingStreams();


    }
}
