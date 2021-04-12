package datamodels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SendToMpesaParameters {

    @SerializedName("MessageReference")
    @Expose
    private String messageReference;
    @SerializedName("CallBackUrl")
    @Expose
    private String callBackUrl;
    @SerializedName("Source")
    @Expose
    private Source source;
    @SerializedName("Destinations")
    @Expose
    private List<DestinationMpesa> destinations = null;

    public SendToMpesaParameters(String messageReference, String callBackUrl, Source source, List<DestinationMpesa> destinations) {
        this.messageReference = messageReference;
        this.callBackUrl = callBackUrl;
        this.source = source;
        this.destinations = destinations;
    }

    public String getMessageReference() {
        return messageReference;
    }

    public void setMessageReference(String messageReference) {
        this.messageReference = messageReference;
    }

    public String getCallBackUrl() {
        return callBackUrl;
    }

    public void setCallBackUrl(String callBackUrl) {
        this.callBackUrl = callBackUrl;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public List<DestinationMpesa> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<DestinationMpesa> destinations) {
        this.destinations = destinations;
    }

}