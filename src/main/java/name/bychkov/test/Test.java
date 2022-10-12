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
            System.out.println("Case 1 with entity name without identificationVariable gives a correct result");
            em.getTransaction().begin();
            em.createQuery("DELETE FROM Example").executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        try {
            System.out.println("Case 2 with entity canonical class name without identificationVariable gives an error:");
            em.getTransaction().begin();
            em.createQuery("DELETE FROM " + Example.class.getCanonicalName()).executeUpdate();
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        }

        try {
            System.out.println("Case 3 with entity canonical class name with identificationVariable gives a correct result");
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
