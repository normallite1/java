import org.junit.Test;

import java.util.concurrent.Callable;

import static org.junit.Assert.*;

public class SimpleTest extends BaseTest {

    private Client saveTestClients(String name){
        Callable<Client> c = new Callable<Client>(){
            public Client call() throws Exception {
                Client client = new Client(name);
                em.persist(client);
                return client;
            }
        };
        return performTransaction(c);
        }
        @Test
        public void saveTestClient(){
        Client client = saveTestClients("Vova");

        Integer id = client.getId();
        assertTrue(id>0);

        Client other = em.find(Client.class, id);
        assertNotNull(other);
        assertEquals(client.getName(),other.getName());

        em.clear();
        }
    }


