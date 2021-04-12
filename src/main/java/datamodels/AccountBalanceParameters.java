package datamodels;

public class AccountBalanceParameters {

    private String MessageReference;
    private String AccountNumber;

    public AccountBalanceParameters(String messageReference, String accountNumber) {
        MessageReference = messageReference;
        AccountNumber = accountNumber;
    }

    public String getMessageReference() {
        return MessageReference;
    }

    public void setMessageReference(String messageReference) {
        MessageReference = messageReference;
    }

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }
}
