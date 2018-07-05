package transformation;

import pojo.EncodingInfo;

import java.util.List;

/**
 * Holds info on the sequence in which the transform should be done
 */

public class TransformationInfo {

    private final List<EncodingInfo> encodingInfos;
    private TransformationService transformationService = new TransformationService();

    private TransformationInfo() {
        List<String> transSeq = transformationService.getTransformationSequenceFromFileSystem();
        this.encodingInfos = transformationService.getEncodingInfos(transSeq);
    }

    public static TransformationInfo getInstance() {
        return TransformationInfoRef.transformationInfo;
    }

    public List<EncodingInfo> getEncodingInfos() {
        return encodingInfos;
    }

    private static class TransformationInfoRef {
        private static final TransformationInfo transformationInfo = new TransformationInfo();
    }
}
