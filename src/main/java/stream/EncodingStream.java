package stream;

import akka.Done;
import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.stream.ActorMaterializer;
import akka.stream.Materializer;
import akka.stream.javadsl.Flow;
import pojo.EncodingInfo;
import pojo.InputText;
import transformation.TransformationInfo;

import java.util.List;
import java.util.concurrent.CompletionStage;
import java.util.logging.Logger;

public class EncodingStream {
    final ActorSystem system = ActorSystem.create();
    final Materializer materializer = ActorMaterializer.create(system);

    private final Logger LOGGER = Logger.getLogger(TransCode.class.getName());


    public void createEncodingStreams(){
        CompletionStage<Done> completion =
            FileSource.getInstance("sampleFiles/inputSource.txt")
                .via(FlowComponents.byteStringToInputText())
                .via(getFlowComponents())
                .via(FlowComponents.stringToByteString())
                .runWith(FileSink.getSink(), materializer);

        completion.thenRun(() -> system.terminate());

        return;
    }


    private Flow<InputText, InputText, NotUsed> getFlowComponents() {
        List<EncodingInfo> encodingInfos = TransformationInfo.getInstance().getEncodingInfos();
        Flow<InputText, InputText, NotUsed> flowComponents = null;
        for(EncodingInfo encodingInfo: encodingInfos) {
            if(flowComponents == null) {
                flowComponents = encodingInfo.getEncodingType().getFlow();
            } else {
                flowComponents = flowComponents.via(encodingInfo.getEncodingType().getFlow());
            }
        }
        return flowComponents;
    }


}
