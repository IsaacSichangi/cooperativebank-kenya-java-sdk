package datamodelsresponses;

public class TransactionStatusParameters {

    private String MessageReference;

    public TransactionStatusParameters(String messageReference) {
        MessageReference = messageReference;
    }

    public String getMessageReference() {
        return MessageReference;
    }

    public void setMessageReference(String messageReference) {
        MessageReference = messageReference;
    }
}
