package datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Transaction {

    @SerializedName("TransactionId")
    @Expose
    private String transactionId;
    @SerializedName("TransactionDate")
    @Expose
    private String transactionDate;
    @SerializedName("ValueDate")
    @Expose
    private String valueDate;
    @SerializedName("Narration")
    @Expose
    private String narration;
    @SerializedName("TransactionType")
    @Expose
    private String transactionType;
    @SerializedName("ServicePoint")
    @Expose
    private String servicePoint;
    @SerializedName("TransactionReference")
    @Expose
    private String transactionReference;
    @SerializedName("CreditAmount")
    @Expose
    private String creditAmount;
    @SerializedName("DebitAmount")
    @Expose
    private String debitAmount;
    @SerializedName("RunningClearedBalance")
    @Expose
    private String runningClearedBalance;
    @SerializedName("RunningBookBalance")
    @Expose
    private String runningBookBalance;
    @SerializedName("DebitLimit")
    @Expose
    private String debitLimit;
    @SerializedName("LimitExpiryDate")
    @Expose
    private String limitExpiryDate;

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(String transactionDate) {
        this.transactionDate = transactionDate;
    }

    public String getValueDate() {
        return valueDate;
    }

    public void setValueDate(String valueDate) {
        this.valueDate = valueDate;
    }

    public String getNarration() {
        return narration;
    }

    public void setNarration(String narration) {
        this.narration = narration;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public String getServicePoint() {
        return servicePoint;
    }

    public void setServicePoint(String servicePoint) {
        this.servicePoint = servicePoint;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }

    public String getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(String creditAmount) {
        this.creditAmount = creditAmount;
    }

    public String getDebitAmount() {
        return debitAmount;
    }

    public void setDebitAmount(String debitAmount) {
        this.debitAmount = debitAmount;
    }

    public String getRunningClearedBalance() {
        return runningClearedBalance;
    }

    public void setRunningClearedBalance(String runningClearedBalance) {
        this.runningClearedBalance = runningClearedBalance;
    }

    public String getRunningBookBalance() {
        return runningBookBalance;
    }

    public void setRunningBookBalance(String runningBookBalance) {
        this.runningBookBalance = runningBookBalance;
    }

    public String getDebitLimit() {
        return debitLimit;
    }

    public void setDebitLimit(String debitLimit) {
        this.debitLimit = debitLimit;
    }

    public String getLimitExpiryDate() {
        return limitExpiryDate;
    }

    public void setLimitExpiryDate(String limitExpiryDate) {
        this.limitExpiryDate = limitExpiryDate;
    }

}
