package datamodelsresponses;

public class ErrorResponse {

    private String MessageReference;
    private String MessageDateTime;
    private String MessageCode;
    private String MessageDescription;


    public String getMessageReference() {
        return MessageReference;
    }

    public void setMessageReference(String messageReference) {
        MessageReference = messageReference;
    }

    public String getMessageDateTime() {
        return MessageDateTime;
    }

    public void setMessageDateTime(String messageDateTime) {
        MessageDateTime = messageDateTime;
    }

    public String getMessageCode() {
        return MessageCode;
    }

    public void setMessageCode(String messageCode) {
        MessageCode = messageCode;
    }

    public String getMessageDescription() {
        return MessageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        MessageDescription = messageDescription;
    }
}
