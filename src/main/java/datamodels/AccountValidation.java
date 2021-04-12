package datamodels;

public class AccountValidation {

  private String MessageReference;
  private String MessageDateTime;
  private int MessageCode;
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

    public int getMessageCode() {
        return MessageCode;
    }

    public void setMessageCode(int messageCode) {
        MessageCode = messageCode;
    }

    public String getMessageDescription() {
        return MessageDescription;
    }

    public void setMessageDescription(String messageDescription) {
        MessageDescription = messageDescription;
    }
}
