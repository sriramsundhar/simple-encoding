package stream;

import akka.NotUsed;
import akka.stream.javadsl.Source;
import akka.util.ByteString;
import scala.concurrent.duration.FiniteDuration;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.concurrent.TimeUnit;

public class FileSource {
    final int maxLineSize = 8192;
    final FileSystem fs = FileSystems.getDefault();
    final FiniteDuration pollingInterval = FiniteDuration.create(250, TimeUnit.MILLISECONDS);

    private String fileName;

    private final Source<ByteString, NotUsed> lines;


    private FileSource(String fileName) {
        this.fileName = fileName;
        lines = akka.stream.alpakka.file.javadsl.FileTailSource.create(
                fs.getPath(fileName),8192, 0, pollingInterval);
    }

    public Source<ByteString, NotUsed> getFileSource() {
        return lines;
    }

    public static Source<ByteString, NotUsed> getInstance (String path) {
        return new FileSource(path).getFileSource();
//                .map(byteString -> {
//                    return byteString.toString();
//                });
    }
}
