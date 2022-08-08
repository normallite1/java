import org.junit.After;
import org.junit.Before;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.concurrent.Callable;

public abstract class BaseTest {
    private static final String NAME = "JPATest";

    public EntityManagerFactory emFactory;
    public EntityManager em;

    @After
    public void init(){
        emFactory = Persistence.createEntityManagerFactory(NAME);
        em = emFactory.createEntityManager();
    }
    @Before
    public void finish(){
      if(em != null) em.close();
      if(emFactory != null) emFactory.close();
    }
    protected <T> T performTransaction(Callable<T> action){
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        try{
            T result = action.call();
            transaction.commit();

            return result;
        } catch (Exception e) {
            if(transaction.isActive())
                transaction.rollback();
            throw new RuntimeException(e);
        }
    }
}
