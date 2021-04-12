package datamodels;

public class AccountTransactionsParamaters {

    private String MessageReference;
    private String AccountNumber;
    private int NoOfTransactions;

    public AccountTransactionsParamaters(String messageReference, String accountNumber, int noOfTransactions) {
        MessageReference = messageReference;
        AccountNumber = accountNumber;
        NoOfTransactions = noOfTransactions;
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

    public int getNoOfTransactions() {
        return NoOfTransactions;
    }

    public void setNoOfTransactions(int noOfTransactions) {
        NoOfTransactions = noOfTransactions;
    }
}
