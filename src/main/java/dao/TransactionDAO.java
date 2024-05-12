package dao;

import entity.Transaction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;


public class TransactionDAO {
    private static final EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("CurrencyConverterPU");
    private EntityManager em;

    public TransactionDAO() {
        this.em = emFactory.createEntityManager();
    }

    public void persist(Transaction transaction) {
        try {
            em.getTransaction().begin();
            em.persist(transaction);
            em.getTransaction().commit();
        } finally {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        }
    }

    // Close EntityManager
    public void close() {
        if (em != null && em.isOpen()) {
            em.close();
        }
    }

    // Static method to close EntityManagerFactory
    public static void closeFactory() {
        if (emFactory != null && emFactory.isOpen()) {
            emFactory.close();
        }
    }
}
