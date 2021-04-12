package datamodels;

public class AccountFullStatementParameters {

    private String MessageReference;
    private String AccountNumber;
    private String StartDate;
    private String EndDate;

    public AccountFullStatementParameters(String messageReference, String accountNumber, String startDate, String endDate) {
        MessageReference = messageReference;
        AccountNumber = accountNumber;
        StartDate = startDate;
        EndDate = endDate;
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

    public String getStartDate() {
        return StartDate;
    }

    public void setStartDate(String startDate) {
        StartDate = startDate;
    }

    public String getEndDate() {
        return EndDate;
    }

    public void setEndDate(String endDate) {
        EndDate = endDate;
    }
}
