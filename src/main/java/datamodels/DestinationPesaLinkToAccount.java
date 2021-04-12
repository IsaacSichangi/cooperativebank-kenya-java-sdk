package datamodels;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class DestinationPesaLinkToAccount {

    @SerializedName("ReferenceNumber")
    @Expose
    private String referenceNumber;
    @SerializedName("AccountNumber")
    @Expose
    private String accountNumber;
    @SerializedName("BankCode")
    @Expose
    private String bankCode;
    @SerializedName("Amount")
    @Expose
    private String amount;
    @SerializedName("TransactionCurrency")
    @Expose
    private String transactionCurrency;
    @SerializedName("Narration")
    @Expose
    private String narration;


    public DestinationPesaLinkToAccount(String referenceNumber, String accountNumber, String bankCode, String amount, String transactionCurrency, String narration) {
        this.referenceNumber = referenceNumber;
        this.accountNumber = accountNumber;
        this.bankCode = bankCode;
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

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
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