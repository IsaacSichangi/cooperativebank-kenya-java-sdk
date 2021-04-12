package datamodelsresponses;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TransactionStatus {

    @SerializedName("MessageReference")
    @Expose
    private String messageReference;
    @SerializedName("MessageDateTime")
    @Expose
    private String messageDateTime;
    @SerializedName("MessageCode")
    @Expose
    private int messageCode;
    @SerializedName("MessageDescription")
    @Expose
    private String messageDescription;
    @SerializedName("Source")
    @Expose
    private Source source;
    @SerializedName("Destinations")
    @Expose
    private List<Destinations> destinations = null;

    public String getMessageReference() {
        return messageReference;
    }

    public void setMessageReference(String messageReference) {
        this.messageReference = messageReference;
    }

    public String getMessageDateTime() {
        return messageDateTime;
    }

    public void setMessageDateTime(String messageDateTime) {
        this.messageDateTime = messageDateTime;
    }

    public int getMessageCode() {
        return messageCode;
    }

    public void setMessageCode(int messageCode) {
        this.messageCode = messageCode;
    }

    public String getMessageDescription() {
        return messageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        this.messageDescription = messageDescription;
    }

    public Source getSource() {
        return source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    public List<Destinations> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destinations> destinations) {
        this.destinations = destinations;
    }

}