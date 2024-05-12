package application;

import dao.TransactionDAO;
import entity.Currency;
import entity.Transaction;

public class CurrencyConverterApp {
    public static void main(String[] args) {
        CurrencyConverterApp app = new CurrencyConverterApp();
        Currency sourceCurrency = new Currency("EUR");
        Currency targetCurrency = new Currency("SEK");
        double amountToConvert = 100.0;

        app.handleConversion(amountToConvert, sourceCurrency, targetCurrency);
    }

    public void handleConversion(double amount, Currency source, Currency target) {
        TransactionDAO transactionDAO = new TransactionDAO();
        try {
            Transaction transaction = new Transaction(amount, source, target);
            transactionDAO.persist(transaction);
            System.out.println("Transaction persisted successfully.");
        } finally {
            transactionDAO.close();
        }
    }
}
