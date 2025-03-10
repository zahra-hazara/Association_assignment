package dao;

import entity.Currency;
import entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class CurrencyService {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("your-persistence-unit-name");

    public void convertAndStoreTransaction(String sourceCurrencyCode, String targetCurrencyCode, double amount) {
        EntityManager em = emf.createEntityManager();

        // Fetch the source and target currencies
        Currency sourceCurrency = em.find(Currency.class, sourceCurrencyCode);
        Currency targetCurrency = em.find(Currency.class, targetCurrencyCode);

        if (sourceCurrency != null && targetCurrency != null) {
            // Perform the conversion
            double convertedAmount = amount * (targetCurrency.getExchangeRate() / sourceCurrency.getExchangeRate());
            System.out.printf("%.2f %s = %.2f %s%n", amount, sourceCurrency.getCode(), convertedAmount, targetCurrency.getCode());

            // Create and persist the transaction
            Transaction transaction = new Transaction(sourceCurrency, targetCurrency, amount);
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit();
        } else {
            System.out.println("Currency not found in the database.");
        }

        // Close the EntityManager
        em.close();
    }
}