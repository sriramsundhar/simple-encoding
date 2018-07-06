package stream;

import akka.Done;
import akka.japi.function.Function;
import akka.japi.function.Creator;
import akka.stream.alpakka.file.javadsl.LogRotatorSink;
import akka.stream.javadsl.Sink;
import akka.util.ByteString;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;
import java.util.concurrent.CompletionStage;

public class FileSink {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("'stream-'yyyy-MM-dd_HH'.log'");

    private final String outputFolder = (System.getenv("OUTPUT_FOLDER") == null) ? "sampleFiles/output" : System.getenv("OUTPUT_FOLDER");

    private final Path destinationDir = FileSystems.getDefault().getPath(outputFolder);

    private Creator<Function<ByteString, Optional<Path>>> timeBasedPathCreator =
            () -> {
                final String[] currentFileName = new String[] {null};
                return (element) -> {
                    String newName = LocalDateTime.now().format(formatter);
                    if (newName.equals(currentFileName[0])) {
                        return Optional.empty();
                    } else {
                        currentFileName[0] = newName;
                        return Optional.of(destinationDir.resolve(newName));
                    }
                };
            };

    private Creator<Function<ByteString, Optional<Path>>> pathGeneratorCreator = timeBasedPathCreator;
    private Sink<ByteString, CompletionStage<Done>> fileSink = LogRotatorSink.createFromFunction(pathGeneratorCreator);

    private Sink<ByteString, CompletionStage<Done>> getFileSink() {
        return fileSink;
    }

    public static Sink<ByteString, CompletionStage<Done>> getSink() {
        return new FileSink().getFileSink();
    }


}
