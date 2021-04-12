package datamodels;

public class ExchangeRateParameters {
    private String MessageReference;
    private String FromCurrencyCode;
    private String ToCurrencyCode;

    public ExchangeRateParameters(String messageReference, String fromCurrencyCode, String toCurrencyCode) {
        MessageReference = messageReference;
        FromCurrencyCode = fromCurrencyCode;
        ToCurrencyCode = toCurrencyCode;
    }

    public String getMessageReference() {
        return MessageReference;
    }

    public void setMessageReference(String messageReference) {
        MessageReference = messageReference;
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
}
