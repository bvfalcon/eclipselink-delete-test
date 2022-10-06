package name.bychkov.test;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class Test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        System.out.println("Starting test");
        try {
            System.out.println("Case without identificationVariable gives an error:");
            em.getTransaction().begin();
            em.createQuery("DELETE FROM " + Example.class.getCanonicalName()).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        try {
            System.out.println("Case with identificationVariable works correctly:");
            em.getTransaction().begin();
            em.createQuery("DELETE FROM " + Example.class.getCanonicalName() + " x").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }
        System.out.println("Test finished");

        em.close();
        emf.close();
    }
}
