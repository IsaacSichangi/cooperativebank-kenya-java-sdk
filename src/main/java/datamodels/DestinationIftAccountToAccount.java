package datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DestinationIftAccountToAccount {

    @SerializedName("AccountNumber")
    @Expose
    private String accountNumber;

    @SerializedName("ReferenceNumber")
    @Expose
    private String referencetNumber;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("TransactionCurrency")
    @Expose
    private String transactionCurrency;
    @SerializedName("Narration")
    @Expose
    private String narration;

    public DestinationIftAccountToAccount(String referencetNumber, String accountNumber, String amount, String transactionCurrency, String narration) {
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.transactionCurrency = transactionCurrency;
        this.narration = narration;
        this.referencetNumber = referencetNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getReferencetNumber() {
        return referencetNumber;
    }

    public void setReferencetNumber(String referencetNumber) {
        this.referencetNumber = referencetNumber;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getTransactionCurrency() {
        return transactionCurrency;
    }

    public void setTransactionCurrency(String transactionCurrency) {
        this.transactionCurrency = transactionCurrency;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

}
