package datamodels;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AccountTransactions {

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
    @SerializedName("AccountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("AccountName")
    @Expose
    private String accountName;
    @SerializedName("NoOfTransactions")
    @Expose
    private int noOfTransactions;
    @SerializedName("TotalCredits")
    @Expose
    private int totalCredits;
    @SerializedName("TotalDebits")
    @Expose
    private int totalDebits;
    @SerializedName("Transactions")
    @Expose
    private List<Transaction> transactions = null;

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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public int getNoOfTransactions() {
        return noOfTransactions;
    }

    public void setNoOfTransactions(int noOfTransactions) {
        this.noOfTransactions = noOfTransactions;
    }

    public int getTotalCredits() {
        return totalCredits;
    }

    public void setTotalCredits(int totalCredits) {
        this.totalCredits = totalCredits;
    }

    public int getTotalDebits() {
        return totalDebits;
    }

    public void setTotalDebits(int totalDebits) {
        this.totalDebits = totalDebits;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
