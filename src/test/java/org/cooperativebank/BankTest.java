package org.cooperativebank;

import Exceptions.CooperativeBankApiException;
import datamodels.*;
import datamodelsresponses.TransactionStatus;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class BankTest {

    Bank bank = new Bank("ZNx2ybUcNwV8mYO_9YEy4fLLGW8a", "YhYzyvLOIl4_WeguyZ0_XxY6fi4a",Constants.sandbox );


    @Test
    void getToken() throws CooperativeBankApiException {
                assertEquals(bank.getToken(), bank.getToken());

    }

    @Test
    void getAccountBalance() throws CooperativeBankApiException {
        AccountBalance response = bank.getAccountBalance("40ca18c6765086089a11", "36001873000");


        assertEquals(0, response.getMessageCode());

    }

    @Test
    void getAccountFullStatement() throws CooperativeBankApiException {

        AccountFullStatement response = bank.getAccountFullStatement("40ca18c6765086089a1", "36001873000", "2020-03-01", "2020-08-20");

       assertEquals(0, response.getMessageCode());
    }

    @Test
    void getAccountMiniStatement() throws CooperativeBankApiException {
        AccountMiniStatement response = bank.getAccountMiniStatement("40ca18c6765086089a1", "36001873000");

        assertEquals(0, response.getMessageCode());

    }

    @Test
    void getAccountTransactions() throws CooperativeBankApiException {

        AccountTransactions response = bank.getAccountTransactions("40ca18c6765086089a1", "36001873000", 1);


        assertEquals(0, response.getMessageCode());
    }

    @Test
    void validateAccount() throws CooperativeBankApiException {

        AccountValidation response = bank.validateAccount("40ca18c6765086089a1", "36001873000" );

        assertEquals(0, response.getMessageCode());

    }

    @Test
    void getExchangeRate() throws CooperativeBankApiException {
        ExchangeRate response = bank.getExchangeRate("40ca18c6765086089a1", "KES", "GBP" );


        assertEquals(0, response.getMessageCode());

    }

    @Test
    void transferIftAccountToAccount() throws CooperativeBankApiException {

        ArrayList<DestinationIftAccountToAccount> list = new ArrayList<>();
        list.add(new DestinationIftAccountToAccount("40ca18c6765086089cIsaf1_8", "54321987654321","777" , "KES", "Electricity Payment"));

        IftAccountToAccount response = bank.transferIftAccountToAccount("40ca18c6765086089f8", "https://8c63ab72ef35.ngrok.io/coop/processpayment.php", new Source("36001873000", "777", "KES", "Supplier Payment"), list);

        assertEquals(0, response.getMessageCode());
    }

    @Test
    void transferFromPesaLinkToAccount() throws CooperativeBankApiException {

        ArrayList<DestinationPesaLinkToAccount> list = new ArrayList<>();
        list.add(new DestinationPesaLinkToAccount("40ca18c6765086089cIsaz1_4", "54321987654321", "11", "777" , "KES", "Electricity Payment"));

        PesaLinkToAccount response = bank.transferFromPesaLinkToAccount("40ca18c6765086089fw", "https://8c63ab72ef35.ngrok.io/coop/processpayment.php", new Source("36001873000", "777", "KES", "Supplier Payment"), list);
        assertEquals(0, response.getMessageCode());
    }

    @Test
    void transferFromPesaLinkToPhone() throws CooperativeBankApiException {

        ArrayList<DestinationPesaLinkSendToPhone> list = new ArrayList<>();
        list.add(new DestinationPesaLinkSendToPhone("40ca18c6765086089cIsad1_4", "0713442462", "777" , "KES", "Electricity Payment"));

        PesaLinkSendToPhone response = bank.transferFromPesaLinkToPhone("40ca18c6765086089fv", "none", new Source("36001873000", "777", "KES", "Supplier Payment"), list);
        assertEquals(0, response.getMessageCode());

    }

    @Test
    void sendToMpesa() throws CooperativeBankApiException {
        ArrayList<DestinationMpesa> list = new ArrayList<>();
        list.add(new DestinationMpesa("40ca18c6765086089cIsar1_g", "254710876311", "777" , "KES", "Electricity Payment"));

        SendToMpesa response = bank.sendToMpesa("40ca18c6765086089ft", "https://8635c79dc561.ngrok.io/coop/processpayment.php", new Source("36001873000", "777", "KES", "Supplier Payment"), list);
        assertEquals(0, response.getMessageCode());
    }

    @Test
    void checkTransactionStatus() throws CooperativeBankApiException {
        TransactionStatus response = bank.checkTransactionStatus("40ca18c6765086089a1");
        assertEquals(0, response.getMessageCode());
            }
}