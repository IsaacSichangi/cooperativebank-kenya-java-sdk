<img src = "https://www.dukapos.co.ke/images/coop.png" alt = "cooperative bank kenya">

# cooperative bank kenya java sdk
This is a Java wrapper for the cooperative bank [coop connect api](https://developer.co-opbank.co.ke:9443/store/apis/home)

## Installation

### Requirements
- Java 1.8 or later

### Others
-Create an account at the [coop connect developer portal](https://developer.co-opbank.co.ke:9443/store/apis/home) and create an application in order to get your **CONSUMER KEY** and **CONSUMER SECRET** credentials
also remember to subscribe to the APIS you would wish to use in the developer portal
## Usage

### Initialization

```java
Bank bank = new Bank("CONSUMER KEY", "CONSUMER_SECRET", Constants.sandbox );
```
**NB** remember to change to **Constants.live** when going live

### Account Balance

[Account Balance Enquiry API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=AccountBalance&version=1.0.0&provider=admin) will enable you to enquire about your own Co-operative Bank accounts' balance as at now for the specified account number

**EXAMPLE**

```java
AccountBalance response = bank.getAccountBalance("MESSAGE REFERENCE", "ACCOUNT NUMBER");
```

### Account Full Statement

[Account Full Statement Enquiry API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=AccountFullStatement&version=1.0.0&provider=admin) will enable you to enquire about your own Co-operative Bank accounts' full statement for the specified account number, start date and end date

**EXAMPLE**

```java
 AccountFullStatement response = bank.getAccountFullStatement("MESSAGE REFERENCE", "ACCOUNT NUMBER", "STARTDATE", "ENDDATE");


```
### Account Mini Statement
[Account Mini Statement Enquiry API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=AccountMiniStatement&version=1.0.0&provider=admin) will enable you to enquire about your own Co-operative Bank accounts' Mini statement for the specified account number

**EXAMPLE**

```java
AccountMiniStatement response = bank.getAccountMiniStatement("MESSAGE REFERENCE", "ACCOUNT NUMBER");


```

### Account Transactions

[Account Transactions Enquiry API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=AccountTransactions&version=1.0.0&provider=admin) will enable you to enquire about your own Co-operative Bank accounts' latest transactions for the specified account number and number of transactions to be returned

**EXAMPLE**

```java
 AccountTransactions response = bank.getAccountTransactions("MESSAGE REFERENCE", "ACCOUNT NUMBER", NUMBER OF TRANSACTIONS);

```
### Account Validation

[Account Validation Enquiry API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=AccountValidation&version=1.0.0&provider=admin) will enable you to validate a Co-operative Bank account number

**EXAMPLE**

```java
AccountValidation response = bank.validateAccount("MESSAGE REFERENCE", "ACCOUNT NUMBER" );
```

### Exchange rate

[Exchange Rate Enquiry API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=ExchangeRate&version=1.0.0&provider=admin) will enable you to enquire about the current SPOT exchange rate for the specified currencies

**EXAMPLE**

```java

ExchangeRate response = bank.getExchangeRate("MESSAGE REFERENCE", "FROM CURRENCY CODE", "TO CURRENCY CODE" );


```

### Internal Funds Transfer Account ToAccount

[Internal Funds Transfer Account to Account API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=IFTAccountToAccount&version=2.0.0&provider=admin) will enable you to transfer funds from your own Co-operative Bank account to other Co-operative Bank account(s)

**EXAMPLE**

```java
ArrayList<DestinationIftAccountToAccount> list = new ArrayList<>();
list.add(new DestinationIftAccountToAccount("REFERENCE NUMBER", "ACCOUNT NUMBER","AMOUNT" , "TRANSACTION CURRENCY", "NARRATION"));

IftAccountToAccount response = bank.transferIftAccountToAccount("MESSAGE REFERENCE", "CALLBACK URL", new Source("ACCOUNT NUMBER", "AMOUNT", "TRANSACTION CURRENCY", "NARRATION"), list);


```
### PesaLink To Account
[PesaLink Send to Account Funds Transfer API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=PesaLinkSendToAccount&version=1.0.0&provider=admin) will enable you to transfer funds from your own Co-operative Bank account to Bank account(s) in IPSL participating banks

**EXAMPLE**

```java
 ArrayList<DestinationPesaLinkToAccount> list = new ArrayList<>();
list.add(new DestinationPesaLinkToAccount("REFERENCE NUMBER", "ACCOUNT NUMBER","AMOUNT" , "TRANSACTION CURRENCY", "NARRATION"));

PesaLinkToAccount response = bank.transferFromPesaLinkToAccount("MESSAGE REFERENCE", "CALLBACK URL", new Source("ACCOUNT NUMBER", "AMOUNT", "TRANSACTION CURRENCY", "NARRATION"), list);

```

### PesaLink To Phone

[PesaLink Send to Phone Funds Transfer API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=PesaLinkSendToPhone&version=1.0.0&provider=admin) will enable you to transfer funds from your own Co-operative Bank account to a Phone Number(s) linked to a Bank account in an IPSL participating bank

**EXAMPLE**

```java
ArrayList<DestinationPesaLinkSendToPhone> list = new ArrayList<>();
list.add(new DestinationPesaLinkSendToPhone("REFERENCE NUMBER", "PHONENUMBER","AMOUNT" , "TRANSACTION CURRENCY", "NARRATION"));

PesaLinkSendToPhone response = bank.transferFromPesaLinkToPhone("MESSAGE REFERENCE", "CALLBACK URL", new Source("ACCOUNT NUMBER", "AMOUNT", "TRANSACTION CURRENCY", "NARRATION"), list);
       

```
### Send To Mpesa
[Send to M-Pesa Funds Transfer API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=SendToM-Pesa&version=1.0.0&provider=admin) will enable you to transfer funds from your own Co-operative Bank account to an M-Pesa account recipient

**EXAMPLE**

```java
 ArrayList<DestinationMpesa> list = new ArrayList<>();
 list.add(new DestinationMpesa("REFERENCE NUMBER", "PHONENUMBER","AMOUNT" , "TRANSACTION CURRENCY", "NARRATION"));

 SendToMpesa response = bank.sendToMpesa("MESSAGE REFERENCE", "CALLBACK URL", new Source("ACCOUNT NUMBER", "AMOUNT", "TRANSACTION CURRENCY", "NARRATION"), list);
      

```

### Transaction Status
[Transaction Status Enquiry API](https://developer.co-opbank.co.ke:9443/store/apis/info?name=TransactionStatus&version=2.0.0&provider=admin) will enable you to enquire about the status of a previously requested transaction for the specified transaction message reference

**EXAMPLE**

```java

 TransactionStatus response = bank.checkTransactionStatus("MESSAGE REFERENCE");

```

## Going Live
When ready to go live with your app/service send an email to [E-ChannelsandE-commerce@co-opbank.co.ke](mailto:E-ChannelsandE-commerce@co-opbank.co.ke) indicating the intention
to go live. A representative will send you  test cases for your application to test out and a merchant form which you will have to fill out in corder to comply with **KYC** requirements.
In addition they will whitelist your ip in order to enable you to receive call back requests for reconcilliation with your system.

## Other SDKS
[php](https://github.com/osenco/co-op)

## Help & Support
For any queries, help with integration or just general feedback :+1:


-Email [isaacsichangi@gmail.com](mailto:isaacsichangi@gmail.com)


