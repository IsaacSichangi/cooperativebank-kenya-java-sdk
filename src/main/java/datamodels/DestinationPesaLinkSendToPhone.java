package datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DestinationPesaLinkSendToPhone {

    @SerializedName("ReferenceNumber")
    @Expose
    private String referenceNumber;
    @SerializedName("PhoneNumber")
    @Expose
    private String phoneNumber;

    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("TransactionCurrency")
    @Expose
    private String transactionCurrency;
    @SerializedName("Narration")
    @Expose
    private String narration;


    public DestinationPesaLinkSendToPhone(String referenceNumber, String phoneNumber, String amount, String transactionCurrency, String narration) {
        this.referenceNumber = referenceNumber;
        this.phoneNumber = phoneNumber;
        this.amount = amount;
        this.transactionCurrency = transactionCurrency;
        this.narration = narration;
    }

    public String getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(String referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
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