package datamodels;

public class ExchangeRate {

    private String MessageReference;
    private String MessageDateTime;
    private int MessageCode;
    private String MessageDescription;
    private String FromCurrencyCode;
    private String ToCurrencyCode;
    private String RateType;
    private double Rate;
    private double Tolerance;
    private String MultiplyDivide;

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

    public String getFromCurrencyCode() {
        return FromCurrencyCode;
    }

    public void setFromCurrencyCode(String fromCurrencyCode) {
        FromCurrencyCode = fromCurrencyCode;
    }

    public String getToCurrencyCode() {
        return ToCurrencyCode;
    }

    public void setToCurrencyCode(String toCurrencyCode) {
        ToCurrencyCode = toCurrencyCode;
    }

    public String getRateType() {
        return RateType;
    }

    public void setRateType(String rateType) {
        RateType = rateType;
    }

    public double getRate() {
        return Rate;
    }

    public void setRate(double rate) {
        Rate = rate;
    }

    public double getTolerance() {
        return Tolerance;
    }

    public void setTolerance(double tolerance) {
        Tolerance = tolerance;
    }

    public String getMultiplyDivide() {
        return MultiplyDivide;
    }

    public void setMultiplyDivide(String multiplyDivide) {
        MultiplyDivide = multiplyDivide;
    }
}
