/**
 * An api wrapper for the cooperative bank api (coopconnect)
 * by Isaac Sichangi
 * isaacsichangi@gmail.com
 */


package org.cooperativebank;


import Exceptions.CooperativeBankApiException;
import com.google.gson.Gson;
import datamodels.*;
import datamodels.Source;
import datamodelsresponses.*;
import kong.unirest.*;
import kong.unirest.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

import static org.cooperativebank.Constants.*;

public class Bank {

    protected String consumerKey;
    protected String consmerSecret;
    protected int env;
    protected String host;
    protected Gson gson;


    public Bank(String consumerKey, String consmerSecret, int env) {
        gson = new Gson();
        this.consumerKey = consumerKey;
        this.consmerSecret = consmerSecret;
        this.env = env;
        host = "https://developer.co-opbank.co.ke:" + env;

    }


    /**
     * @return String
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */
    public String getToken() throws CooperativeBankApiException, UnirestException {

        String url = host + "/token";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .basicAuth(consumerKey, consmerSecret)
                .header("accept", Constants.json)
                .field("grant_type", "client_credentials")
                .asString();

        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");

            if (contenttype.get(0).contains(Constants.json)) {

                Token token = gson.fromJson(response.getBody(), Token.class);

                return token.getAccess_token();

            } else {

                throw new CooperativeBankApiException(response.getBody());

            }

        } else if (response.getStatus() == HTTP_401) {
            TokenError tokenError = gson.fromJson(response.getBody(), TokenError.class);

            throw new CooperativeBankApiException(tokenError.getError_description());


        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }


    }


    /**
     * @param MessageReference
     * @param AccountNumber
     * @return AccountBalance
     * @throws CooperativeBankApiException
     */
    public AccountBalance getAccountBalance(String MessageReference, String AccountNumber) throws CooperativeBankApiException, UnirestException {
        String url = host + "/Enquiry/AccountBalance/1.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new AccountBalanceParameters(MessageReference, AccountNumber))
                .asString();

        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {

                JSONObject jsonObject = new JSONObject(response.getBody());

                if (jsonObject.has(BOOKED_BALANCE)) {

                    return gson.fromJson(response.getBody(), AccountBalance.class);

                } else {

                    ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
                    throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());


                }

            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }

    }


    /**
     * @param MessageReference
     * @param AccountNumber
     * @param StartDate
     * @param EndDate
     * @return AccountFullStatement
     * @throws CooperativeBankApiException
     */
    public AccountFullStatement getAccountFullStatement(String MessageReference, String AccountNumber, String StartDate, String EndDate) throws CooperativeBankApiException, UnirestException {
        String url = host + "/Enquiry/FullStatement/Account/1.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new AccountFullStatementParameters(MessageReference, AccountNumber, StartDate, EndDate))
                .asString();


        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {

                JSONObject jsonObject = new JSONObject(response.getBody());

                if (jsonObject.has(ACCOUNT_NUMBER)) {

                    return gson.fromJson(response.getBody(), AccountFullStatement.class);

                } else {

                    ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
                    throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());


                }

            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }


    }


    /**
     * @param MessageReference
     * @param AccountNumber
     * @return AccountMiniStatement
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */
    public AccountMiniStatement getAccountMiniStatement(String MessageReference, String AccountNumber) throws CooperativeBankApiException, UnirestException {
        String url = host + "/Enquiry/MiniStatement/Account/1.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new AccountMiniStatementParameters(MessageReference, AccountNumber))
                .asString();
        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {

                JSONObject jsonObject = new JSONObject(response.getBody());

                if (jsonObject.has(ACCOUNT_NUMBER)) {

                    return gson.fromJson(response.getBody(), AccountMiniStatement.class);

                } else {

                    ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
                    throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());


                }

            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }


    }


    /**
     * @param MessageReference
     * @param AccountNumber
     * @param NoOfTransactions
     * @return AccountTransactions
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */

    public AccountTransactions getAccountTransactions(String MessageReference, String AccountNumber, int NoOfTransactions) throws CooperativeBankApiException, UnirestException {
        String url = host + "/Enquiry/AccountTransactions/1.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new AccountTransactionsParamaters(MessageReference, AccountNumber, NoOfTransactions))
                .asString();


        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {

                JSONObject jsonObject = new JSONObject(response.getBody());

                if (jsonObject.has(ACCOUNT_NUMBER)) {

                    return gson.fromJson(response.getBody(), AccountTransactions.class);

                } else {

                    ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
                    throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());


                }

            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }


    }


    /**
     * @param MessageReference
     * @param AccountNumber
     * @return AccountValidation
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */
    public AccountValidation validateAccount(String MessageReference, String AccountNumber) throws CooperativeBankApiException, UnirestException {
        String url = host + "/Enquiry/Validation/Account/1.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new AccountValidationParameters(MessageReference, AccountNumber))
                .asString();


        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {


                return gson.fromJson(response.getBody(), AccountValidation.class);


            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }


    }


    /**
     * @param MessageReference
     * @param FromCurrencyCode
     * @param ToCurrencyCode
     * @return ExchangeRate
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */
    public ExchangeRate getExchangeRate(String MessageReference, String FromCurrencyCode, String ToCurrencyCode) throws CooperativeBankApiException, UnirestException {
        String url = host + "/Enquiry/ExchangeRate/1.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new ExchangeRateParameters(MessageReference, FromCurrencyCode, ToCurrencyCode))
                .asString();

        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {

                JSONObject jsonObject = new JSONObject(response.getBody());

                if (jsonObject.has(RATE)) {

                    return gson.fromJson(response.getBody(), ExchangeRate.class);

                } else {

                    ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
                    throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

                }

            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }

    }


    /**
     * @param messageReference
     * @param callBackUrl
     * @param source
     * @param destinations
     * @return IftAccountToAccount
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */
    public IftAccountToAccount transferIftAccountToAccount(String messageReference, String callBackUrl, Source source, ArrayList<DestinationIftAccountToAccount> destinations) throws CooperativeBankApiException, UnirestException {
        String url = host + "/FundsTransfer/Internal/A2A/2.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new IftAccountToAccountParameters(messageReference, callBackUrl, source, destinations))
                .asString();


        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {


                return gson.fromJson(response.getBody(), IftAccountToAccount.class);


            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_403) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_404) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_409) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }

    }


    /**
     * @param messageReference
     * @param callBackUrl
     * @param source
     * @param destinations
     * @return PesaLinkToAccount
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */

    public PesaLinkToAccount transferFromPesaLinkToAccount(String messageReference, String callBackUrl, Source source, ArrayList<DestinationPesaLinkToAccount> destinations) throws CooperativeBankApiException, UnirestException {
        String url = host + "/FundsTransfer/External/A2A/PesaLink/1.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new PesaLinkToAccountParameters(messageReference, callBackUrl, source, destinations))
                .asString();

        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {


                return gson.fromJson(response.getBody(), PesaLinkToAccount.class);


            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_403) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_404) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_409) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }


    }


    /**
     * @param messageReference
     * @param callBackUrl
     * @param source
     * @param destinations
     * @return PesaLinkSendToPhone
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */
    public PesaLinkSendToPhone transferFromPesaLinkToPhone(String messageReference, String callBackUrl, Source source, ArrayList<DestinationPesaLinkSendToPhone> destinations) throws CooperativeBankApiException, UnirestException {
        String url = host + "/FundsTransfer/External/A2M/PesaLink/1.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new PesaLinkToPhoneParameters(messageReference, callBackUrl, source, destinations))
                .asString();


        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {


                return gson.fromJson(response.getBody(), PesaLinkSendToPhone.class);


            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_403) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_404) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_409) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }
    }


    /**
     * @param messageReference
     * @param callBackUrl
     * @param source
     * @param destinations
     * @return SendToMpesa
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */
    public SendToMpesa sendToMpesa(String messageReference, String callBackUrl, Source source, ArrayList<DestinationMpesa> destinations) throws CooperativeBankApiException, UnirestException {
        String url = host + "/FundsTransfer/External/A2M/Mpesa/v1.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new SendToMpesaParameters(messageReference, callBackUrl, source, destinations))
                .asString();


        if (response.getStatus() == HTTP_200) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {


                return gson.fromJson(response.getBody(), SendToMpesa.class);


            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_403) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_404) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_409) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }

    }

    /**
     * @param messageReference
     * @return TransactionStatus
     * @throws CooperativeBankApiException
     * @throws UnirestException
     */
    public TransactionStatus checkTransactionStatus(String messageReference) throws CooperativeBankApiException, UnirestException {
        String url = host + "/Enquiry/TransactionStatus/2.0.0";

        Unirest.config().verifySsl(false);
        HttpResponse<String> response = Unirest.post(url)
                .header("Authorization", "Bearer " + getToken())
                .header("accept", Constants.json)
                .header("Content-Type", Constants.json)
                .body(new TransactionStatusParameters(messageReference))
                .asString();

        if (response.getStatus() == HTTP_200 || response.getStatus() == HTTP_207) {

            List<String> contenttype = response.getHeaders().get("Content-Type");


            if (contenttype.get(0).contains(Constants.json)) {


                return gson.fromJson(response.getBody(), TransactionStatus.class);


            } else {

                throw new CooperativeBankApiException(response.getStatus() + " " + response.getBody());

            }

        } else if (response.getStatus() == HTTP_102) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());


        } else if (response.getStatus() == HTTP_400) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());

        } else if (response.getStatus() == HTTP_401) {
            Fault fault = gson.fromJson(response.getBody(), Fault.class);

            throw new CooperativeBankApiException(fault.getCode() + " " + fault.getDescription());

        } else if (response.getStatus() == HTTP_404) {

            ErrorResponse errorResponse = gson.fromJson(response.getBody(), ErrorResponse.class);
            throw new CooperativeBankApiException(errorResponse.getMessageCode() + " " + errorResponse.getMessageDescription());


        } else if (response.getStatus() == HTTP_405) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());

        } else if (response.getStatus() == HTTP_408) {
            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());


        } else {

            throw new CooperativeBankApiException(response.getStatus() + ":" + response.getBody());
        }


    }

}
