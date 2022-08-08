
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.hibernate.jpa.HibernateQuery;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EntityManagerFactory  emFactory = Persistence.createEntityManagerFactory("JPATest");
        EntityManager em = emFactory.createEntityManager();
        AbstractDao dao = new AbstractDao(emFactory, em);
        Session session;

        try {
            while (true) {
                System.out.println("Press 1 add new Client");
                System.out.println("Press 2 add new transaction");
                String string = scanner.nextLine();

                switch (string) {
                    case "1" :
                        AbstractDao.addNewClient(scanner);
                        break;
                    case "2" :
                        AbstractDao.transactions(scanner);
                        break;
                    default :
                        return;
                }
            }

        }catch (RuntimeException ex) {
            throw new RuntimeException(ex);
        } finally {
            emFactory.close();
           if (em != null) em.close();
           scanner.close();

        }
    }
}