package application;

import entity.Currency;
import jakarta.persistence.EntityManager;
import datasource.DatabaseConnector;

public class CurrencyConverter {
    public static void main(String[] args) {
        // Create a DatabaseConnector instance
        DatabaseConnector dbConnector = new DatabaseConnector();

        // Get an EntityManager from the DatabaseConnector
        EntityManager em = dbConnector.getEntityManager();

        // Fetch currencies from the database
        Currency eur = em.find(Currency.class, "EUR");
        Currency sek = em.find(Currency.class, "SEK");
        double amount = 100;

        if (eur != null && sek != null) {
            // Perform the conversion
            double convertedAmount = amount * (sek.getExchangeRate() / eur.getExchangeRate());
            System.out.printf("%.2f %s = %.2f %s%n", amount, eur.getCode(), convertedAmount, sek.getCode());
        } else {
            System.out.println("Currency not found in the database.");
        }

        // Close the EntityManager
        em.close();
    }
}
