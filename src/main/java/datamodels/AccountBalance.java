package datamodels;

public class AccountBalance {

    private String MessageReference;
    private String MessageDateTime;
    private int MessageCode;
    private String MessageDescription;
    private String AccountNumber;
    private String AccountName;
    private String Currency;
    private String ProductName;
    private double ClearedBalance;
    private double BookedBalance;
    private double BlockedBalance;
    private double AvailableBalance;
    private double ArrearsAmount;
    private String BranchName;
    private String BranchSortCode;
    private double AverageBalance;
    private double UnclearedBalance;
    private double ODLimit;
    private double CreditLimit;

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

    public String getAccountNumber() {
        return AccountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        AccountNumber = accountNumber;
    }

    public String getAccountName() {
        return AccountName;
    }

    public void setAccountName(String accountName) {
        AccountName = accountName;
    }

    public String getCurrency() {
        return Currency;
    }

    public void setCurrency(String currency) {
        Currency = currency;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public double getClearedBalance() {
        return ClearedBalance;
    }

    public void setClearedBalance(double clearedBalance) {
        ClearedBalance = clearedBalance;
    }

    public double getBookedBalance() {
        return BookedBalance;
    }

    public void setBookedBalance(double bookedBalance) {
        BookedBalance = bookedBalance;
    }

    public double getBlockedBalance() {
        return BlockedBalance;
    }

    public void setBlockedBalance(double blockedBalance) {
        BlockedBalance = blockedBalance;
    }

    public double getAvailableBalance() {
        return AvailableBalance;
    }

    public void setAvailableBalance(double availableBalance) {
        AvailableBalance = availableBalance;
    }

    public double getArrearsAmount() {
        return ArrearsAmount;
    }

    public void setArrearsAmount(double arrearsAmount) {
        ArrearsAmount = arrearsAmount;
    }

    public String getBranchName() {
        return BranchName;
    }

    public void setBranchName(String branchName) {
        BranchName = branchName;
    }

    public String getBranchSortCode() {
        return BranchSortCode;
    }

    public void setBranchSortCode(String branchSortCode) {
        BranchSortCode = branchSortCode;
    }

    public double getAverageBalance() {
        return AverageBalance;
    }

    public void setAverageBalance(double averageBalance) {
        AverageBalance = averageBalance;
    }

    public double getUnclearedBalance() {
        return UnclearedBalance;
    }

    public void setUnclearedBalance(double unclearedBalance) {
        UnclearedBalance = unclearedBalance;
    }

    public double getODLimit() {
        return ODLimit;
    }

    public void setODLimit(double ODLimit) {
        this.ODLimit = ODLimit;
    }

    public double getCreditLimit() {
        return CreditLimit;
    }

    public void setCreditLimit(double creditLimit) {
        CreditLimit = creditLimit;
    }
}
