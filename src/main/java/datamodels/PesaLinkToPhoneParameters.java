package datamodels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PesaLinkToPhoneParameters {

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
    private List<DestinationPesaLinkSendToPhone> destinations = null;

    public PesaLinkToPhoneParameters(String messageReference, String callBackUrl, Source source, List<DestinationPesaLinkSendToPhone> destinations) {
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

    public List<DestinationPesaLinkSendToPhone> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<DestinationPesaLinkSendToPhone> destinations) {
        this.destinations = destinations;
    }

}